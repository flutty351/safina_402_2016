package ru.itis.inform.store;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itis.inform.store.services.StoreService;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("app-context.xml");

        StoreService storeService = context.getBean("StoreService", StoreService.class);

        storeService.buy("qwe");
    }
}
