package com.study;

import com.study.message.Demo10Message;
import com.study.producer.Demo10Producer;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;

@SpringBootTest(classes = RabbitmqDemoOrderlyApplication.class)
@RunWith(SpringRunner.class)
class RabbitmqDemoOrderlyApplicationTests {
    private Logger logger= LoggerFactory.getLogger(RabbitmqDemoOrderlyApplicationTests.class);
    @Autowired
    private Demo10Producer demo10Producer;

    @Test
    public void test() throws Exception{
        for(int i=0;i<2;i++){
            for(int j=0;j<4;j++){
                this.demo10Producer.synsend(j);
                logger.info("[test][发送消息:{},消息队列:{},发送成功]",j,j % Demo10Message.QUEUE_COUNT);
            }
        }
        new CountDownLatch(1).await();
    }

}
