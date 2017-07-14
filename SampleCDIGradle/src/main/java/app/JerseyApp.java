/**
 * 
 */
package app;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * @author sitakant
 *
 */
@ApplicationPath("/api/*")
public class JerseyApp extends ResourceConfig {
	public JerseyApp() {
		packages(true, "app","com.skc.api.provider.exception","com.skc.api.resource","com.skc.api.storage");
	}
}
