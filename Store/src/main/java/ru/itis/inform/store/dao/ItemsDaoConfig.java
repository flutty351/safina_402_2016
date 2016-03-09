package ru.itis.inform.store.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.itis.inform.store.dao.ItemsDao;
import ru.itis.inform.store.dao.ItemsDaoCSVBasedImpl;

import java.io.IOException;

@Configuration
public class ItemsDaoConfig {

    @Bean
    public static ItemsDao itemsDao() throws IOException {
        return new ItemsDaoCSVBasedImpl("/home/aliya/IdeaProjects/reps/Store/src/main/resources/inputData/in.csv");
    }
}
