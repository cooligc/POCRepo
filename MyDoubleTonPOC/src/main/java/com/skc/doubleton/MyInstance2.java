package com.skc.doubleton;

@Instance(number=2)
public class MyInstance2 {
	
	public String print() {
		return "From 2 "+ this.toString();
	}
}
