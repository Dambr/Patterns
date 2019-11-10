public class CppDeveloperFactory implements DeveloperFactory{
	@Override
	public Developer createDeveloper(){
		return new CppDeveloper();
	}
	class CppDeveloper implements Developer{
		@Override
		public void writeCode(){
			System.out.println("I write my code with C++");
		}
	}
}