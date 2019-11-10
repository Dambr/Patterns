public class Main{
	public static void main(String[] args){
		Developer javaDeveloper = new JavaDeveloperFactory().createDeveloper();
		javaDeveloper.writeCode();
		Developer cppDeveloper = new CppDeveloperFactory().createDeveloper();
		cppDeveloper.writeCode();
	}
}