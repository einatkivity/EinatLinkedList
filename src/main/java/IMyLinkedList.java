import java.util.List;

public interface IMyLinkedList<T> {

    void addAfter(int index,T data);

    int getIndex(T data);

    void removeAt(int index);

    T getData(int index);

    String print();






}
