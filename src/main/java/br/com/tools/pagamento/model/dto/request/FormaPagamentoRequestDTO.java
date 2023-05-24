package br.com.tools.pagamento.model.dto.request;

import br.com.tools.pagamento.model.enums.TipoPagamentoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormaPagamentoRequestDTO {

    @NotNull(message = "O campo é obrigatório")
    private TipoPagamentoEnum tipo;

    @NotNull(message = "O campo é obrigatório")
    private Integer parcelas;

}
