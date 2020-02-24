import java.util.*;

public class Interpreter{
	public static void main(String[] args) {
		String expression = "1+2+3-4";
		Expression evaluator = new Evaluate(expression);
		System.out.println(evaluator.interpret(evaluator));
	}
}

interface Expression{
	int interpret(Expression context);
}

class Number implements Expression{
	int number;

	public Number(int number){
		this.number = number;
	}

	@Override
	public int interpret(Expression context){
		return number;
	}
}

class Plus implements Expression{
	Expression expressionLeft;
	Expression expressionRight;

	public Plus(Expression expressionLeft, Expression expressionRight){
		this.expressionLeft = expressionLeft;
		this.expressionRight = expressionRight;
	}

	@Override
	public int interpret(Expression context){
		return expressionLeft.interpret(context) + expressionRight.interpret(context);
	}
}

class Minus implements Expression{
	Expression expressionLeft;
	Expression expressionRight;

	public Minus(Expression expressionLeft, Expression expressionRight){
		this.expressionLeft = expressionLeft;
		this.expressionRight = expressionRight;
	}

	@Override
	public int interpret(Expression context){
		return expressionLeft.interpret(context) - expressionRight.interpret(context);
	}
}

class Evaluate implements Expression{
	Expression evaluate;
	public Evaluate(String expression){
		Stack<Expression> expressions = new Stack<>();
		String expressionRever = new StringBuilder(expression).reverse().toString();
		for (String s : expressionRever.split("\\D")){
			expressions.push(new Number(Integer.parseInt(s)));
		}
		for (String s : expression.split("\\d")){
			if (s.equals("+")){
				expressions.push(new Plus(expressions.pop(), expressions.pop()));
			}
			else if (s.equals("-")){
				expressions.push(new Minus(expressions.pop(), expressions.pop()));
			}
			evaluate = expressions.pop();
		}
	}

	@Override
	public int interpret(Expression context){
		return evaluate.interpret(context);
	}
}