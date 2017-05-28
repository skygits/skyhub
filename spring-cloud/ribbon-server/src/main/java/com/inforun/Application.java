package com.inforun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Created by yakai.wang on 2017/5/11.
 */
@SpringBootApplication
@EnableEurekaClient
public class Application {

    @Autowired
    Environment environment;

    @Autowired
    RestTemplate client;

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
    /**
     * LoadBalanced 注解表明restTemplate使用LoadBalancerClient执行请求
     *
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        RestTemplate template = new RestTemplate();
        SimpleClientHttpRequestFactory factory = (SimpleClientHttpRequestFactory) template.getRequestFactory();
        factory.setConnectTimeout(3000);
        factory.setReadTimeout(3000);
        return template;
    }

    /*@Bean
    @LoadBalanced
    RestTemplate resetTemplate(){
        return new RestTemplate();
    }

    @RequestMapping("/")
    public String helloWorld() {
        System.out.println(environment.getProperty("server.port"));
        return client.getForObject("http://ribbon-server/", String.class);
    }*/

}
