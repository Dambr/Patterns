// Позволяет конвертировать исполнение
// одного интерфейса к другим.
// Так, при несовпадении имен методов в интерфейсах,
// работа не может быть выполнена.

public class Adapter{
	public static void main(String[] args){
		CarWash carWash = new CarWash();
		carWash.washCar( new Audi() );
		carWash.washCar( new TrackWrap( new MyTrack() ) );
	}
}

class TrackWrap implements Car{ 	// Класс-обертка
	Track track;					// позволяет обращаться к функцианалу
	public TrackWrap(Track track){  // одного интерфейса по имени другого
		this.track = track;
	}
	
	@Override
	public void wash(){
		track.clean();
	}
}

interface Track{
	void clean();
}

class MyTrack implements Track{
	@Override
	public void clean(){
		System.out.println("Track is clean");
	}
}

interface Car{
	void wash();
}



class Audi implements Car{
	@Override
	public void wash(){
		System.out.println("wash car");
	}
}

class CarWash{
	public void washCar(Car car){
		car.wash();
	}
}