package DaiLi.demo1;
/**
 * 接口实现
 * 目标对象
 * @author Administrator
 *
 */
public class UserDao implements IUserDao {

	@Override
	public void save() 
	{

		System.out.println("已经保存数据");
		
	}

}
