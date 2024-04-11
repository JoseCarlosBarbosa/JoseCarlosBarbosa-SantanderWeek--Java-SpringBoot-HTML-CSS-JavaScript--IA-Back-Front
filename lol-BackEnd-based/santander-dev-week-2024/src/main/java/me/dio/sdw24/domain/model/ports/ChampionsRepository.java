package me.dio.sdw24.domain.model.ports;

import me.dio.sdw24.Champions;

import java.util.List;
import java.util.Optional;

public interface ChampionsRepository {
    // acesso ao banco de dados para buscar o campeao para o id
    // define as operações que estamos fazendo no banco
    List<Champions> findAll();

    Optional<Champions> findById(Long id);
}
