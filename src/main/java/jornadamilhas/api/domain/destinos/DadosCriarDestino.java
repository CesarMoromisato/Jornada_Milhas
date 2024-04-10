package jornadamilhas.api.domain.destinos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DadosCriarDestino(

        @NotBlank
        String foto1,

        @NotBlank
        String foto2,

        @NotBlank
        String nome,

        @NotBlank
        @Size(max=160)
        String meta,
        String textodescritivo) {

}
