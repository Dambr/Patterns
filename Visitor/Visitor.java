// Для замены существующего кода

public class Visitor{
	public static void main(String[] args){
		Animal dog = new Dog();
		dog.say(new ConcreteVisitor());

		Animal cat = new Cat();
		cat.say(new ConcreteVisitor());
	}
}

interface Animal{
	void say(VisitorI visitor);
}

class Dog implements Animal{
	@Override
	public void say(VisitorI visitor){
		visitor.dogSay();
	}
}

class Cat implements Animal{
	@Override
	public void say(VisitorI visitor){
		visitor.catSay();
	}
}

interface VisitorI{
	void dogSay();
	void catSay();
}

class ConcreteVisitor implements VisitorI{
	@Override
	public void dogSay(){
		System.out.println("Gav");
	}

	@Override
	public void catSay(){
		System.out.println("Mew");
	}
}