// Есть несколько сервисов в сети, которые взаимосвязаны
// Мы хотим получать либо данные от них, либо что то еще
// Невыгодно обращаться к каждому по отдельности
// Данный паттерн позволяет сначала сформировать общаность
// из этих сервисов и передать клиенту уже его

public class CompositeEntity{
	public static void main(String[] args){
		Composite composite = new Composite();
		for (String s : composite.getData()){
			System.out.println(s);
		}
	}
}

class DependedObject1{
	String getData(){
		return "one";
	}
}

class DependedObject2{
	String getData(){
		return "two";
	}
}

class CoarseGainedObject{
	DependedObject1 dependedObject1 = new DependedObject1();
	DependedObject2 dependedObject2 = new DependedObject2();

	public String[] getData(){
		return new String[] {dependedObject1.getData(), dependedObject2.getData()};
	}
}

class Composite{
	CoarseGainedObject coarseGainedObject = new CoarseGainedObject();
	public String[] getData(){
		return coarseGainedObject.getData();
	}
}