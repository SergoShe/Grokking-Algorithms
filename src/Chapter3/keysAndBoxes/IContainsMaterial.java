package chapter3.keysAndBoxes;

import java.util.Set;

public interface IContainsMaterial {

    Set<Material> getItems();

    void showContain();

    void addItem(Material item);

    void addAllItem(Set<Material> items);
}