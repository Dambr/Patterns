// Создан для сокращения необходимости создавать много объектов
// Позволяет переиспользовать объекты
import java.util.*;

public class ObjectPool{
	public static void main(String[] args){
		ObjectPoolClass objectPool = new ObjectPoolClass();
		PoolledObject poolledObject = objectPool.getPoolledObject();
		objectPool.releasePoolledObject(poolledObject);
	}
}

class PoolledObject{

}

class ObjectPoolClass{
	List<PoolledObject> free = new LinkedList<>();
	List<PoolledObject> used = new LinkedList<>();

	public PoolledObject getPoolledObject(){
		if ( free.isEmpty() ){
			PoolledObject poolledObject = new PoolledObject();
			free.add(poolledObject);
			return poolledObject;
		}
		else{
			PoolledObject poolledObject = free.get(0);
			used.add(poolledObject);
			free.remove(poolledObject);
			return poolledObject;
		}
	}

	public void releasePoolledObject(PoolledObject poolledObject){
		used.remove(poolledObject);
		free.add(poolledObject);
	}
}