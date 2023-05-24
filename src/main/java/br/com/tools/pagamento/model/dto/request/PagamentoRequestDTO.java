package br.com.tools.pagamento.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagamentoRequestDTO {

    private TransacaoRequestDTO transacao;

}
