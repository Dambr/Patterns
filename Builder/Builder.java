// Создание и настройка экземпляра класса
// локонично и красиво

public class Builder{
	public static void main(String[] args){
		SportCar sportCar = new SportCar.Builder("Audi")
										.setColor("Green")
										.setMaxSpeed(500)
										.build();

		System.out.println( sportCar.getName() );
		System.out.println( sportCar.getColor() );
		System.out.println( sportCar.getMaxSpeed() );
	}
}

class SportCar{
	private String name;
	private String color;
	private int maxSpeed;

	// для всех свойств должны быть объявлены getter

	public String getName(){
		return name;
	}

	public String getColor(){
		return color;
	}

	public int getMaxSpeed(){
		return maxSpeed;
	}

	// объявляется приватный конструктор

	private SportCar(Builder builder){
		this.name = builder.name;
		this.color = builder.color;
		this.maxSpeed = builder.maxSpeed;
	}

	// внутренний статический класс

	static class Builder{
		private String name; // поле обязательное к заполнению при создании экземпляра класса
		private String color = "RED"; // поле имеет значение по умолчанию
		private int maxSpeed = 200; // поле имеет значение по умолчанию

		public Builder(String name){ // здесь перечисляются поля,
									 // которые обязательны к заполнениню 
			this.name = name;		 // при создании экземпляра класса
		}

		public Builder setColor(String color){ // остальные поля
											   // принимают значения через setter
			this.color = color;
			return this;
		}

		public Builder setMaxSpeed(int maxSpeed){
			this.maxSpeed = maxSpeed;
			return this;
		}

		public SportCar build(){
			return new SportCar(this);
		}
	}
}