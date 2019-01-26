package com.example.streamsink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
// TODO 06 @EnableBinding(Sink.class) を付加する

public class StreamSinkApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamSinkApplication.class, args);
    }
}
