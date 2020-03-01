// Заранее продуман алгоритм, но шаги не уточены
// Уточнение шагов на более низком уровне абстракции

public class Template{
	public static void main(String[] args){
		TemplateAC template = new Job();
		template.run();
	}
}

abstract class TemplateAC{
	abstract void stepOne();
	abstract void stepTwo();
	abstract void stepThree();

	void run(){
		stepOne();
		stepTwo();
		stepThree();
	}
}

class Job extends TemplateAC{
	@Override
	void stepOne(){
		System.out.println("One");
	}
	void stepTwo(){
		System.out.println("Two");
	}
	void stepThree(){
		System.out.println("Three");
	}
}