package com.example.learn.dockerjenkins;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DockerJenkinsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DockerJenkinsApplication.class, args);
        Practices practices = new Practices();
        practices.rt();
    }

}
