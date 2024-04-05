package jornadamilhas.api.destinos;

public record DadosDetalhamentoDestinos(

        Long id,
        String foto1,
        String foto2,
        String nome,
        String meta,
        String textodescritivo,
        Boolean ativo
) {

    public DadosDetalhamentoDestinos(Destinos destinos){
        this(destinos.getId(), destinos.getFoto1(), destinos.getFoto2(), destinos.getNome(), destinos.getMeta(), destinos.getTextodescritivo(), destinos.getAtivo());
    }
}
