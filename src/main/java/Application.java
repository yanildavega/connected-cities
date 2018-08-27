import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {
        "app", "configuration", "controller", "util","service","domain"
})

public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);


    }

}
