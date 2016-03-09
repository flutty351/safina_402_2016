package ru.itis.inform.store.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.itis.inform.store.dao.ItemsDaoConfig;

import java.io.IOException;

@Configuration
@Import(ItemsDaoConfig.class)
public class StoreServiceConfig {
    @Autowired ItemsDaoConfig itemsDaoConfig;

    @Bean
    public StoreService storeService() throws IOException {
        return new StoreServiceImpl(ItemsDaoConfig.itemsDao());
    }
}
