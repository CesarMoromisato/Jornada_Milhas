package jornadamilhas.api.destinos;

public record DadosListarDestinos(

        Long id,
        String foto1,
        String foto2,
        String nome,
        String meta,
        String textodescritivo
) {

    public DadosListarDestinos(Destinos destinos){
        this(destinos.getId(), destinos.getFoto1(), destinos.getFoto2(), destinos.getNome(), destinos.getMeta(), destinos.getTextodescritivo());
    }
}
