// Обычная фильтрация по определенному критерию

import java.util.*;

public class Filter{
	public static void main(String[] args) {
		List<CarF> cars = List.of(
			new CarF(100, "red", 4),
			new CarF(150, "green", 2),
			new CarF(200, "blue", 4)
			);
		
		for (CarF car : new SpeedFilter().filter(cars)){
			System.out.println(car);
		}

		System.out.println("--------------------");

		for (CarF car : new ANDFilter(new SpeedFilter(), new DoorsFilter()).filter(cars)){
			System.out.println(car);
		}

		System.out.println("--------------------");

		for (CarF car : new ORFilter(new SpeedFilter(), new DoorsFilter()).filter(cars)){
			System.out.println(car);
		}
	}
}

interface CarFilter{
	List<CarF> filter(List<CarF> cars);
}

class SpeedFilter implements CarFilter{
	@Override
	public List<CarF> filter(List<CarF> cars){
		List<CarF> list = new ArrayList<>();
		for(CarF car : cars){
			if (car.getMaxSpeed() > 120){
				list.add(car);
			}
		}
		return list;
	}
}

class DoorsFilter implements CarFilter{
	@Override
	public List<CarF> filter(List<CarF> cars){
		List<CarF> list = new ArrayList<>();
		for(CarF car : cars){
			if (car.getDoors() > 2){
				list.add(car);
			}
		}
		return list;
	}
}

// Фильтр, реализующий логическое И
class ANDFilter implements CarFilter{
	CarFilter filterOne;
	CarFilter filterTwo;

	public ANDFilter(CarFilter filterOne, CarFilter filterTwo){
		this.filterOne = filterOne;
		this.filterTwo = filterTwo;
	}

	@Override
	public List<CarF> filter(List<CarF> cars){
		List<CarF> list = filterOne.filter(cars);
		return filterTwo.filter(list);
	}
}

// Фильтр, реализующий логическое ИЛИ
class ORFilter implements CarFilter{
	CarFilter filterOne;
	CarFilter filterTwo;

	public ORFilter(CarFilter filterOne, CarFilter filterTwo){
		this.filterOne = filterOne;
		this.filterTwo = filterTwo;
	}

	@Override
	public List<CarF> filter(List<CarF> cars){
		List<CarF> list1 = filterOne.filter(cars);
		List<CarF> list2 = filterOne.filter(cars);
		for (CarF car : list2){
			if (!list1.contains(car)){
				list1.add(car);
			}
		}
		return list1;
	}
}

class CarF{
	private int maxSpeed;
	private String color;
	private int doors;

	public CarF(int maxSpeed, String color, int doors){
		this.maxSpeed = maxSpeed;
		this.color = color;
		this.doors = doors;
	}

	public int getMaxSpeed(){
		return this.maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed){
		this.maxSpeed = maxSpeed;
	}

	public String getColor(){
		return this.color;
	}

	public void setColor(String color){
		this.color = color;
	}

	public int getDoors(){
		return this.doors;
	}

	public void setDoors(int doors){
		this.doors = doors;
	}

	@Override
	public String toString(){
		return "CarF: {" + " maxSpeed: " + this.maxSpeed + ", color: " + this.color + ", doors: " + this.doors + "}";
	}
}