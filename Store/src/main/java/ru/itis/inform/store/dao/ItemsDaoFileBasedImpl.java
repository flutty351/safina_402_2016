package ru.itis.inform.store.dao;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.log4j.Logger;
import ru.itis.inform.store.dao.models.Item;

public class ItemsDaoFileBasedImpl implements ItemsDao {

    private static Logger log = Logger.getLogger(ItemsDaoFileBasedImpl.class.getName());

    BufferedReader bufferedReader;
    ArrayList<Item> items;


    public ItemsDaoFileBasedImpl(String filePath) throws IOException {
        items = new ArrayList<>();
        bufferedReader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String itemName = line;
            int price = 0;
            if ((line = bufferedReader.readLine()) != null) {
                price = Integer.valueOf(line);
            }
            items.add(new Item(itemName, price));
        }
    }

    public void delete(String itemName) {
        Item item = select(itemName);
        if (item != null) {
            items.remove(item);
            log.info("Item has been deleted.");
        } else{
            log.info("Item not found.");
        }
    }

    public Item select(String itemName) {
        Iterator<Item> itemsIterator = items.iterator();
        while (itemsIterator.hasNext()) {
            Item item = itemsIterator.next();
            if (item.getName().equals(itemName)) {
                log.info("The " + itemName + " with a price of " + item.getPrice() + " was found.");
                return item;
            } else {
                log.info("Item not found.");
                return null;
            }
        }
        log.info("List is empty.");
        return null;
    }
}