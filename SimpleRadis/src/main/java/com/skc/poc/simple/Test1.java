package com.skc.poc.simple;

import java.util.HashSet;
import java.util.List;

import com.skc.poc.simple.common.AppCommon;

import redis.clients.jedis.Jedis;

public class Test1 {
	public static void main(String[] args) {
		Jedis jedis = new Jedis(AppCommon.REDIS_HOST,AppCommon.REDIS_PORT);
		jedis.auth(AppCommon.REDIS_PASSWORD);
		test1(jedis);
		test2(jedis);
		test3(jedis);
		test4(jedis);
	}

	//Retriving the dbs
	private static void test4(Jedis jedis) {
		HashSet<String> list = (HashSet<String>) jedis.keys("*");
	    for (String string : list) {
			System.out.println(string);
		}
	}

	//Setting a list
	private static void test3(Jedis jedis) {
		jedis.lpush("test", "Hi");
		jedis.lpush("test", "Hello");
		jedis.lpush("test", "Awesome");
		List<String> values = jedis.lrange("test", 0, 4);
		for (String string : values) {
			System.out.println(string);
		}
	}

	//Set and get value in Redis
	private static void test2(Jedis jedis) {
		jedis.set("name", "Sitakant");
		System.out.println("Return value\t"+jedis.get("name"));
	}
	
	//Simple ping
	private static void test1(Jedis jedis) {
		System.out.println("Pinging ======>"+jedis.ping());
	}
}
