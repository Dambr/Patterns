// Позволяет итерироваться по какой-либо коллекции или набору даных

public class Iterator{
	public static void main(String[] args){
		ArrayContainer arrayContainer = new ArrayContainer();
		IteratorI iterator = arrayContainer.getIterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
}

interface IteratorI{
	boolean hasNext();
	Object next();
}

interface Container{
	IteratorI getIterator();
}

class ArrayContainer implements Container{
	String[] array = {"Max", "Alex", "Bob"};

	@Override
	public IteratorI getIterator(){
		return new ArrayIterator();
	}

	class ArrayIterator implements IteratorI{
		int index;

		@Override
		public boolean hasNext(){
			return index < array.length;
		}

		@Override
		public Object next(){
			if (hasNext()){
				return array[index++];
			}
			return null;
		}
	}
}