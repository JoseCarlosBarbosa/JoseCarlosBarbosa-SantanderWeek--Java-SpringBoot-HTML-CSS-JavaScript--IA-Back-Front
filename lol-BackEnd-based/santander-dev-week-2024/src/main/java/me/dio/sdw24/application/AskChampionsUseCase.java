package me.dio.sdw24.application;

import me.dio.sdw24.Champions;
import me.dio.sdw24.domain.model.exception.ChampionsNotFoundException;
import me.dio.sdw24.domain.model.ports.ChampionsRepository;
import me.dio.sdw24.domain.model.ports.GenerativeAiService;

public record AskChampionsUseCase(ChampionsRepository repository, GenerativeAiService genAiApi) {
    public String askChampions(Long championId, String question){
        Champions champion = repository.findById(championId).orElseThrow(() -> new ChampionsNotFoundException(championId));

        String context = champion.generateContextByQuestion(question);
        String objcetive = """
                Atue como uma assistente com a habilidade de se comportar como os Campeões do League of Legends (LOL).
                Responda as perguntas incorporando a personalidade e estilo de um determinado Campeão.
                Segue a pergunta, o nome do campeão e sua respectiva lore (historia):
                """;


        return genAiApi.generateContent(objcetive, context);



    }
}
