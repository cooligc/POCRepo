package com.skc.doubleton;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OneBilionPrime {
	public static void main(String[] args) {
		List<Integer> lists = new ArrayList<>();
		long time = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			lists.add(i);
		}
		System.out.println("Time take (input): "+(System.currentTimeMillis() - time));
		
		time = System.currentTimeMillis();
		System.out.println(lists.parallelStream().filter(num -> isPrime(num))
				  .collect(Collectors.toList()).size());
		System.out.println("Time take : "+(System.currentTimeMillis() - time));
		
		System.out.println(isPrime(5));
		
		
	}
	
	public static boolean isPrime(int num) {
		int count = 1;
		boolean response = true;
		if(num == 0 || num == 1) {
			response = false;
		}
		
		for(int i=2;i<=num ; ++i) {
			if(num % i == 0) {
				++count;
			}
			if(count > 2) {
				response = false;
				break;
			}
		}
		
		return response;
	}
}
