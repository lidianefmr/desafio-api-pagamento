package br.com.tools.pagamento.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransacaoResponseDTO {

    @NotNull(message = "O campo é obrigatório")
    private String cartao;

    @NotNull(message = "O campo é obrigatório")
    private Long id;

    @NotNull(message = "O campo é obrigatório")
    private DescricaoResponseDTO descricao;

    @NotNull(message = "O campo é obrigatório")
    private FormaPagamentoResponseDTO formaPagamento;

}
