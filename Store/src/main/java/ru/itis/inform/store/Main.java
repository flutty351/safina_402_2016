package ru.itis.inform.store;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itis.inform.store.dao.ItemsDao;
import ru.itis.inform.store.services.StoreService;
import ru.itis.inform.store.services.StoreServiceConfig;
import ru.itis.inform.store.services.StoreServiceFactory;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        //Spring XML Configuration

        /*ApplicationContext context =
                new ClassPathXmlApplicationContext("app-context.xml");

        StoreService storeService = context.getBean("StoreService", StoreService.class);

        storeService.buy("qwe");*/


        //Java Properties Configuration

        /*StoreService storeService = StoreServiceFactory.getInstance().getStoreService();
        storeService.buy("qwe");
        */

        //Spring Java Based Configuration

         ApplicationContext context =
                 new AnnotationConfigApplicationContext(StoreServiceConfig.class);
        StoreService storeService = context.getBean(StoreService.class);
        storeService.buy("qwe");
    }
}
