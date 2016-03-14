package ru.itis.inform.store;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.itis.inform.store.dao.ItemsDao;
import ru.itis.inform.store.dao.ItemsDaoCsvBasedImpl;
import ru.itis.inform.store.dao.ItemsDaoFileBasedImpl;
import ru.itis.inform.store.dao.ItemsDaoTsvBasedImpl;
import ru.itis.inform.store.services.StoreService;
import ru.itis.inform.store.services.StoreServiceImpl;

import java.io.File;
import java.io.IOException;

@Configuration
@ComponentScan("ru.itis.inform.store.dao")
public class StoreConfiguration {
/*
    @Bean
    public ItemsDao itemsDaoCsv() throws IOException {
        return new ItemsDaoCsvBasedImpl("/home/aliya/IdeaProjects/reps/Store/src/main/resources/inputData/in.csv");
    }

    @Bean
    public ItemsDao itemsDaoTsv() throws IOException {
        return new ItemsDaoTsvBasedImpl("/home/aliya/IdeaProjects/reps/Store/src/main/resources/inputData/in.tsv");
    }

    @Bean
    public ItemsDao itemsDaoFile() throws IOException {
        return new ItemsDaoCsvBasedImpl("/home/aliya/IdeaProjects/reps/Store/src/main/resources/inputData/in.txt");
    }
*/
    @Bean
    public StoreService storeService() {
        return new StoreServiceImpl();
    }
}



