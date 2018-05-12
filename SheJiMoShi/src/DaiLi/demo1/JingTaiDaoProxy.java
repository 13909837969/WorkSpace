package DaiLi.demo1;
/**
 * 静态代理
 * 代理对象
 * @author Administrator
 *
 */
public class JingTaiDaoProxy implements IUserDao 
{
//接收保存目标对象
	private IUserDao target;
	public JingTaiDaoProxy(IUserDao target)
	{
		this.target=target;
	}
	@Override
	public void save() 
	{

		System.out.println("开始事务");
		target.save();
		System.out.println("结束");
		
	}

}
