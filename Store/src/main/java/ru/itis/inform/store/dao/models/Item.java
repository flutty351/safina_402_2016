package ru.itis.inform.store.dao.models;

import com.google.common.base.MoreObjects;

import java.util.Objects;

public class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }


    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.price);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("Price", this.price)
                .add("Name", this.name)
                .toString();
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        Item other = (Item) obj;
        if (!this.name.equals(other.name))
            return false;
        return true;
    }
}
