package chapter3.keysAndBoxes;

import java.util.HashSet;
import java.util.Set;

public class Box extends Material implements IContainsMaterial {
    private final String name;
    private final Set<Material> items;

    public Box(String name, Set<Material> items) {
        this.name = name;
        this.items = items;
    }

    public Box(String name) {
        this.name = name;
        items = new HashSet<>();
    }

    @Override
    public Set<Material> getItems() {
        return items;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void showContain() {
        System.out.println(items);
    }

    @Override
    public void addItem(Material item) {
        items.add(item);
    }

    @Override
    public void addAllItem(Set<Material> items) {
        this.items.addAll(items);
    }
}