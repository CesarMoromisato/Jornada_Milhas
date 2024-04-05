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
    private Boolean ativo;

    public Destinos(DadosCriarDestino dados){
        this.foto1 = dados.foto1();
        this.foto2 = dados.foto2();
        this.nome = dados.nome();
        this.meta = dados.meta();
        this.textodescritivo = dados.textodescritivo();
        this.ativo = true;
    }

    public void atualizarInformacoes(DadosAtualizarDestinos dados) {
        if(dados.foto1() != null){
            this.foto1 = dados.foto1();
        }
        if(dados.foto2() != null){
            this.foto2 = dados.foto2();
        }
        if(dados.meta() != null){
            this.meta = dados.meta();
        }
        if(dados.textodescritivo() != null){
            this.textodescritivo = dados.textodescritivo();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
