package aws.boot.user.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@EnableAdminServer
@SpringBootApplication(scanBasePackages = {"aws.boot.user"})
public class AwsBootAdminServerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(AwsBootAdminServerApplication.class, args);
	}
}
