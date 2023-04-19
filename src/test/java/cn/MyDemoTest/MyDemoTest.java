package cn.MyDemoTest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@SpringBootTest(classes = MyDemoTest.class)
class MyDemoTest {

    @Test
    void contextLoads() {

    }
    @Test
    public  void getNowDate()
    {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd hh:mm:ss");
        System.out.println(simpleDateFormat.format(date));
    }
}
