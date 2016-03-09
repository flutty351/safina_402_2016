package ru.itis.inform.store.services;


import ru.itis.inform.store.dao.ItemsDao;

import java.io.FileInputStream;
import java.util.Properties;

public class StoreServiceFactory {
    private static StoreServiceFactory instance;

    private Properties properties;

    private ItemsDao itemsDao;
    private StoreService storeService;
    private String filePath;

    private StoreServiceFactory() {
        properties = new Properties();

        try {
            properties.load(
                    new FileInputStream("/home/aliya/IdeaProjects/reps/Store/src/main/resources/store.properties"));

            String itemsDaoClass = properties.getProperty("itemsDao.class");
            String storeServiceClass = properties.getProperty("storeService.class");
            this.filePath = properties.getProperty("filePath");

            this.itemsDao = (ItemsDao)Class.forName(itemsDaoClass).getConstructor(String.class).newInstance(filePath);
            this.storeService = (StoreService)Class.forName(storeServiceClass).getConstructor(ItemsDao.class).newInstance(itemsDao);

        } catch (Exception ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    static {
        instance = new StoreServiceFactory();
    }

    public ItemsDao getItemsDao() {
        return itemsDao;
    }

    public StoreService getStoreService() {
        return storeService;
    }

    public static StoreServiceFactory getInstance() {
        return instance;
    }

    public String getFilePath() {
        return filePath;
    }
}