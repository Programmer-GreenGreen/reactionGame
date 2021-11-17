package com.example.reactionGame;

//import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.example.reactionGame.cotroller.MemberController;
import com.example.reactionGame.service.MemberService;
import com.example.reactionGame.service.MemberServiceImpl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class ReactionGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactionGameApplication.class, args);
	}
}
