package br.ueg.prog.webi.listapagamentos;

import br.ueg.prog.webi.listapagamentos.model.Pagamento;
import br.ueg.prog.webi.listapagamentos.repository.PagamentoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);

	}

	@Bean
	public CommandLineRunner commandLineRunner (PagamentoRepository pagamentoRepository) {
		return args -> {
			System.out.println("Executado");
			System.out.println(pagamentoRepository);
			Pagamento p1 = new Pagamento();
			p1.setNome("Stéphanie");
			p1.setSobrenome("Silva");
			p1.setValor(30.5);
			p1.setTelefone("62995272251");
			p1.setDataPagamento(LocalDate.now());

			try{
				pagamentoRepository.save(p1);
			}catch (Exception e) {
				e.printStackTrace();
			}
			p1.setNumTransacao(1);

			p1 = pagamentoRepository.save(p1);
			System.out.println("Pagamento 1:"+p1);
			p1.setFormaDePagamento("Pix");
			p1 = pagamentoRepository.save(p1);
			System.out.println("Pagamento 2:"+p1);

		};
	}

}
