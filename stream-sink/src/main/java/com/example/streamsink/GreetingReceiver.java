package com.example.streamsink;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

@Component
public class GreetingReceiver {

    private static final Logger logger = LoggerFactory.getLogger(GreetingReceiver.class);

    // メッセージを受け取るメソッド
    // TODO 07 @StreamListener(target = Sink.INPUT) を付加する

    public void receive(Greeting greeting) {
        logger.info("RECEIVE -> {}", greeting.toString());
    }
}
