package jornadamilhas.api.controller;


import jakarta.validation.Valid;
import jornadamilhas.api.destinos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/destinos")
public class DestinosController {

    @Autowired
    private DestinoRepository repository;

    @PostMapping
    @Transactional
    public void criar(@RequestBody @Valid DadosCriarDestino dados){

        repository.save(new Destinos(dados));
    }

    @GetMapping
    public Page<DadosListarDestinos> listar(@PageableDefault(sort = {"nome"}) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListarDestinos::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarDestinos dados){
        var destinos = repository.getReferenceById(dados.id());
        destinos.atualizarInformacoes(dados);
    }
}
