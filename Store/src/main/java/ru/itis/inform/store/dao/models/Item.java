package store.dao.models;

public class Item {
    String name;
    int amount;

    public Item(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        Item other = (Item) obj;
        if (!this.name.equals(other.name))
            return false;
        return true;
    }
}
