package br.com.tools.pagamento.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TB_PAGAMENTO", uniqueConstraints={@UniqueConstraint(columnNames = {"id"})})
public class Pagamento {

    @Id
    private Long id;

    @Column(name = "CARTAO")
    private String cartao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DESCRICAO", nullable = false)
    private Descricao descricao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FORMA_PAGAMENTO", nullable = false)
    private FormaPagamento formaPagamento;

}
