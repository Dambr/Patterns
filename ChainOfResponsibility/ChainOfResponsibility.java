// Когда одно событие вызывает несколько обработчиков
// и каждый обработчик что то делает


public class ChainOfResponsibility{
	public static void main(String[] args){
		MessagePrinter messagePrinter = new ConsoleMessagePrinter();
		FileMessagePrinter fileMessagePrinter = new FileMessagePrinter();

		messagePrinter.setMessagePrinter(fileMessagePrinter);
		fileMessagePrinter.setMessagePrinter(new DBMessagePrinter());
		messagePrinter.print("hello");
	}
}

abstract class MessagePrinter{
	MessagePrinter nexMesaagePrinter;
	void setMessagePrinter(MessagePrinter messagePrinter){
		nexMesaagePrinter = messagePrinter;
	}

	void print(String message){
		printMessage(message);
		if (nexMesaagePrinter != null){
			nexMesaagePrinter.print(message);
		}
	}

	abstract void printMessage(String messgae);
}

class ConsoleMessagePrinter extends MessagePrinter{
	@Override
	void printMessage(String message){
		System.out.println("print to console: " + message);
	}
}

class FileMessagePrinter extends MessagePrinter{
	@Override
	void printMessage(String message){
		System.out.println("print to file: " + message);
	}
}

class DBMessagePrinter extends MessagePrinter{
	@Override
	void printMessage(String message){
		System.out.println("print to DB: " + message);
	}
}