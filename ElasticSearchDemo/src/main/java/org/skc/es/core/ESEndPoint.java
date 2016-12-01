package org.skc.es.core;

import java.util.Map;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.node.Node;
import org.elasticsearch.node.NodeBuilder;
import org.springframework.stereotype.Component;

@Component
public class ESEndPoint {
	public Node getNode(){
		return NodeBuilder.nodeBuilder().node();
	}
	
	public Client getClient(){
		return getNode().client();
	}
	
	public IndexResponse createIndex(String indexName, String type, String id,Map<String,String> mapData){
		return getClient().prepareIndex(indexName,type,id).setSource(mapData,XContentType.JSON).execute().actionGet();
	}
	
}
