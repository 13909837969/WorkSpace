package demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Hello2 implements InvocationHandler
{

	private Object target;
	

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		this.target=target;
		
		return null;
	}
	
	
	
	
}
