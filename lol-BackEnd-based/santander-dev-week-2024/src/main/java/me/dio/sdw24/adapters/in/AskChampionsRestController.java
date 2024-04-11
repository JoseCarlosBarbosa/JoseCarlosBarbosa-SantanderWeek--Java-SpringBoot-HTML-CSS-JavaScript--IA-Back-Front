package me.dio.sdw24.adapters.in;

import io.swagger.v3.oas.annotations.tags.Tag;
import me.dio.sdw24.application.AskChampionsUseCase;
import org.springframework.web.bind.annotation.*;

// criação de controladores Rest para expor EndPoints


@Tag(name = "Campeões", description = "Endpoints do dominio de campeos do LOL.")
@RestController
@RequestMapping("/champions")
public record AskChampionsRestController(AskChampionsUseCase useCase) {

    //sweguer faz o mapeamento na interface Precisa de um body por ser um post
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping("/{championId}/ask")
    public AskChampionResponse askChampion( @PathVariable Long championId, @RequestBody AskChampionRequest request){

        String answer = useCase.askChampions(championId, request.question());

        return new AskChampionResponse(answer);
    }
    public record AskChampionRequest(String question){

    }
    public record AskChampionResponse(String answer){

    }

}



