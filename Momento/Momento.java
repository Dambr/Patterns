// Позволяет сохранять состояние объекта
// Если сериализация - это сохранение на диск, то
// тут сохранение идет в другой объект

public class Momento{
	String state;

	public Momento(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}

	public static void main(String[] args){
		Originator originator = new Originator();
		originator.setState("one");

		CareTaker careTaker = new CareTaker();
		careTaker.setMomento(originator.createMomento());

		originator.setState("two");

		originator.getDataFromMomento(careTaker.getMomento());
		System.out.println(originator.getState());
	}
}

class Originator{
	String state;
	
	public String getState(){
		return state;
	}

	public void setState(String state){
		this.state = state;
	}

	Momento createMomento(){
		return new Momento(state);
	}

	void getDataFromMomento(Momento momento){
		this.state = momento.getState();
	}
}

class CareTaker{
	Momento momento;

	public Momento getMomento(){
		return momento;
	}

	public void setMomento(Momento momento){
		this.momento = momento;
	}
}