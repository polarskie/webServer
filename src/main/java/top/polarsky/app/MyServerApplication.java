package top.polarsky.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
@ImportResource(locations = {"classpath:spring-context/*.xml"})
@Controller
@Configuration
public class MyServerApplication {

    @RequestMapping("index")
    public String indexHandler() {
        return "index";
    }

    public static void main(String[] args) {
        SpringApplication.run(MyServerApplication.class, args);
    }

    @Bean
    @ConditionalOnMissingBean(InternalResourceViewResolver.class)
    public InternalResourceViewResolver defaultViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("s/frontend/");
        resolver.setSuffix(".html");
        return resolver;
    }

}
