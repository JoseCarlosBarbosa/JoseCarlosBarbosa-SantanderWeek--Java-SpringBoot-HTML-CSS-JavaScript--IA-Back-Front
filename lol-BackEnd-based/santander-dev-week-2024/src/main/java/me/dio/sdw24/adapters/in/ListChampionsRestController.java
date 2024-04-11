package me.dio.sdw24.adapters.in;

import io.swagger.v3.oas.annotations.tags.Tag;
import me.dio.sdw24.application.ListChampionsUseCase;
import me.dio.sdw24.Champions;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


//
// class record e uma classe onde todos os atributos passados por parametros são finais, então ele so pode ser atribuido em tempo de execução
@Tag(name = "Campeões", description = "Endpoints do dominio de campeos do LOL.")
@RestController
@RequestMapping("/champions")
public record ListChampionsRestController(ListChampionsUseCase useCase) {

    @GetMapping
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public List<Champions> findAllChampions(){
        return useCase.findAll();
    }
}
