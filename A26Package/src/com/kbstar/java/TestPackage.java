package com.kbstar.java;


// Generic Class
class Car<T>
{
	private T speed;
	private String name;
	
	
	
	public T getSpeed() 
	{
		return speed;
	}
	public void setSpeed(T speed) 
	{
		this.speed = speed;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}


	

}



public class TestPackage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Car<Double> taxi = new Car<Double>();
		Car<Integer> bus = new Car<Integer>();
		Car<String> truck = new Car<String>();
		
		taxi.setSpeed(10.1);
		bus.setSpeed(12);
		truck.setSpeed("น้");
		
		System.out.println(taxi.getSpeed());
		System.out.println(bus.getSpeed());
		System.out.println(truck.getSpeed());
		
		
	}

}
