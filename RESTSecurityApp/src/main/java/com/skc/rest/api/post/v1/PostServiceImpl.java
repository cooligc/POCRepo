/**
 * 
 */
package com.skc.rest.api.post.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import com.skc.model.pojo.PostRequest;
import com.skc.model.pojo.PostResponse;

/**
 * <p>Post Implementation</p>
 * @author IgnatiusCipher
 * @version 1.0
 */
@Path("/posts")
public class PostServiceImpl implements PostService {

	List<PostRequest> postRequests = new ArrayList<PostRequest>();
	AtomicInteger atomicInteger = new AtomicInteger(0);
	@POST
	@Consumes(value={MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Produces(value={MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response createPost(PostRequest request) {
		request.setId(atomicInteger.incrementAndGet());
		postRequests.add(request);
		PostResponse postResponse = new PostResponse();
		postResponse.setMessage("Post Created Successfully");
		postResponse.setStatus("created");
		return Response.ok(Status.CREATED).entity(postResponse).build();
	}

	/* (non-Javadoc)
	 * @see com.skc.rest.api.post.v1.PostService#updatePost(com.skc.model.pojo.PostRequest)
	 */
	@Path("/{id}")
	@PUT
	@Consumes(value={MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Produces(value={MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response updatePost(@PathParam("id") Integer  id,PostRequest request) {
		boolean isFound=false;
		for(PostRequest postRequest2 : postRequests){
			isFound=true;
			if(postRequest2.getId()==id){
				isFound=false;
				postRequests.remove(postRequest2);
				PostRequest postRequest = new PostRequest();
				postRequest.setId(id);
				postRequest.setPostBody(request.getPostBody());
				postRequest.setPostedAt(request.getPostedAt());
				postRequest.setPostedBy(request.getPostedBy());
				postRequest.setPostTitle(request.getPostTitle());
				postRequests.add(postRequest);
			}
			
			if(!isFound){
				return Response.ok(Status.NOT_FOUND).entity("Id not found").build();
			}
		}
		PostResponse postResponse = new PostResponse();
		postResponse.setMessage(id+" is successfully Updated");
		postResponse.setStatus("Post Updated");
		return Response.ok().entity(postResponse).build();
	}

	@Path("/{id}")
	@DELETE
	public Response deletePost(@PathParam("id") Integer id) {
		boolean isFound=false;
		for(PostRequest postRequest2 : postRequests){
			isFound=true;
			if(postRequest2.getId()==id){
				isFound=false;
				postRequests.remove(postRequest2);
			}
			
			if(!isFound){
				return Response.ok(Status.NOT_FOUND).entity("Id not found").build();
			}
		}
		PostResponse postResponse = new PostResponse();
		postResponse.setMessage(id+" is successfully Deleted");
		postResponse.setStatus("Post Deleted");
		return Response.ok().entity(postResponse).build();
	}

	@Path("/{id}")
	@GET
	@Produces(value={MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response getPost(@PathParam("id") Integer id) {
		boolean isFound=false;
		Response response = null;
		for(PostRequest postRequest2 : postRequests){
			isFound=true;
			if(postRequest2.getId()==id){
				isFound=false;
				response = Response.ok().entity(postRequest2).build();
			}
			
			if(!isFound){
				return Response.ok(Status.NOT_FOUND).entity("Id not found").build();
			}
		}
		return response;
	}

	@GET
	@Produces(value={MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response getPosts() {
		ResponseBuilder response = Response.ok();
		for(PostRequest postRequest2 : postRequests){
				response = response.entity(postRequest2);
		}
		return response.build();
	}

}
