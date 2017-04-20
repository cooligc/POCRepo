package com.redhat.endpoint;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redhat.exception.IdNotMatchException;
import com.redhat.model.Bricks;
import com.redhat.model.Event;
import com.redhat.model.GlusterVolume;

@RestController
@RequestMapping("glusterVolumes")
public class GlusterVolumeEndpoint {

	private static final String STATUS_DOWN = "DOWN";
	private static final String STATUS_UP = "UP";
	private static final String ID_PATH = "/{id}";
	private static final String ID = "id";
	protected static List<GlusterVolume> volumes;

	static {
		volumes = new CopyOnWriteArrayList<GlusterVolume>();

		// Bootstrapping code 
		GlusterVolume vol = new GlusterVolume();

		vol.setName("Test");
		vol.setReplicaCount(2);
		vol.setStatus(STATUS_UP);
		vol.setUuid(UUID.randomUUID().toString());

		Set<Bricks> bricks = new HashSet<>();
		Set<Set<Bricks>> totalBricks = new HashSet<>();
		for (int i = 1; i <= vol.getReplicaCount() * 2; i++) {
			Bricks brick1 = new Bricks("A" + i, "test" + i, STATUS_UP);
			bricks.add(brick1);
			if ((i % vol.getReplicaCount() == 0)) {
				totalBricks.add(bricks);
				bricks = new HashSet<>();
			}
		}
		vol.setBricks(totalBricks);

		volumes.add(vol);
	}

	@GetMapping
	public List<GlusterVolume> getAll() {
		return volumes;
	}

	@PostMapping
	public GlusterVolume create(@RequestBody GlusterVolume volume) {
		volume.setUuid(UUID.randomUUID().toString());
		volumes.add(volume);
		return volume;
	}

	@PutMapping(ID_PATH)
	public GlusterVolume updateBricks(@PathVariable(ID) String uuid, @RequestBody Event event) {

		if(!uuid.equalsIgnoreCase(event.getVolumeId())){
			throw new IdNotMatchException("ERR_400","UUID should match with Volume Id");
		}
		
		GlusterVolume volume = null;

		for (GlusterVolume glusterVolume : volumes) {
			if (glusterVolume.getUuid().equalsIgnoreCase(uuid)) {
				volume = glusterVolume;
				for (Set<Bricks> bricks : glusterVolume.getBricks()) {
					for (Bricks brick : bricks) {
						if (brick.getServer().equals(event.getServer()) && brick.getDirectory().equals(event.getDirectory())) {
							brick.setStatus(event.getType());
							break;
						}
					}
				}
				break;
			}

		}
		
		boolean isUP = true;
		for (Set<Bricks> bricks : volume.getBricks()) {
			List<String> status = new ArrayList<>();
			for (Bricks brick : bricks) {
				status.add(brick.getStatus());
			}
			if (!status.contains(STATUS_UP)) {
				isUP = false;
			}
		}
		
		if(!isUP){
			volume.setStatus(STATUS_DOWN);
		}else{
			volume.setStatus(STATUS_UP);
		}

		return volume;
	}

}
