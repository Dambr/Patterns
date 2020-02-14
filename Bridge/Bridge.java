// Если есть несколько интерфейсов, которые каким то образом
// связаны между собой, то паттерн Bridge позволяет настроить
// связь между ними без описания всех возможных соетаний 
// вариантов интерфейсов друг с другом

public class Bridge{
	public static void main(String[] args){
		ICar car = new ToyotaCar(new CarBridge());
		car.drive();
	}
}

abstract class ICar{
	CarBridgeTrack carBridgeTrack;

	public ICar(CarBridgeTrack carBridgeTrack){
		this.carBridgeTrack = carBridgeTrack;
	}

	abstract void drive();
}

abstract class ITrack{
	CarBridgeTrack carBridgeTrack;

	public ITrack(CarBridgeTrack carBridgeTrack){
		this.carBridgeTrack = carBridgeTrack;
	}

	abstract void drive();
}

interface CarBridgeTrack {
	void drive();
}

class CarBridge implements CarBridgeTrack{
	@Override
	public void drive(){
		System.out.println("drive car");
	}
}
class TrackBridge implements CarBridgeTrack{
	@Override
	public void drive(){
		System.out.println("drive bridge");
	}
}

class ToyotaCar extends ICar{
	public ToyotaCar(CarBridgeTrack carBridgeTrack){
		super(carBridgeTrack);
	}

	@Override
	public void drive(){
		System.out.println("toyota car");
	}
}

class AudiCar extends ICar{
	public AudiCar(CarBridgeTrack carBridgeTrack){
		super(carBridgeTrack);
	}

	@Override
	public void drive(){
		System.out.println("audi car");
	}
}