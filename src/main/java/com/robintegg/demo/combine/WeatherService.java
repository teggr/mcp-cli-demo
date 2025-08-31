package com.robintegg.demo.combine;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.shell.command.annotation.Command;
import org.springframework.stereotype.Service;

@Command
@Service
public class WeatherService {

	@Command(command = "weather-forecast-by-location", description = "Get weather forecast for a specific latitude/longitude")
	@Tool(description = "Get weather forecast for a specific latitude/longitude")
	public String getWeatherForecastByLocation(
			double latitude,   // Latitude coordinate
			double longitude   // Longitude coordinate
	) {
		return """
				The weather forecast for the specified location includes:
				- Temperature: 72°F
				- Humidity: 60%
				- Wind Speed: 10 mph
				- Conditions: Partly Cloudy
				""";
	}

	@Command(command = "weather-alerts-by-state", description = "Get weather alerts for a US state")
	@Tool(description = "Get weather alerts for a US state")
	public String getAlerts(
			@ToolParam(description = "Two-letter US state code (e.g. CA, NY)") String state
	) {
		return """
				Active weather alerts for the specified state include:
				- Event: Severe Thunderstorm Warning
				  Area: Northern Region
				  Severity: Severe
				  Description: A severe thunderstorm has been detected in the northern region. Expect heavy rain, strong winds, and possible hail.
				  Safety Instructions: Seek shelter indoors, avoid travel if possible, and stay away from windows.
				""";
	}


}
