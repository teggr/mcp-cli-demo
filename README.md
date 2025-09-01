# Combining Spring AI Model Context Protocol and Spring Shell 

```java
@Command
@Service
public class WeatherService {

	@Command(command = "weather-forecast-by-location", description = "Get weather forecast for a specific latitude/longitude")
	@Tool(description = "Get weather forecast for a specific latitude/longitude")
	public String getWeatherForecastByLocation(
			double latitude,   // Latitude coordinate
			double longitude   // Longitude coordinate
	) {
        // ...
	}
```

```properties
# application.properties
spring.application.name=mcp-cli-demo

spring.main.banner-mode=off
logging.pattern.console=

spring.profiles.default=cli

# application-cli.properties
# command line profile that runs CLI and disables MCP server

spring.ai.mcp.server.enabled=false
spring.shell.noninteractive.enabled=true
spring.shell.interactive.enabled=false

# application-mcp.properties
# mcp profile that runs MCP server and disables interactive shell

spring.ai.mcp.server.enabled=true
spring.shell.noninteractive.enabled=false
spring.shell.interactive.enabled=false
```

## Running the CLI

```shell
java -jar <jar-location>/mcp-cli-demo-0.0.1-SNAPSHOT.jar weather-forecast-by-location --latitude 37.7749 --longitude -122.4194
```

## Running as MCP Server

```json
{
  "servers": {
    "weather-service": {
      "type": "stdio",
      "command": "java",
      "args": [
        "-jar",
        "-Dspring.profiles.active=mcp",
        "<jar-location>/mcp-cli-demo-0.0.1-SNAPSHOT.jar"
      ]
    }
  }
}
```

## Reference Documentation
For further reference, please consider the following sections:

* https://docs.spring.io/spring-ai/reference/getting-started.html
* https://docs.spring.io/spring-shell/reference/customization/singlecommand.html
* https://modelcontextprotocol.io/quickstart/server#java

