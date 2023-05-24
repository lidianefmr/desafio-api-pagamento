package br.com.tools.pagamento.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransacaoRequestDTO {

    @NotNull(message = "O campo é obrigatório")
    private String cartao;

    @NotNull(message = "O campo é obrigatório")
    private Long id;

    @NotNull(message = "O campo é obrigatório")
    private DescricaoRequestDTO descricao;

    @NotNull(message = "O campo é obrigatório")
    private FormaPagamentoRequestDTO formaPagamento;

}
