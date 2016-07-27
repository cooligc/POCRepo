package org.skc.jvm.load.cache.manager;

import org.skc.jvm.load.cache.impl.KittyCache;

public class KittyCacheManager<K, V>{
	
	private static int MAX_SIZE=214748;
	private static final float LOAD_FACTOR=0.5f;
	private static KittyCache<?, ?> kittyCache;
	private static KittyCache<?, ?> _kittyCache;
	
	private KittyCacheManager(){};
	
	@SuppressWarnings("unchecked")
	public static <K,V> KittyCache<K, V> getKittyCache(){
		if(null == kittyCache){
			kittyCache = new KittyCache<K, V>(MAX_SIZE);
		}
		/*
		if(kittyCache.getCache().size() == 0.7*MAX_SIZE){
			MAX_SIZE*=LOAD_FACTOR;
			_kittyCache = new KittyCache<K, V>(MAX_SIZE);
			for (Entry<K, KittyCache.CacheEntry<V>> entry: kittyCache.getCache().keySet()) {
				_kittyCache.getCache().put(entry.getKey(), entry.getValue(), entry.getValue().getExpireBy());
			}
			_kittyCache.getCache().putAll(kittyCache.getCache());
					
		}*/
		
		
		return (KittyCache<K, V>) kittyCache;
	}

}
