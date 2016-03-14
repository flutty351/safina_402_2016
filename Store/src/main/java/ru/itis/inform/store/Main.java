package ru.itis.inform.store;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.inform.store.services.StoreService;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        //Spring XML Configuration

        /*ApplicationContext context =
                new ClassPathXmlApplicationContext("app-context.txt");

        StoreService storeService = context.getBean("StoreService", StoreService.class);

        storeService.buy("qwe");*/


        //Java Properties Configuration

        /*StoreService storeService = StoreServiceFactory.getInstance().getStoreService();
        storeService.buy("qwe");
        */

        //Spring Java Based Configuration

        ApplicationContext context =
                new AnnotationConfigApplicationContext(StoreConfiguration.class);
        StoreService storeService = (StoreService) context.getBean("storeService");
        storeService.buy("csv");



    }
}
