// Имеется большое количество различных сервисов.
// Например, необходимо их закэшировать.
// Для этого помогает Locator

import java.util.*;

public class ServiceLocator{
	public static void main(String[] args){
		Service service = Locator.getService("Service_1");
		service.execute();
		service = Locator.getService("Service_2");
		service.execute();
	}
}

interface Service{
	String getName();
	void execute();
}

class Service1 implements Service{
	@Override
	public String getName(){
		return "Service1";
	}

	@Override
	public void execute(){
		System.out.println("Service 1");
	}
}

class Service2 implements Service{
	@Override
	public String getName(){
		return "Service2";
	}

	@Override
	public void execute(){
		System.out.println("Service 2");
	}
}

class InitialContext{
	public Object lookup(String jndiName){
		if (jndiName.equalsIgnoreCase("SERVICE_1")){
			return new Service1();
		}
		else if (jndiName.equalsIgnoreCase("SERVICE_2")){
			return new Service2();
		}
		else{
			return null;
		}
	}
}

class Cache{
	private List<Service> services = new ArrayList<>();
	
	public Service getService(String serviceName){
		for (Service service : services){
			if (service.getName().equalsIgnoreCase(serviceName)){
				return service;
			}
		}
		return null;
	}

	public void addService(Service newService){
		boolean exists = false;
		for (Service service : services){
			if (service.getName().equalsIgnoreCase(newService.getName())){
				exists = true;
			}
		}
		if (!exists){
			services.add(newService);
		}
	}
}

class Locator{
	private static Cache cache;
	static{
		cache = new Cache();
	}

	public static Service getService(String jndiName){
		Service service = cache.getService(jndiName);
		if (service != null){
			return service;
		}
		InitialContext context = new InitialContext();
		Service newService = (Service)context.lookup(jndiName);
		cache.addService(newService);
		return newService;
	}
}