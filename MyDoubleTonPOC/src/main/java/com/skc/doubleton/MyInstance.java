/**
 * 
 */
package com.skc.doubleton;

/**
 * @author chaudhsi
 *
 */
@Instance(number=2)
public class MyInstance{
	
	@InjectMe
	MyInstance2 instance2;
	
	public String printValue() {
		System.out.println("Instance executed "+ this + "<br/>"+instance2);
		return this.toString();
	}
	
}
