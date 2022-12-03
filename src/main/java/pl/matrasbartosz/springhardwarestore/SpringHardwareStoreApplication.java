package pl.matrasbartosz.springhardwarestore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringHardwareStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringHardwareStoreApplication.class, args);
    }
}
