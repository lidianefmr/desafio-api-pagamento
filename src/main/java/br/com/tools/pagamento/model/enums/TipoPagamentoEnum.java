package br.com.tools.pagamento.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum TipoPagamentoEnum {

    AVISTA("AVISTA"),
    PARCELADO_LOJA("PARCELADO LOJA"),
    PARCELADO_EMISSOR("PARCELADO EMISSOR");

    private String tipo;

    public static TipoPagamentoEnum buscarPorTipo(String nomeTipo) {
        return Arrays.stream(values())
                .filter(tipoEnum -> tipoEnum.getTipo().equals(nomeTipo))
                .findFirst()
                .orElseThrow( () -> new IllegalArgumentException(nomeTipo + " "));
    }

}
