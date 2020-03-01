// Получение информации различного рода
// из различных сервисов, ее обработка и
// передача единым целым

public class TransferObject{
	public static void main(String[] args){
		BusinessObject businessObject = new BusinessObject();
		System.out.println(businessObject.getUser("Max", 18));
	}
}

class User{
	String name;
	int age;

	public User(String name, int age){
		this.name = name;
		this.age = age;
	}

	public String getName(){
		return name;
	}

	public void setName(String Name){
		this.name = name;
	}

	public int getAge(){
		return age;
	}

	public void setAge(int age){
		this.age = age;
	}

	@Override
	public String toString(){
		return "User{ name: " + name + ", age: " + age + " }";
	}
}

interface Service{
	User getUser(String name, int age);
}

class ServiceEJB implements Service{
	@Override
	public User getUser(String name, int age){
		User user = new User(name, age);
		return user;
	}
}

class ServiceJMX implements Service{
	@Override
	public User getUser(String name, int age){
		User user = new User(name, age);
		return user;
	}
}

class BusinessObject{
	ServiceEJB serviceEJB = new ServiceEJB();
	public User getUser(String name, int age){
		return serviceEJB.getUser(name, age);
	}
}