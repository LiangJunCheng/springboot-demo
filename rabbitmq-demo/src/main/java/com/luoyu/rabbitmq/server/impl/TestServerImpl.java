package com.luoyu.rabbitmq.server.impl;

import com.luoyu.rabbitmq.constants.RabbitMqConstants;
import com.luoyu.rabbitmq.server.TestServer;
import com.luoyu.rabbitmq.util.RabbitMqUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServerImpl implements TestServer {

    @Autowired
    private RabbitMqUtils rabbitMqUtils;

    @Override
    public String sendTest1(String content) {
        rabbitMqUtils.sendByRoutingKey(RabbitMqConstants.EXCHANGE_NAME,
                RabbitMqConstants.TOPIC_TEST1_ROUTINGKEY_TEST, content);
        return "发送成功！";
    }

    @Override
    public String sendTest2(String content) {
        rabbitMqUtils.sendByRoutingKey(RabbitMqConstants.EXCHANGE_NAME,
                RabbitMqConstants.TOPIC_TEST2_ROUTINGKEY_TEST, content);
        return "发送成功！";
    }
}
