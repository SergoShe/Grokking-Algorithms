package chapter3.keysAndBoxes;

public class Item extends Material {
    private final String name;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}