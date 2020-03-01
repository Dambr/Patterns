// Концепция - сделать класс взаимозаменяемыми
// Чтоб при изменении используемых классов
// не надо было по всему проекту изменять их использование

public class DAO{
	static Data data = new FileSystem(); // DB или что то еще

	public static void main(String[] args){
		System.out.println(data.getData());
	}
}

interface Data{
	String getData();
}

class DB implements Data{
	String getDataFromTable(){
		return "data from table";
	}

	@Override
	public String getData(){
		return getDataFromTable();
	}
}

class FileSystem implements Data{
	String getDataFromFS(){
		return "data from fileSystem";
	}

	@Override
	public String getData(){
		return getDataFromFS();
	}
}