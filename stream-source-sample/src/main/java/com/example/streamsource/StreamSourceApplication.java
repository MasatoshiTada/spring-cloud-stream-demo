package com.example.streamsource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // スケジューリングを有効化する(今回は1秒に1回実行)
@EnableBinding(Source.class)
public class StreamSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamSourceApplication.class, args);
    }
}
