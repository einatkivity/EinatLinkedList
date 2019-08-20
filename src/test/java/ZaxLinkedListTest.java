import java.util.List;

public class ZaxLinkedListTest<T> implements IMyLinkedList<T> {

    private Link head; // Pointer to the head of the list
    private int size; // List's size


    public ZaxLinkedListTest(T data){
        Link firstLink = new Link(data); // Init the list with the first
        this.head = firstLink;
        this.size = 1; // Head is the first link
    }

    // TestMe - Ready to be tested
    public void addAfter(T data, int i) {

        // We don't want to keep null data in our list
        if(data == null){
            return;
        }

        // This is the link we will add to
        Link beforeLink = findAt(i);

        // findAt returns null if index is invalid
        if( beforeLink != null ){
            // Generate this new link (between the two links)
            Link newLink = new Link(data, beforeLink.getNext(), beforeLink);
            // Assign this new link as the next link to the i'th link
            beforeLink.setNext(newLink);
            // If there is another link after the i'th link - assign the new link as it's prev
            if( newLink.getNext() != null){
                newLink.getNext().setPrev(newLink);
            }
            // If added successfully - increase the list size by one
            this.size += 1;
        }
    }


    /*  Help method to find the i'th Link in the list   */
    // Blocking - this method is a key method in this class
    private Link findAt(int index){

        // Check the index is a valid value to the list
        if( index > this.size || index < 0){
            return null;
        }

        // A pointer to iterate over the list
        Link pointer = this.head;
        int i = 0;
        while ( i < index ){
            // Iterates over the list by pointer.next
            pointer = pointer.getNext();
            // Increase the i value until it finds the wanted link
            i++;
        }
        // Returns the wanted link
        return pointer;
    }


    @Override
    public void addAfter(int index, T data) {

    }

    // TestMe - Ready to be tested
    public int getIndex(T data) {

        Link pointer = head;
        int i = 0;
        // Iterates over the list until it finds the link with the given data
        while ( pointer != null ){
            if(pointer.getData().equals(data)){
                // If data was found - return it's first index
                return i;
            }
            // Iterates over the list by pointer.next
            pointer = pointer.getNext();
            // Increase the i value until it finds the wanted link
            i++;
        }

        // If the data doesn't match any of the links, return -1
        return -1;
    }

    // TestMe - Ready to be tested
    public void removeAt(int i) {

        // Removes first link - needs to update the head pointer
        if(i == 0){
            this.head = this.head.getNext();
            // Decrease the list size by 1
            this.size--;
            return;
        }

        // Find the i'th link
        Link toRemove = findAt(i);
        // Equals null if index is invalid
        if(toRemove == null){
            return;
        }

        // The links before and after the i'th link
        Link beforeLink = toRemove.getPrev();
        Link nextLink = toRemove.getNext();


        beforeLink.setNext(nextLink);

        if( nextLink != null ){
            nextLink.setPrev(beforeLink);
        }

        this.size -= 1;


    }

    // TestMe - Ready to be tested
    public T getData(int index) {

        Link toReturn = findAt(index);
        if(toReturn!= null){
            return (T)toReturn.getData();
        }
        return null;
    }

    @Override
    public String print(List list) {
        return null;
    }


    // TestMe - Ready to be tested
    public String printList() {

        if(this.size <= 0){
            return "List is empty";
        }

        String result = "";
        Link pointer = this.head;
        // Iterate over the list
        while (pointer != null){
            result += pointer.getData().toString() + " -> ";
            pointer = pointer.getNext();
        }

        return result;
    }


    private Link getHead() {
        return head;
    }

    private void setHead(Link head) {
        this.head = head;
    }


    private int getSize() {
        return size;
    }





    /* Private class Link */

    private class Link<T>{
        Link next;
        Link prev;
        T data;

        public Link(T data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        public Link(T data, Link next){
            this.data = data;
            this.next = next;
        }

        public Link(T data, Link next, Link prev){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }


        public Link getNext() {
            return next;
        }

        public void setNext(Link next) {
            this.next = next;
        }

        public Link getPrev() {
            return prev;
        }

        public void setPrev(Link prev) {
            this.prev = prev;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }
}

