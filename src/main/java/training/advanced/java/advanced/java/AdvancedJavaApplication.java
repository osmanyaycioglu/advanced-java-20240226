package training.advanced.java.advanced.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@SpringBootApplication
@EnableAsync
public class AdvancedJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdvancedJavaApplication.class,args);
    }

    @Async
    public Future<String> asyncMetod(){
        return CompletableFuture.completedFuture("deneme");
    }

}
