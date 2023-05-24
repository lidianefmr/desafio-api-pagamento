package br.com.tools.pagamento.model.dto.response;

import br.com.tools.pagamento.model.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DescricaoResponseDTO {

    @NotNull(message = "O campo é obrigatório")
    private Double valor;

    @NotNull(message = "O campo é obrigatório")
    private Date dataHora;

    @NotNull(message = "O campo é obrigatório")
    private String estabelecimento;

    private Long nsu;

    private Long codigoAutorizacao;

    private StatusEnum status;

}
