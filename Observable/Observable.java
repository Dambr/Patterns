// Для того, чтобы классы видели изменения друг друга

import java.util.*;

public class Observable{
	public static void main(String[] args){
		Observer observer1 = new Observer("1");
		Observer observer2 = new Observer("2");

		observer1.setState("new State");
	}
}

interface ObservableI{
	void update();
}

class Observer implements ObservableI{
	static List<Observer> observers = new ArrayList<>();
	String name;
	String state;

	public Observer(String name){
		this.name = name;
		observers.add(this);
	}

	public void setState(String state){
		this.state = state;
		notifyAllObservers();
	}

	void notifyAllObservers(){
		for (Observer observer : observers){
			observer.update();
		}
	}

	@Override
	public void update(){
		System.out.println(name + " state: " + state);
	}
}