// Объект, который умеет клонировать в себя.
// Можно сохранить в него экземпляр самого себя,
// а потом получить это значение из хранилища

public class Prototype{
	public static void main(String[] args) throws CloneNotSupportedException{
		Cash cash = new Cash();
		cash.setStudent(new Student()); // кладем образец класса

		Student student = cash.getStudent(); // получаем его обратно
	}
}

class Student implements Cloneable{ // класс организуется через паттерн Prototype
	@Override
	public Student clone() throws CloneNotSupportedException{
		return (Student)super.clone();
	}
}

class Cash{ // некоторое хранилище данных объектов класса Student
	private Student student;

	public Student getStudent() throws CloneNotSupportedException{
		return student.clone();
	}

	public void setStudent(Student student){
		this.student = student;
	}
}