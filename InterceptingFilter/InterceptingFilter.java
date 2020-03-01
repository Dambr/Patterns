// Сервер получает запрос от клиента и может
// этот запрос провести через ряд фильтров,
// а затем уже через конечный обработчик запроса

import java.util.*;

public class InterceptingFilter{
	static FilterManager filterManager = new FilterManager();

	public static void main(String[] args){
		filterManager.addFilter(new AuthFilter());
		filterManager.addFilter(new IpFilter());
		filterManager.filterRequest("hello");
	}
}

interface Filter{
	void execute(String data);
}

class AuthFilter implements Filter{
	@Override
	public void execute(String data){
		System.out.println("auth filter data");
	}
}

class IpFilter implements Filter{
	@Override
	public void execute(String data){
		System.out.println("ip filter data");
	}
}

class FilterChain{
	List<Filter> filterList = new ArrayList<>();
	Target target = new Target();
	
	void addFilter(Filter filter){
		filterList.add(filter);
	}

	void filter(String data){
		for (Filter filter : filterList){
			filter.execute(data);
		}
		target.doJob(data);
	}

	void setTarget(Target target){
		this.target = target;
	}
}

class FilterManager{
	FilterChain filterChain = new FilterChain();
	
	void addFilter(Filter filter){
		filterChain.addFilter(filter);
	}

	void filterRequest(String request){
		filterChain.filter(request);
	}
}

class Target{
	void doJob(String data){
		System.out.println("data is " + data);
	}
}