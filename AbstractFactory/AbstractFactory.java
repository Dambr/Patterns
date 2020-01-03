// Расширяет возможности паттерна Factory
// теперь можно создавать не объекты,
// а фабрики объектов в режиме runtime

public class AbstractFactory{
	public static void main(String[] args){
		new MyAbstractFactory().createFactory("Car").createCar("Audi").drive();
		new MyAbstractFactory().createFactory("Tank").createTank("T34").drive();
		new MyAbstractFactory().createFactory("Tank").createTank("KV").strike();
	}
}

// First factory

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

class CarFactory implements Factory{
	public Car createCar(String typeCar){
		switch (typeCar){
			case "Toyota": return new Toyota();
			case "Audi": return new Audi();
			default: return null;
		}
	}
	@Override
	public Tank createTank(String typeTank){
		return null;
	}
}

// Second factory

interface Tank{
	void drive();
	void strike();
}

class T34 implements Tank{
	@Override
	public void drive(){
		System.out.println("drive T34");
	}
	@Override
	public void strike(){
		System.out.println("T34: Fire!");
	}
}

class KV implements Tank{
	@Override
	public void drive(){
		System.out.println("drive KV");
	}
	@Override
	public void strike(){
		System.out.println("KV: Fire!");
	}
}

class TankFactory implements Factory{
	public Tank createTank(String typeTank){
		switch (typeTank){
			case "T34": return new T34();
			case "KV": return new KV();
			default: return null;
		}
	}
	@Override
	public Car createCar(String typeCar){
		return null;
	}
}

// Interfaces of Abstarct Factory

interface Factory{
	Car createCar(String typeCar);
	Tank createTank(String typeTank);
}

class MyAbstractFactory{
	public Factory createFactory(String typeFactory){
		switch(typeFactory){
			case "Car": return new CarFactory();
			case "Tank": return new TankFactory();
			default: return null;
		}
	}
}