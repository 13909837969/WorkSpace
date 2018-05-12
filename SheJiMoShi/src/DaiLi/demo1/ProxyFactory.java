package DaiLi.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 静态代理
 * 代理对象
 * @author Administrator
 *
 */
public class ProxyFactory 
{
//接收保存目标对象
	private IUserDao target;
	public ProxyFactory(IUserDao target)
	{
		this.target=target;
	}
	
	//将目标对象生成代理对象
	public Object getProxyInstance()
	{
		
		
		
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(),
				new InvocationHandler()
		{

			@Override
			public Object invoke(Object target, Method method, Object[] args) throws Throwable {

				System.out.println("开始事务2");
				//执行目标对象
				Object returnValue = method.invoke(target, args);
				System.out.println("提交事务2");
				return returnValue;
			}
			
		});
		
	}
	

}
