// Можно создавать объекты не на стадии компиляции,
// а в режиме runtime

public class Factory{
	public static void main(String[] args){
		CarFactory carFactory = new CarFactory();
		Car toyota = carFactory.create("Toyota");
		Car audi = carFactory.create("Audi");
		toyota.drive();
		audi.drive();
	}
}

interface Car{
	void drive();
}

class Toyota implements Car{
	@Override
	public void drive(){
		System.out.println("drive Toyota");
	}
}

class Audi implements Car{
	@Override
	public void drive(){
		System.out.println("drive Audi");
	}
}

class CarFactory{
	public Car create(String typeCar){
		switch (typeCar){
			case "Toyota": return new Toyota();
			case "Audi": return new Audi();
			default: return null;
		}
	}
}