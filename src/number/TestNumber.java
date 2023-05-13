package number;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 保险机构代号+日期（YYYYMMDD）+10位流水号， 流水号每天从"0000000001"考试
 */
public class TestNumber {

    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String now = sdf.format(date);
        StringBuffer sb = new StringBuffer();
        String num = "0000000000";
        Integer count = Integer.parseInt(num);
        String strNum = "";
        //count++;
        //strNum = count.toString();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000000; i++) {
            strNum = String.format("%010d", ++count); //0：代表前面补充0；10：代表长度为10；d:代表参数为正数型
            sb.append(861234);//保险机构代号
            sb.append(now);//日期
            sb.append(strNum);
            sb.append("\n");
        }
        long end = System.currentTimeMillis();
        System.out.println(sb);
        System.out.println("耗时： " + (end - start));

/*
        String no = "861234"; //保险机构代码
        Date date = new Date(); //日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String now = sdf.format(date);
        long num = 0L;
        String sum = "0000000000";
        long start = System.currentTimeMillis();
        do {
            num++;
            String strNum = String.valueOf(num);
            String beforeZero = sum.substring(0, 10 - strNum.length());
            String Number = no + now + beforeZero + strNum;
            System.out.println("流水号:" + Number);
        } while (num < 5000000);
        long end = System.currentTimeMillis();

        System.out.println("耗时： " + (end - start));*/
    }
}
