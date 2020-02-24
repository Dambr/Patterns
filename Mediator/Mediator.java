// Позвояет упрощать инкапсуляцию между объектами

// Пример: radioButton. Одна кнопка активна - все остальные должны погаснуть

import java.util.*;

public class Mediator{
	public static void main(String[] args){
		ConcreteMediator mediator = new ConcreteMediator();
		mediator.add(new ConcreteCollegue(mediator, "Alex"));
		mediator.add(new ConcreteCollegue(mediator, "Bob"));

		ConcreteCollegue concreteCollegue = new ConcreteCollegue(mediator, "Claire");
		mediator.add(concreteCollegue);
		concreteCollegue.changeStatus();
	}
}


interface MediatorI{
	void requestAll(Collegue collegue);
}

class ConcreteMediator implements MediatorI{
	List<Collegue> collegues = new ArrayList<>();
	void add(Collegue collegue){
		collegues.add(collegue);
	}

	@Override
	public void requestAll(Collegue collegue){
		collegue.setTrue();
		for (Collegue coll : collegues){
			if (coll != collegue){
				coll.setFalse();
			}
		}
	}
}

interface Collegue{
	void setFalse();
	void setTrue();
	void changeStatus();
}

class ConcreteCollegue implements Collegue{
	boolean status;
	MediatorI mediator;
	String name;

	public ConcreteCollegue(MediatorI mediator, String name){
		this.mediator = mediator;
		this.name = name;
	}

	@Override
	public void setFalse(){
		status = false;
		System.out.println(name + " Status is False");
	}

	@Override
	public void setTrue(){
		status = true;
		System.out.println(name + " Status is True");
	}

	@Override
	public void changeStatus(){
		mediator.requestAll(this);
	}
}