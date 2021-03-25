package com.study;

import com.study.producer.Demo16Producer;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitmqDemoJsonApplication.class)
class RabbitmqDemoJsonApplicationTests {
    private Logger logger= LoggerFactory.getLogger(getClass());
    @Autowired
    private Demo16Producer demo16Producer;
    @Test
    public void test() throws Exception{
        int id=(int)(System.currentTimeMillis()/1000);
        this.demo16Producer.syncsend(id);
        this.logger.info("[test]发送编号:[{}]发送成功",id);
        new CountDownLatch(1).await();
    }

}
