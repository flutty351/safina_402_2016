package store;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import store.dao.ItemsDaoFileBasedImpl;
import store.services.StoreService;
import store.services.StoreServiceImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //StoreService ss = new StoreServiceImpl(new ItemsDaoFileBasedImpl("/home/aliya/IdeaProjects/Store1/src/main/resources/in.txt"));
        ApplicationContext context =
                new ClassPathXmlApplicationContext("app-context.xml");

        StoreService storeService = context.getBean("buy", StoreService.class);

        storeService.buy("qwe");
    }
}
