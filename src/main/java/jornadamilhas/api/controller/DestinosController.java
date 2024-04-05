package jornadamilhas.api.controller;


import jakarta.validation.Valid;
import jornadamilhas.api.destinos.*;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/destinos")
public class DestinosController {

    @Autowired
    private DestinoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity criar(@RequestBody @Valid DadosCriarDestino dados, UriComponentsBuilder uriBuilder){

        var destinos = new Destinos(dados);
        repository.save(destinos);
        var uri = uriBuilder.path("/destinos/{id}").buildAndExpand(destinos.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoDestinos(destinos));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListarDestinos>> listar(@PageableDefault(sort = {"nome"}) Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListarDestinos::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarDestinos dados){
        var destinos = repository.getReferenceById(dados.id());
        destinos.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoDestinos(destinos));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var destinos = repository.getReferenceById(id);
        destinos.excluir();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var destinos = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoDestinos(destinos));
    }
}
