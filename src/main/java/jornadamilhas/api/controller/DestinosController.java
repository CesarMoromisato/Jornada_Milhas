package jornadamilhas.api.controller;


import jornadamilhas.api.depoimentos.DadosCriarDestino;
import jornadamilhas.api.depoimentos.DestinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/destinos")
public class DestinosController {

    @Autowired
    private DestinoRepository repository;
    @PostMapping
    public void criar(@RequestBody DadosCriarDestino dados){

        //repository.save((new Depoimentos(dados)));
        System.out.println(dados);
    }

}
