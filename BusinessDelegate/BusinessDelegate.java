// Сделать промежуточное звено между клиентом и сервисом,
// закэшировать информацию и прлучать ее уже не через сеть,
// а с помощью этого звена

public class BusinessDelegate{
	public static void main(String[] args){
		Delegate delegate = new Delegate();
		delegate.doTask("ejb");
		delegate.doTask("ems");
	}
}

interface BusinessService{
	void doJob();
}

class EJBService implements BusinessService{
	@Override
	public void doJob(){
		System.out.println("EJBService");
	}
}

class EMSService implements BusinessService{
	@Override
	public void doJob(){
		System.out.println("EMSService");
	}
}

class LookupService{
	BusinessService getService(String serviceType){
		switch(serviceType){
			case "ejb": return new EJBService();
			case "ems": return new EMSService();
		}
		return null;
	}
}

class Delegate{
	LookupService lookupService = new LookupService();
	BusinessService businessService;
	void doTask(String service){
		businessService = lookupService.getService(service);
		businessService.doJob();
	}
}