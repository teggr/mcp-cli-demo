package com.robintegg.demo.combine;

import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.shell.command.annotation.CommandScan;

@SpringBootApplication
public class McpCliDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(McpCliDemoApplication.class, args);
	}

	@Profile( "cli" )
	@Configuration
	@CommandScan
	static class CliConfiguration {


	}

	@Profile( "mcp" )
	@Bean
	public ToolCallbackProvider weatherTools(WeatherService weatherService) {
		return MethodToolCallbackProvider
				.builder()
				.toolObjects( weatherService )
				.build();
	}

}
