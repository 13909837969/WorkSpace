package ShiPeiQi.demo;
public class Mobile 
{
    /**
     * 充电方法
     *
     * @param voltage5
     */
    public void charging(Voltage5 ff) 
    {
        if (ff.output5v() == 5) 
        {
            System.out.println("电压刚刚好5V，开始充电");
        } else if (ff.output5v() > 5)
        {
            System.out.println("电压超过5V，都闪开 我要变成note7了");
        }
    }
}
