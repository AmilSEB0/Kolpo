package api.api;

import api.api.dao.Formdao;
import api.api.dao.Listformdao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

import java.util.ArrayList;

import api.api.form.*;

@SpringBootApplication
public class ApiApplication {

	// public final Formdao formdao;
	// public final Listformdao listformdao;

	// public ApiApplication(Formdao formdao, Listformdao listformdao) {
	// 	this.formdao = formdao;
	// 	this.listformdao = listformdao;
	// }

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);

	}
	@Bean
	public CommandLineRunner initData(Formdao formdao, Listformdao listformdao) {
		return args -> {
			// Formes
			Rectangle rectangle = new Rectangle(30, 50,1);
			Rectangle rectangle2 = new Rectangle(20, 10,1);
			Triangle triangle = new Triangle(20,30,1);
			Cercle cercle = new Cercle(20,1);

			

			// List
			ArrayList<Form> liste1 = new ArrayList<>();
			liste1.add(rectangle);
			liste1.add(rectangle2);
			liste1.add(triangle);
			liste1.add(cercle);

		
			ListForm Koplo = new ListForm(liste1, "Koplo");

			// List 2
			ArrayList<Form> liste2 = new ArrayList<>();

			ListForm liste = new ListForm(liste2,"liste");
			

			listformdao.save(Koplo);
			listformdao.save(liste);
		};
	}


}



