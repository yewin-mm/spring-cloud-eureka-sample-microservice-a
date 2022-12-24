package pers.yewin.eurekasamplemicroservicea.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.yewin.eurekasamplemicroservicea.service.ServiceATestService;

/**
 * @author: Ye Win
 * @created: 25/09/2022
 * @project: eureka-sample-microservice-a
 * @package: pers.yewin.eurekasamplemicroservicea.controller
 */

@RestController
@Slf4j // for logging
public class ServiceATestController {

    @Autowired
    ServiceATestService aTestService;

    @GetMapping("/serviceADemoAPI")
    public ResponseEntity<String> serviceADemoAPI(){
        try {
            log.info("Enter serviceADemoAPI api of Microservice A");
            String result = aTestService.serviceAProcess();
            log.info("response:  {}", result);
            log.info("Exit serviceADemoAPI api");
            return ResponseEntity.ok(result);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/callServiceBFromServiceADirectAPICall")
    public ResponseEntity<String> callServiceBFromServiceADirectAPICall(){
        try {
            log.info("Enter callServiceBFromServiceADirectAPICall api");
            String result = aTestService.callServiceBFromServiceADirectAPICall();
            log.info("response:  {}", result);
            log.info("Exit callServiceBFromServiceADirectAPICall api");
            return ResponseEntity.ok(result);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/callServiceBInstanceFromServiceADirectAPICall")
    public ResponseEntity<String> callServiceBInstanceFromServiceADirectAPICall(){
        try {
            log.info("Enter callServiceBInstanceFromServiceADirectAPICall api");
            String result = aTestService.callServiceBInstanceFromServiceADirectAPICall();
            log.info("response: {}", result);
            log.info("Exit callServiceBInstanceFromServiceADirectAPICall api");
            return ResponseEntity.ok(result);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }


    /**
     * This below api will call all instances of service-b,
     * Whether service-b has many instances or not, whatever, it can call.
     * Because we used Load Balancer to call api
     * And that Load Balancer will find as per Service Name which our application registered in Eureka Server as per application name in yml file.
     * Load Balancer will call as Round Robin rule (you can find more about load balancer in google)
     */
    @GetMapping("/callServiceBFromServiceAThroughEureka")
    public ResponseEntity<String> callServiceBFromServiceAThroughEureka(){
        try {
            log.info("Enter callServiceBFromServiceAThroughEureka api");
            String result = aTestService.callServiceBFromServiceAThroughEureka();
            log.info("response: {}", result);
            log.info("Exit callServiceBFromServiceAThroughEureka api");
            return ResponseEntity.ok(result);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}
