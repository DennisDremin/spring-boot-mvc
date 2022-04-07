package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController("/")
public class RootController {

	private final Properties properties;

	public RootController(Properties properties) {
		this.properties = properties;
	}

	@GetMapping
	@ResponseBody
	public Map<String, String> index() {
		return properties.asMap();
	}

	@Configuration
	@ConfigurationProperties(prefix = "app")
	public static class Properties {

		private String name;
		private String nick;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getNick() {
			return nick;
		}

		public void setNick(String nick) {
			this.nick = nick;
		}

		public Map<String, String> asMap() {
			return new LinkedHashMap<>() {{
				put("app.name", name);
				put("app.nick", nick);
			}};
		}
	}
}
