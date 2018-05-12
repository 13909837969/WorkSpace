package demo;

import java.lang.reflect.Method;

public class Test 
{
	public static void main(String[] args) throws Exception, IllegalAccessException, ClassNotFoundException 
	{
		
		Object obj = Class.forName("demo.Hello").newInstance();
		Method method = obj.getClass().getMethod("sayHello", String.class);
		method.invoke(obj, "–Ì·‘");
		//System.out.println(method);
	}

}
