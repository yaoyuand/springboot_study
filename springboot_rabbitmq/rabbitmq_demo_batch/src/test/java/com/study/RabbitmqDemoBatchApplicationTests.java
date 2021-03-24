package com.study;

import com.study.producer.Demo5Producer;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;

@SpringBootTest(classes = RabbitmqDemoBatchApplication.class)
@RunWith(SpringRunner.class)
class RabbitmqDemoBatchApplicationTests {
    private Logger logger= LoggerFactory.getLogger(RabbitmqDemoBatchApplicationTests.class);
    @Autowired
    private Demo5Producer demo5Producer;

    @Test
    public void testDemo5Producer() throws Exception{
        for (int i=0;i<10;i++) {
            int id = (int) (System.currentTimeMillis() / 1000);
            this.demo5Producer.synSend(id);
            logger.info("[testDemo5Producer],[发送消息编号:{},发送成功]",id);
            Thread.sleep(3 * 1000L);
        }
        new CountDownLatch(1).await();
    }

}
