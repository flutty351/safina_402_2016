package store;

import store.dao.ItemsDaoFileBasedImpl;
import store.dao.models.Item;
import store.services.StoreService;
import store.services.StoreServiceImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        StoreService ss = new StoreServiceImpl(new ItemsDaoFileBasedImpl("/home/aliya/IdeaProjects/Store1/src/main/java/store/in.txt"));
        ss.buy("item1");
        System.out.println(ss.isExist("it"));
        System.out.println(ss.isExist("item1"));
        System.out.println(ss.isExist("item2"));
    }
}
