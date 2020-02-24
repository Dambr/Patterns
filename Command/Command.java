// Receiver нужен, чтобы инкапсулировать команду в отдельный класс

// Это может применяться для создания целого списка комманд
// в класса Receiver
// а так же позволяет использовать дополнительный код
// для обработки всего списка команд

// Так же удобно сделать Receiver с помощью Singleton

import java.util.*;

public class Command{
	public static void main(String[] args){
		Receiver receiver = new Receiver();
		receiver.addCommand(new MouseClick());
		receiver.addCommand(new MousePress());

		receiver.runCommand();
	}
}

interface CommandI{
	void execute();
}

class MouseClick implements CommandI{
	@Override
	public void execute(){
		System.out.println("Command: MouseClick");
	}
}

class MousePress implements CommandI{
	@Override
	public void execute(){
		System.out.println("Command: MousePress");
	}
}

class Receiver{
	List<CommandI> commands = new ArrayList<>();

	void addCommand(CommandI command){
		commands.add(command);
	}

	void runCommand(){
		for (CommandI command : commands){
			command.execute();
		}
	}
}