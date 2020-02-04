package com.lsa.slf4j;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
@Slf4j
public class DemoSlf4jApplication {

    //private static final Logger log = LoggerFactory.getLogger(DemoSlf4jApplication.class);
    private static final org.apache.logging.log4j.Logger jsonLogger = LogManager.getLogger("json");

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(DemoSlf4jApplication.class, args);

        while (true) {
            Thread.sleep(10l);
            final long sleepTime = new Random().nextLong();
            if (sleepTime % 2 == 0) {
                log.error("error " + System.currentTimeMillis());
            } else {
                log.info("info " + System.currentTimeMillis());
            }
            jsonLogger.info(sleepTime);
        }
    }

}
