package me.dio.sdw24.domain.model.ports;

public interface GenerativeAiService {
    String generateContent(String objective, String context);
}
