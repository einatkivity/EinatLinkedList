import java.util.List;

public interface IMyLinkedList<T> {

    void addAfter(int index,T data);



    //the big change
    int getIndex(T data);

    void removeAt(int index);

    T getData(int index);

    String print(List list);






}
