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
import java.time.LocalDateTime;
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
			p1.setDataPagamento(LocalDateTime.now());
			p1.setFatura("145T5R");

			try{
				pagamentoRepository.save(p1);
			}catch (Exception e) {
				e.printStackTrace();
			}
			p1.setNumTransacao(1L);

			p1 = pagamentoRepository.save(p1);
			System.out.println("Pagamento 1:"+p1);
			p1.setFormaDePagamento("Pix");
			p1 = pagamentoRepository.save(p1);
			System.out.println("Pagamento 2:"+p1);

			p1 = new Pagamento();
			p1.setNumTransacao(2L);
			p1.setNome("Outro");
			p1.setSobrenome("Pereira");
			p1.setFatura("12FE");
			p1.setValor(40.5);
			p1.setTelefone("62983472251");
			p1.setDataPagamento(LocalDateTime.now());
			p1.setFormaDePagamento("Banco Itaú");
			p1 = pagamentoRepository.save(p1);

			imprimirLista(pagamentoRepository);

			pagamentoRepository.delete(p1);

			imprimirLista(pagamentoRepository);

			/*boolean fatura_duplicada = false;
			Integer totalUsoEmail = pagamentoRepository.countUtilizacaoEMail(a1.getEMail());
			if(totalUsoEmail>0){
				System.out.println("O e-mail:"+a1.getEMail()+" não pode ser utilizado!!");
				System.out.println("Total de utilização: "+totalUsoEmail);
			}else{
				alunoRepository.save(a1);
			}

			Optional<Aluno> alunoByEMail = alunoRepository.findAlunoByeMail(a1.getEMail());
			if(alunoByEMail.isPresent()){
				Aluno aluno = alunoByEMail.get();
				System.out.println("Não é possível utilizar o emaili:"+a1.getEMail());
				System.out.println("Porque ele pertence ao aluno:"+aluno.getPrimeiroNome());
			}else{
				a1 = alunoRepository.save(a1);
			}
			try {
				a1 = alunoRepository.save(a1);
			} catch (Exception e){
				System.out.println(e.getMessage());
				email_duplicado = e.getMessage().contains(Aluno.UK_AMIGO_MAIL);
			}
			if(email_duplicado){
				System.out.println("Email duplicado:"+ a1.getEMail());
			}

			System.out.println("Aluno2: "+ a1);
			imprimirLista(alunoRepository);
			alunoRepository.delete(a1);
			imprimirLista(alunoRepository);
			*/



		};
	}

	private static void imprimirLista(PagamentoRepository pagamentoRepository) {
		List<Pagamento> lista = pagamentoRepository.findAll();
		lista.forEach(item -> {
			System.out.println("Pagamento: " + item);
		});
	}

}
