package jornadamilhas.api.domain.destinos;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarDestinos(
        @NotNull
        Long id,
        String foto1,
        String foto2,
        String meta,
        String textodescritivo
) {
}
