package br.com.tools.pagamento.model.dto.response;

import br.com.tools.pagamento.model.enums.TipoPagamentoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormaPagamentoResponseDTO {

    @NotNull(message = "O campo é obrigatório")
    private TipoPagamentoEnum tipo;

    @NotNull(message = "O campo é obrigatório")
    private Integer parcelas;

}
