// Всем управляет Model View Controller (MVC)

public class MVC{
	public static void main(String[] args){
		Controller c = new Controller();
		c.execute("Max", 20);
		c.execute("Alex", 22);
	}
}

class Student{
	String name;
	int age;

	public Student(String name, int age){
		this.name = name;
		this.age = age;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
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
		return "Student{ name: " + name + ", age: " + age + " }";
	}
}

interface ModelLayer{
	Student getStudent(String name, int age);
}

class DBLayer implements ModelLayer{
	@Override
	public Student getStudent(String name, int age){
		return new Student(name, age);
	}
}

class FileSystemLayer implements ModelLayer{
	@Override
	public Student getStudent(String name, int age){
		return new Student(name, age);
	}
}

interface View{
	void showStudent(Student student);
}

class ConsoleView implements View{
	@Override
	public void showStudent(Student student){
		System.out.println(student);
	}
}
// Можно не только в консоль выводить, а как то иначе

class Controller{ // берет данные из модели и передает их в View
	ModelLayer modelLayer = new DBLayer(); // или FileSystemLayer
	View view = new ConsoleView();
	void execute(String name, int age){
		Student student = modelLayer.getStudent(name, age);
		view.showStudent(student);
	}
}