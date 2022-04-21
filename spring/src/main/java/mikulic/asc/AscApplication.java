package mikulic.asc;

import mikulic.asc.azure.GraphQlFunction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AscApplication {
	public static void main(String[] args) {
		SpringApplication.run(AscApplication.class, args);
	}

	@Bean
	public GraphQlFunction graphql() {
		return new GraphQlFunction();
	}
}
