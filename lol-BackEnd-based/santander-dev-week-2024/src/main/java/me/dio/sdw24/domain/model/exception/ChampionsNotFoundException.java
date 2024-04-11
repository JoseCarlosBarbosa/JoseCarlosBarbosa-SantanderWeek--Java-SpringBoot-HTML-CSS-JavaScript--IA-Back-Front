package me.dio.sdw24.domain.model.exception;

public class ChampionsNotFoundException extends RuntimeException{

    public ChampionsNotFoundException (Long championId){
        super("champion %d not found.". formatted(championId));
    }
}
