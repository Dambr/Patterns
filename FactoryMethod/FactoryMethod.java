//  Создает сам себя

public class FactoryMethod{
	public static void main(String[] args){
		Person p = Person.create();
	}
}

class Person{
	private Person(){
		System.out.println("New Person was created");
	}
	public static Person create(){
		return new Person();
	}
}