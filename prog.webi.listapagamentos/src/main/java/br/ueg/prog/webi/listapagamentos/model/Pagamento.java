package br.ueg.prog.webi.listapagamentos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "lista_pagamentos")
public class Pagamento {
    @Id
    @Column(name = "num_transacao", nullable = false)
    private Long numTransacao;
    @Column(length = 200, nullable = false)
    private String nome;
    @Column(length = 200, nullable = false)
    private String sobrenome;
    @Column(length = 11)
    private String telefone;

    private double valor;

    @Column(name="data_pagamento")
    private LocalDateTime dataPagamento;

    @Column(name ="forma_pagamento")
    private String formaDePagamento;
    @Column(nullable = false)
    private String fatura;
}
