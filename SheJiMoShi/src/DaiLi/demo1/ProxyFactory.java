package DaiLi.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ��̬����
 * �������
 * @author Administrator
 *
 */
public class ProxyFactory 
{
//���ձ���Ŀ�����
	private IUserDao target;
	public ProxyFactory(IUserDao target)
	{
		this.target=target;
	}
	
	//��Ŀ��������ɴ������
	public Object getProxyInstance()
	{
		
		
		
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(),
				new InvocationHandler()
		{

			@Override
			public Object invoke(Object target, Method method, Object[] args) throws Throwable {

				System.out.println("��ʼ����2");
				//ִ��Ŀ�����
				Object returnValue = method.invoke(target, args);
				System.out.println("�ύ����2");
				return returnValue;
			}
			
		});
		
	}
	

}
