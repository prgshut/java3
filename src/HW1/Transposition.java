package HW1;

public class Transposition<T> {
    private T[] ar;
    private T a;
    public T[] trans(T[] ar){
        if(ar.length==2) {
            a = ar[0];
            ar[0] = ar[1];
            ar[1] = a;
            return ar;
        }
        return null;
    }
}
