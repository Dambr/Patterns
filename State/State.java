// Если в объекте меняется параметр, то меняется поведение

public class State{
	public static void main(String[] args){
		Context context = new Context(new DoAction_1(), "Alex");
		context.doAction();

		context.setState(new DoAction_2());
		context.doAction();
	}
}

interface StateI{
	void doAction(Context context);
}
// состояние работы № 1
class DoAction_1 implements StateI{
	@Override
	public void doAction(Context context){
		System.out.println("work doAction 1");
	}
}
// состояние работы № 2
class DoAction_2 implements StateI{
	@Override
	public void doAction(Context context){
		System.out.println("work doAction 2");
	}
}

class Context{
	StateI state;
	String name;

	public Context(StateI state, String name){
		this.state = state;
		this.name = name;
	}

	void setState(StateI state){
		this.state = state;
	}

	void doAction(){
		state.doAction(this);
	}
}