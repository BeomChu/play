package me.beomchu.play;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@SpringBootApplication
public class PlayApplication {


    public static void main(String[] args) {
        SpringApplication.run(PlayApplication.class, args);
    }

}
