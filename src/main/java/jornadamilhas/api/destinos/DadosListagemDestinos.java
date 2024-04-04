package jornadamilhas.api.destinos;

public record DadosListagemDestinos(

        Long id,
        String foto1,
        String foto2,
        String nome,
        String meta,
        String textodescritivo
) {

    public DadosListagemDestinos(Destinos destinos){
        this(destinos.getId(), destinos.getFoto1(), destinos.getFoto2(), destinos.getNome(), destinos.getMeta(), destinos.getTextodescritivo());
    }
}
