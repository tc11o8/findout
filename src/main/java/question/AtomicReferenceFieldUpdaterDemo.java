package question;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class AtomicReferenceFieldUpdaterDemo {

	public static void main(String[] args) throws Exception {
		
		/**
		 * AtomicReferenceFieldUpdater
		 * 一个基于反射的工具类，它能对指定类的指定的volatile引用字段进行原子更新。(注意这个字段不能是private的) 
		 */
        AtomicReferenceFieldUpdater<Dog, String> updater= AtomicReferenceFieldUpdater.newUpdater(
        		Dog.class,String.class,"name");  
        Dog dog1=new Dog();  
        updater.compareAndSet(dog1,dog1.name,"test") ;  
        System.out.println(dog1.name);  
    }  
}  

class Dog { 
   public volatile  String name="dog1";  
}  
