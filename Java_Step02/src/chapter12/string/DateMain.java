package chapter12.string;

import java.text.SimpleDateFormat;
import java.sql.Date;

public class DateMain {
    public static void main(String[] args) {

        Date now = new Date(0);
        System.out.println(now);

        String srtNow1 = now.toString();
        System.out.println("======DATE======");
        System.out.println(srtNow1);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
        String strNow2 = sdf.format(now);
    }

}
