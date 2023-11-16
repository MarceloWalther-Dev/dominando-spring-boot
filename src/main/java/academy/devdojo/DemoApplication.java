package academy.devdojo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"academy.devdojo", "teste.api"})  //basePackages pacote base, com o @ComponentScan eu consigo dizer para o spring monitorar e gerenciar outros pacotes
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
