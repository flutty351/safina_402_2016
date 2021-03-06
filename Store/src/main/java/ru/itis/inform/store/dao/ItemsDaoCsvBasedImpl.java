package ru.itis.inform.store.dao;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import ru.itis.inform.store.dao.models.Item;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


@Component
public class ItemsDaoCsvBasedImpl implements ItemsDao {
    private static Logger log = Logger.getLogger(ItemsDaoFileBasedImpl.class.getName());

    BufferedReader bufferedReader;
    ArrayList<Item> items;
    String filePath = "/home/aliya/IdeaProjects/reps/Store/src/main/resources/inputData/in.csv";


    public ItemsDaoCsvBasedImpl() throws IOException {

        items = new ArrayList<Item>();
        try {

            String line;
            String[] itemNames;
            bufferedReader = new BufferedReader(new FileReader(filePath));
            while ((line = bufferedReader.readLine()) != null) {

                itemNames = line.split(",");

                items.add(new Item(itemNames[0], Double.parseDouble(itemNames[1])));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void delete(String itemName) {
        Item item = select(itemName);
        if (item != null) {
            items.remove(item);
            log.info("Item has been deleted.");
        } else {
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