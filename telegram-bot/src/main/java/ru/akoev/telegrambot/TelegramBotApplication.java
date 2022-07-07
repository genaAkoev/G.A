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

		String URL_STATIC_PAGE = "http://localhost:8080/",
				URL_CLIENTS = "http://localhost:8080/clients/",
				URL_H2_CONSOLE = "http://localhost:8080/h2-console/";

		try {
			Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + URL_CLIENTS);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
