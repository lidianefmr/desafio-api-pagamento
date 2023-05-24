package br.com.tools.pagamento.model;

import br.com.tools.pagamento.model.enums.TipoPagamentoEnum;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TB_FORMA_PAGAMENTO")
public class FormaPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "TIPO")
    private TipoPagamentoEnum tipo;

    @Column(name = "PARCELAS")
    private Integer parcelas;

}
