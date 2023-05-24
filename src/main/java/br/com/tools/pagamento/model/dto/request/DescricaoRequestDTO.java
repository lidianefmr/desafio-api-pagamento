package br.com.tools.pagamento.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DescricaoRequestDTO {

    @NotNull(message = "O campo é obrigatório")
    private Double valor;

    @NotNull(message = "O campo é obrigatório")
    private Date dataHora;

    @NotNull(message = "O campo é obrigatório")
    private String estabelecimento;

}
