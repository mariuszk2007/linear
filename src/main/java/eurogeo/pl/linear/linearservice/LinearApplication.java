package eurogeo.pl.linear.linearservice;

import eurogeo.pl.linear.linearservice.services.RoleService;
import eurogeo.pl.linear.linearservice.services.RoleServiceImpl;
import eurogeo.pl.linear.linearservice.services.UserService;
import eurogeo.pl.linear.linearservice.services.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class LinearApplication {

	public static void main(String[] args) {
		SpringApplication.run(LinearApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**");
			}
		};
	}
	@Bean
	public UserService userService() {
		return new UserServiceImpl();
		}
		@Bean
	RoleService roleService(){
		return new RoleServiceImpl();
		}
}
