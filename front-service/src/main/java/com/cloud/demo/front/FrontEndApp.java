package com.cloud.demo.front;

import com.cloud.demo.common.dto.dto.ProductDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class FrontEndApp {
    @Autowired
    private RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(FrontEndApp.class, args);
    }

    @HystrixCommand(fallbackMethod = "demoFallback")
    @GetMapping("/test")
    public String demo() {
        return restTemplate.getForObject("http://product-service/market/api/v1/products/test", String.class);
    }
    @GetMapping("/test_all")
    public String demoAll() {
        return restTemplate.getForObject("http://product-service/market/api/v1/products", String.class);
    }

    @GetMapping("/test_dto")
    public List<ProductDto> demoDTO() {
        return restTemplate.getForObject("http://product-service/market/api/v1/products", List.class);

    }

}
