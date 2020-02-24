// Между интерфейсом и его реализацией появляется еще код,
// куда можно что то писать

public class Proxy{
	public static void main(String[] args) {
		CarI car = new CarProxy();
		car.drive();
	}
}

interface CarI{
	void drive();
}

class CarProxy implements CarI{
	CarI car = new Reno();

	@Override
	public void drive(){
		System.out.println("Overriding by CarProxy");
		car.drive();
	}
}

class Reno implements CarI{
	@Override
	public void drive() {
		System.out.println("Overriding by Reno");
	}
}