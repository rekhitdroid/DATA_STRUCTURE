 import java.lang.*;
 import java.util.*;
 import java.io.*;
 
 class Animal {
	int i=20;
	Animal(){
		System.out.println("Animal constructor called");// no-arg constructor is generated by compiler or else written by programmer 
	}
 }
 class Dog extends Animal implements Serializable {
	int j=40;
	Dog(){
		System.out.println("Dog Constructor Called");
	}
 }
 public class PussyDemo1 {
	public static void main(String [] args )throws Exception {
		Dog d1 = new Dog();
		d1.i=888;
		d1.j=999;
		
		FileOutputStream fos = new FileOutputStream("When_Child_Implements_Serializable.txt");//during serialization,The JVM puts the default value of variables of non-serialized class into file but puts the current value of variables of child class into file
		ObjectOutputStream oos = new ObjectOutputStream(fos);//written values in file are i =0.. j=999.
		oos.writeObject(d1);
		
		FileInputStream fis = new FileInputStream("When_Child_Implements_Serializable.txt");//at the time of desrialization,the JVM refers to non-serialized  class variables and put there values in output ,and its no-arg constructors are called of non-serializedclass .(constructors are necessary)//
		ObjectInputStream ois = new ObjectInputStream(fis);//output values from deserialization are i=20... but j=999.
		Dog d2 =(Dog)ois.readObject();
		
		System.out.println(d2.i+"..."+d2.j);
	}
 
 }