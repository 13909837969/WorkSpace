package ShiPeiQi.demo;
/**
 * �̳�srcʵ��dstת���ѹ��5v
 * @author Administrator
 *
 */
public class VoltageAdapter extends Voltage220v implements Voltage5
{

	@Override
	public int output5v() {

		int src = output220v();
		System.out.println("������������ʼ�����ѹ");
		int dst = src/44;
		System.out.println("������ɺ������ѹ��"+dst);
		return dst;
	}
	

}
