// Борьба со значением null

import java.io.*;

public class NullObject{
	public static void main(String[] args){
		
	}

	static Animal getAnimal(){
		try{
			if (new File("noFile").exists()){
				// Если файл существует, то работа производится
				return new Lion();
			}
		}
		finally{
			return new NoAnimal();
		}
	}
}

interface Animal{
	void eat();
}

class Lion implements Animal{
	@Override
	public void eat(){
		System.out.println("Lion eat");
	}
}

class NoAnimal implements Animal{
	@Override
	public void eat(){

	}
}