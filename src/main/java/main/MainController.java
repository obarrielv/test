package main;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    public static  void main(String[] args){
        SpringApplication.run(MainController.class,args);
    }
}
