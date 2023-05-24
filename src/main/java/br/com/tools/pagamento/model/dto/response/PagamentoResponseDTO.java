package br.com.tools.pagamento.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagamentoResponseDTO {

    private TransacaoResponseDTO transacao;

}
