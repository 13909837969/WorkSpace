package ShiPeiQi.demo;
public class Mobile 
{
    /**
     * ��緽��
     *
     * @param voltage5
     */
    public void charging(Voltage5 ff) 
    {
        if (ff.output5v() == 5) 
        {
            System.out.println("��ѹ�ոպ�5V����ʼ���");
        } else if (ff.output5v() > 5)
        {
            System.out.println("��ѹ����5V�������� ��Ҫ���note7��");
        }
    }
}
