package APIdemo.apidemo;

import com.xyz.openapi.client.config.ClientConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(ClientConfiguration.class)
public class ApidemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Client.class, args);
	}

}
