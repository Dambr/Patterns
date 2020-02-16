// Обертка над методами класса, добавляющаяя дополнительный функционал
// Например, можно сделать так, чтобы метод запускался отдельным потоком

public class Decorator{
	public static void main(String[] args) {
		FileStream fileStream = new FileBufferedReader(new FileStreamReader());
		fileStream.read();
	}
}

interface FileStream{
	void read();
}

class FileStreamReader implements FileStream{
	@Override
	public void read(){
		System.out.println("read file");
	}
}

abstract class FileDecorator implements FileStream{
	FileStream fileDecorator;
	public FileDecorator(FileStream fileDecorator){
		this.fileDecorator = fileDecorator;
	}
	public abstract void read();
}
class FileBufferedReader extends FileDecorator{
	public FileBufferedReader(FileStream fileDecorator){
		super(fileDecorator);
	}
	@Override
	public void read(){
		// Необходимый дополнительный функционал
		System.out.println("Some code is here...");
		fileDecorator.read();
	}
}