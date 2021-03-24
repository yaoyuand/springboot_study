package com.study;

import com.study.producer.ClusteringProducer;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;

@SpringBootTest(classes = RabbitmqDemoMessageModelApplication.class)
@RunWith(SpringRunner.class)
class RabbitmqDemoMessageModelApplicationTests {
    private Logger logger= LoggerFactory.getLogger(RabbitmqDemoMessageModelApplicationTests.class);

    @Autowired
    private ClusteringProducer clusteringProducer;

    @Test
    public void mock() throws Exception{
        //先启动一个consumer消费队列，或者也可以再创建一个consumer消费类
        new CountDownLatch(1).await();
    }

    @Test
    public void testSynSend() throws Exception{
        for(int i=0;i<3;i++){
            int id=(int)(System.currentTimeMillis()/1000);
            this.clusteringProducer.synSend(id);
            logger.info("[testSynSend][发送编号:{},发送成功]",id);
        }
        new CountDownLatch(1).await();
    }

}
