package me.dio.sdw24.adapters.out;

import feign.FeignException;
import feign.RequestInterceptor;
import me.dio.sdw24.domain.model.ports.GenerativeAiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

// client http para consumir a api
@ConditionalOnProperty(name = "generative-ai.provider", havingValue = "GEMINI")
@FeignClient(name = "geminiApi", url = "${gemini.base-url}", configuration = GoogleGeminiService.Config.class)
public interface GoogleGeminiService extends GenerativeAiService {

    @PostMapping("/v1beta/models/gemini-pro:generateContent")
    GoogleGeminiResp textOnlyInput(GoogleGeminiReq req);

    // metodos para adaptar o padrão para que a ia consiga entender,
    @Override
    default String generateContent(String objective, String context){
        String prompt = """
                %s
                %s
                """.formatted(objective,context);
        GoogleGeminiReq req = new GoogleGeminiReq(
                List.of(new Content(List.of(new Part(prompt))))
        );
        try {
            GoogleGeminiResp resp = textOnlyInput(req);
            return resp.candidates().getFirst().content().parts().getFirst().text();
        }catch (FeignException httpErrors) {
        return "Erro de comunicação com API com google Gemini";
        }catch (Exception unexpectedError){
            return "O Retorno da Api do google Gemini não contem os dados esperados";
        }
        }

    record GoogleGeminiReq(List<Content> contents){}
    record Content(List<Part> parts){}
    record Part(String text){}

    record GoogleGeminiResp(List<Candidate> candidates){}
    record Candidate(Content content){}
    class Config {
        @Bean
        public RequestInterceptor apikeyRequestInterceptor(@Value("${gemini.api-key}" )String apiKey){
            return requestTemplate -> requestTemplate.query("key", apiKey);
        }
    }
    }








