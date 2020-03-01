// Применяется тот метод, который указан в свойстве класса
// Достаточно главному объекту передать тот класс,
// чей метод будет работать

public class Strategy{
	public static void main(String[] args){
		
		double price = 100;
		Context context = new Context(new FullPrice());

		System.out.println("Price = " + price);
		System.out.println("FullPrice => " + context.getPrice(price));

		context.setStrategy(new HalfPrice());
		System.out.println("HalfPrice => " + context.getPrice(price));
	}
}

class Context{
	StrategyI strategy;

	public Context(StrategyI strategy){
		this.strategy = strategy;
	}

	public void setStrategy(StrategyI strategy){
		this.strategy = strategy;
	}

	public double getPrice(double price){
		return strategy.getPrice(price);
	}
}

interface StrategyI{
	double getPrice(double price);
}

class FullPrice implements StrategyI{
	@Override
	public double getPrice(double price){
		return price;
	}
}

class HalfPrice implements StrategyI{
	@Override
	public double getPrice(double price){
		return price / 2;
	}
}