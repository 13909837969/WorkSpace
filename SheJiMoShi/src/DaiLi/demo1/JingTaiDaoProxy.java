package DaiLi.demo1;
/**
 * ��̬����
 * �������
 * @author Administrator
 *
 */
public class JingTaiDaoProxy implements IUserDao 
{
//���ձ���Ŀ�����
	private IUserDao target;
	public JingTaiDaoProxy(IUserDao target)
	{
		this.target=target;
	}
	@Override
	public void save() 
	{

		System.out.println("��ʼ����");
		target.save();
		System.out.println("����");
		
	}

}
