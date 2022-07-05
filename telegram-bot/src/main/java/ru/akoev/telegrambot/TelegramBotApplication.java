package ru.akoev.telegrambot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

@SpringBootApplication
public class TelegramBotApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(TelegramBotApplication.class, args);

		String url = "http://localhost:8080/";
		try {
			Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
