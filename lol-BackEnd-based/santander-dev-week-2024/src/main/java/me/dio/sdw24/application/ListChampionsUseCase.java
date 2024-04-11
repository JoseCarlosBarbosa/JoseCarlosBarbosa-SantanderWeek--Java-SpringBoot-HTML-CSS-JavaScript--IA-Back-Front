package me.dio.sdw24.application;

import me.dio.sdw24.Champions;
import me.dio.sdw24.domain.model.ports.ChampionsRepository;

import java.util.List;

public record ListChampionsUseCase (ChampionsRepository repository) {
    public List<Champions> findAll(){
        return repository.findAll();
    }
}
