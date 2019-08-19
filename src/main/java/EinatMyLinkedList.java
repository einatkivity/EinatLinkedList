import java.util.List;

public class EinatMyLinkedList<T> implements IMyLinkedList<T>{

    private Link head;
    private int size;

    public EinatMyLinkedList(T data) {
        Link link= new Link(data);
        head=link;
        size=1;
    }

    public Link getLink(int index) {
        int i=0;
        Link iterateLink=head;
        while (i<index){
            i++;
            iterateLink=iterateLink.next;
        }
        return iterateLink;
    }

    public T getData(int index) {
        return (T) getLink(index).data;
    }


    public void addAfter(int index, T data) {
        Link link=new Link(data);
        Link before=getLink(index);
        Link after=getLink(index+1);

       if(after==null){
           before.next=link;
           link.prev=before;
           size++;
       }
       else {
           before.next = link;
           link.prev = before;
           after.prev = link;
           link.next = after;
           size++;
       }
    }

    public int getIndex(T data) {
        int i=0;
        Link iterateLink=head;
        while (!(iterateLink.data.equals(data))) {
            i++;
            iterateLink=iterateLink.next;
        }
        return i;
    }

    public void removeAt(int index) {
        int i=0;

        Link iterateLink=head;
        while (i<index){
            i++;
            iterateLink=iterateLink.next;
        }
        if(iterateLink.data.equals(head.data))
            head=head.next;

        if(iterateLink.next!=null && iterateLink.prev!=null) {
            iterateLink.prev.next = iterateLink.next;
            iterateLink.next.prev=iterateLink.prev;
        }
        else if(iterateLink.next!=null){
            iterateLink.next.prev=null;
        }
        else if(iterateLink.prev!=null){
            iterateLink.prev.next=null;
        }

        iterateLink=null;
        size--;
    }

    public String print(List list) {
        Link iterateLink=head;
        String forAll="";
        while (iterateLink!=null){
            forAll=forAll+ iterateLink.data;
            iterateLink=iterateLink.next;
        }
        return forAll;
    }

    private class Link<T>{
        private T data;
        private Link next;
        private Link prev;

        public Link(T data, Link next, Link prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;

        }

        public Link(T data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }




}