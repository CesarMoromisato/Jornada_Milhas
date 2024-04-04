package jornadamilhas.api.controller;


import jakarta.validation.Valid;
import jornadamilhas.api.destinos.DadosCriarDestino;
import jornadamilhas.api.destinos.DadosListagemDestinos;
import jornadamilhas.api.destinos.DestinoRepository;
import jornadamilhas.api.destinos.Destinos;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<DadosListagemDestinos> listar(){
        return repository.findAll().stream().map(DadosListagemDestinos::new).toList();
    }

}
