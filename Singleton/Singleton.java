// может существовать только в единственном экземпляре

public class Singleton{
	public static void main(String[] args){
		SingletonClass s1 = SingletonClass.getInstance();
		SingletonClass s2 = SingletonClass.getInstance();

		s1.i = 5;

		System.out.println(s2.i);
	}
}

class SingletonClass{
	int i;

	static SingletonClass singletonClass = new SingletonClass();
	private SingletonClass(){}
	public static SingletonClass getInstance(){
		return singletonClass;
	}
}