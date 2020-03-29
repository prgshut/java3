package HW1;

import java.util.ArrayList;
import java.util.List;


public class AddArrayList<T> {
    List<T> arLi;
    public List<T> addArra (T[] arr){
       arLi = new ArrayList<>();
        for (T ar : arr) {
            arLi.add(ar);
        }
        return arLi;
    }
}
