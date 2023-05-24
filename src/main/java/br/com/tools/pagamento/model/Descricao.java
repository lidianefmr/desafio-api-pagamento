package br.com.tools.pagamento.model;

import br.com.tools.pagamento.model.enums.StatusEnum;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "TB_DESCRICAO")
public class Descricao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "VALOR")
    private Double valor;

    @Column(name = "DATA_HORA")
    private Date dataHora;

    @Column(name = "ESTABELECIMENTO")
    private String estabelecimento;

    @Column(name = "NSU")
    private Long nsu;

    @Column(name = "CODIGO_AUTORIZADOR")
    private Long codigoAutorizacao;

    @Column(name = "STATUS")
    private StatusEnum status;

}
