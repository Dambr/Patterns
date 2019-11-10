public class JavaDeveloperFactory implements DeveloperFactory{
	@Override
	public Developer createDeveloper(){
		return new JavaDeveloper();
	}
	class JavaDeveloper implements Developer{
		@Override
		public void writeCode(){
			System.out.println("I write my code with Java");
		}
	}
}