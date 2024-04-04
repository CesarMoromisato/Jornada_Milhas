package jornadamilhas.api.destinos;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "destinos")
@Entity(name = "Destinos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Destinos {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String foto1;
    private String foto2;
    private String nome;
    private String meta;
    private String textodescritivo;

    public Destinos(DadosCriarDestino dados){
        this.foto1 = dados.foto1();
        this.foto2 = dados.foto2();
        this.nome = dados.nome();
        this.meta = dados.meta();
        this.textodescritivo = dados.textodescritivo();
    }
}
