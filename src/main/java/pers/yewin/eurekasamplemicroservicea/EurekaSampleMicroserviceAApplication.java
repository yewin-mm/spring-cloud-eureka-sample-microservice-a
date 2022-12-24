package pers.yewin.eurekasamplemicroservicea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient // this annotation is required if we want to run this application as eureka client.
public class EurekaSampleMicroserviceAApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaSampleMicroserviceAApplication.class, args);
    }

    // add Loadbalanced to injected restTemplate bean, to get load balance feature when we call multi instance microservice that provided by spring cloud client
    // if we do like that adding load balance in restTemplate, we can't call direct url with restTemplate.
    // So, I comment out below annotation and I will use ribbon loadbalancer while api calling to other microservice.
//    @LoadBalanced
    // inject restTemplate as bean
    @Bean
    public RestTemplate restTemplateBean(){
        return new RestTemplate();
    }
}

