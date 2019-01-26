package com.example.streamsource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Random;

@Component
public class GreetingSender {

    private static final Logger logger = LoggerFactory.getLogger(GreetingSender.class);

    private final Source source;
    private final Random random = new Random();

    public GreetingSender(Source source) {
        this.source = source;
    }

    @Scheduled(fixedDelay = 1000L) // 1秒(=1000ミリ秒)に1回このメソッドを実行する
    public void send() {
        Greeting greeting = new Greeting(random.nextInt(2), "Hello : " + LocalDateTime.now());
        logger.info("Sending: {}", greeting.toString());
        Message<Greeting> message = MessageBuilder.withPayload(greeting).build();
        // メッセージ送信
        source.output().send(message);
    }
}
