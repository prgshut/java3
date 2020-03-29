package HW1.fruit;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {

    private List<T> filling = new ArrayList<>();

    public void putInBox(T fruit) {
        filling.add(fruit);
    }

    public float getWeight() {
        float weight = 0.0f;

        for (T fruit : filling) {
            weight += fruit.getWeight();
        }

        return weight;
    }

    public boolean compare(Box anotherbox) {
        return getWeight() == anotherbox.getWeight();
    }

    public void intersperse(Box<T> box) {
        box.filling.addAll(filling);
        filling.clear();
    }

}