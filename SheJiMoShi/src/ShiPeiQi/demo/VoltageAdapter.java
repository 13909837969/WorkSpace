package ShiPeiQi.demo;
/**
 * 继承src实现dst转变电压成5v
 * @author Administrator
 *
 */
public class VoltageAdapter extends Voltage220v implements Voltage5
{

	@Override
	public int output5v() {

		int src = output220v();
		System.out.println("适配器工作开始适配电压");
		int dst = src/44;
		System.out.println("适配完成后输出电压："+dst);
		return dst;
	}
	

}
