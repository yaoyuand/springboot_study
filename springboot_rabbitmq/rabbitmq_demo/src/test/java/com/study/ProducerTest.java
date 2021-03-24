package com.study;

import com.study.message.Demo4Message;
import com.study.producer.Demo1Producer;
import com.study.producer.Demo2Producer;
import com.study.producer.Demo3Producer;
import com.study.producer.Demo4Producer;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.concurrent.CountDownLatch;

/**
 * @Author ytj
 * @Date 2021/3/22 16:58
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitmqDemoApplication.class)
public class ProducerTest {
    private Logger logger= LoggerFactory.getLogger(ProducerTest.class);
    @Autowired
    private Demo1Producer demo1Producer;

    @Autowired
    private Demo2Producer demo2Producer;

    @Autowired
    private Demo3Producer demo3Producer;

    @Autowired
    private Demo4Producer demo4Producer;

    @Test
    public void testSyncsend() throws Exception{
        int id=(int)(System.currentTimeMillis()/1000);
        this.demo1Producer.syncsend(id);
        this.logger.info("[testSyncsend]发送编号:[{}]发送成功",id);
        new CountDownLatch(1).await();
    }

    @Test
    public void testSyncsendDefault() throws Exception{
        int id=(int)(System.currentTimeMillis()/1000);
        this.demo1Producer.syncsendDefault(id);
        this.logger.info("[testSyncsendDefault]发送编号:[{}]发送成功",id);
        new CountDownLatch(1).await();
    }

    @Test
    public void asyncsend() throws Exception{
        int id=(int)(System.currentTimeMillis()/1000);
        this.demo1Producer.asyncsend(id).addCallback(new ListenableFutureCallback<Void>() {
            @Override
            public void onFailure(Throwable throwable) {
                logger.info("[asyncsend]发送编号:[{}]发送失败",id,throwable);
            }

            @Override
            public void onSuccess(Void aVoid) {
                logger.info("[asyncsend]发送编号:[{}]发送成功",id);
            }
        });
        logger.info("[asyncsend]发送编号:[{}]发送完成",id);
        logger.info("id:{}","123456789");
        new CountDownLatch(1).await();
    }

    @Test
    public void testDemo2SynSend() throws Exception{
        int id=(int)(System.currentTimeMillis()/1000);
        this.demo2Producer.syncsend(id,"test");
        logger.info("[testDemo2SynSend]发送编号:{}发送完成",id);
        new CountDownLatch(1).await();
    }

    @Test
    public void testDemo3synSend()throws Exception{
        int id=(int)(System.currentTimeMillis()/1000);
        this.demo3Producer.synsend(id);
        logger.info("[testDemo3synSend],发送编号:{}发送完成",id);
        new CountDownLatch(1).await();
    }

    @Test
    public void testDemo4SynSendA()throws Exception{
        int id=(int)(System.currentTimeMillis()/1000);
        this.demo4Producer.synsend(id, Demo4Message.HEARD_VALUE);
        logger.info("[testDemo4SynSendA],发送编号:{}发送完成",id);
        new CountDownLatch(1).await();
    }

    @Test
    public void testDemo4SynSendB()throws Exception{
        int id=(int)(System.currentTimeMillis()/1000);
        this.demo4Producer.synsend(id,"test");
        logger.info("[testDemo4SynSendB],发送编号:{}发送完成",id);
        new CountDownLatch(1).await();
    }

}
