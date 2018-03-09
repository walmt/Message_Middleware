package com.imooc.jms.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.annotation.Resource;
import javax.jms.*;

/**
 * Created by walmt on 2018/3/9.
 */
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    JmsTemplate jmsTemplate;

//    @Resource(name = "queueDestination")
    @Resource(name = "topicDestination")
    Destination destination;

    @Override
    public void sendMessage(String message) {
        // 使用JmsTemplate发送消息
        jmsTemplate.send(destination, session -> {
            // 创建一个消息
            TextMessage textMessage = session.createTextMessage(message);
            return textMessage;
        });
        System.out.println("发送消息：" + message);
    }
}
