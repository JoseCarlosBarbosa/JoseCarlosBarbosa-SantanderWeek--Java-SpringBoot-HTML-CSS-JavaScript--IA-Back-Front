package me.dio.sdw24.application;

import me.dio.sdw24.Champions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TesteUseChampiosUseCaseIntegration {
    @Autowired
    private ListChampionsUseCase listChampionsUseCase;

    @Test
    public void testListChampions(){
       List<Champions> champions=listChampionsUseCase.findAll();


        Assertions.assertEquals(12 , champions.size());
    }


}
