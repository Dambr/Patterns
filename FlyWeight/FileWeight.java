// Если есть несколько однотипных объектов,
// то нет смыысла создавать объекты еще и еще.
// Можно использовать уже существующие

// Если есть машина красного цвета, то не надо
// создавать еще одну, нужно использовать
// существующую. Ей можно перевоспользоваться

import java.util.*;

public class FileWeight{
	public static void main(String[] args) {
		FlyWeightCollection flyWeightCollection = new FlyWeightCollection();
		Car car1 = flyWeightCollection.getCar("green");
		Car car2 = flyWeightCollection.getCar("green");
		System.out.println( car1.equals(car2) ); // true
	}
}

class Car{
	String color;
}

class FlyWeightCollection{
	Map<String, Car> map = new HashMap<>();
	Car getCar(String color){
		Car car = map.get(color);
		if (car == null){
			car = new Car();
			car.color = color;
			map.put(color, car);
		}
		return car;
	}
}