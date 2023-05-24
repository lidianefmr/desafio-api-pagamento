package br.com.tools.pagamento.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum StatusEnum {

    AUTORIZADO("AUTORIZADO"),
    NEGADO("NEGADO"),
    CANCELADO("CANCELADO");

    private String tipo;

    public static StatusEnum buscarPorTipo(String nomeTipo) {
        return Arrays.stream(values())
                .filter(tipoEnum -> tipoEnum.getTipo().equals(nomeTipo))
                .findFirst()
                .orElseThrow( () -> new IllegalArgumentException(nomeTipo + " "));
    }

}
