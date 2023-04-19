package br.ueg.prog.webi.listapagamentos;

import br.ueg.prog.webi.listapagamentos.repository.PagamentoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);

		//@Bean
		//public CommandLineRunner commandLineRunner (PagamentoRepository pagamentoRepository) {
		//	return args -> {
		//		System.out.println("Executado");
		//	};
		//}

	}

}
