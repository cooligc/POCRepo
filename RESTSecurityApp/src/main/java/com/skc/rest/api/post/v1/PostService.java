package com.skc.rest.api.post.v1;

import javax.ws.rs.core.Response;

import com.skc.model.pojo.PostRequest;

/**
 * <p>Post service design having all the utility method to create the CURD</p>
 * @author IgnatiusCipher
 * @version 1.0
 * */
public interface PostService {
	Response createPost(PostRequest request);
	Response updatePost(Integer id,PostRequest request);
	Response deletePost(Integer id);
	Response getPost(Integer id);
	Response getPosts();
}
