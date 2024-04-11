package me.dio.sdw24.adapters.out;

import feign.FeignException;
import feign.RequestInterceptor;
import me.dio.sdw24.domain.model.ports.GenerativeAiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpHeaders;


import java.util.List;

// client http para consumir a api
@ConditionalOnProperty(name = "generative-ai.provider", havingValue = "OPENAI", matchIfMissing = true)
@FeignClient(name = "openAiApi", url = "${openai.base-url}", configuration = OpenAiChatService.Config.class)
public interface OpenAiChatService extends GenerativeAiService {


    @PostMapping("/v1/chat/completions" )
    OpenAiChatcompletionResp chatCompletion(OpenAiChatcompletionReq req);

    // metodos para adaptar o padrão para que a ia consiga entender,
    @Override
    default String generateContent(String objective, String context){
                                                                    /**/
        String model = "gpt-3.5-turbo";
        List<Message> messages = List.of(
                // para a ia define o objetivo a nivel de sistema e o context a pergunta do usuario
                new Message("system", objective),
                new Message("user", context)
        );
        OpenAiChatcompletionReq req = new OpenAiChatcompletionReq(model, messages);

        try {
            OpenAiChatcompletionResp resp = chatCompletion(req);
            return resp.choices().getFirst().message().content();
        }catch (FeignException httpErrors) {
            return "Erro de comunicação com API com Openai ";
        }catch (Exception unexpectedError){
            return "O Retorno da Api do Openai, não contem os dados esperados";
        }

    }


    record OpenAiChatcompletionReq(String model, List<Message> messages){}
    record Message(String role, String content){}
    record OpenAiChatcompletionResp(List<Choice> choices){}
    record Choice(Message message){}

    class Config {
        @Bean
        public RequestInterceptor apikeyRequestInterceptor(@Value("${openai.api-key}" )String apiKey){
            return requestTemplate -> requestTemplate.header(
                    HttpHeaders.AUTHORIZATION,"Bearer %s".formatted(apiKey));
        }
    }
}
