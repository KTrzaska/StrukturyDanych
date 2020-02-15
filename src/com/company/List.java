package com.company;

public class List {
    private ListItem first;
    private ListItem last;

    public List() {
        this.first = null;
        this.last = null;
    }

    public void addFirst(int value) {
        if (isEmpty()) {
            ListItem elem = new ListItem(value, null, null);
            first = last = elem;
        } else {
            ListItem elem = new ListItem(value, getFirst(),null);
            first.setPrev(elem);
            first = elem;
            
            /* OR, without getFirst/Last(): 
            
            public void addFirst(int value){

    List elem = new List(value, null, null);

    if(isEmpty()){

        first = last = elem;
    } else {

        elem.setNext(first);
        first.setPrev(elem);
        first = elem;



    }
 */          
        }
    }

    public void addLast(int value) {
        if (isEmpty()) {
            ListItem elem = new ListItem(value, null, null);
            first = last = elem;
        } else {
            ListItem elem = new ListItem(value, null, getLast());
            last.setNext(elem);
            last = elem;
            
      
        }
    }


    public int pollFirst() {
        if (isEmpty()) {
            throw new ListEmptyException();
        }
        int value = first.getValue();
        if (first == last) {
            first = last = null;
        } else {
         first = first.getNext();
         // need "first.setPrev(null);" to breake "prev" referention
            
            
        }
        return value;
    }

    public int pollLast() {
        if (isEmpty()) {
            throw new ListEmptyException();
        }
        int value = last.getValue();
        if (first == last) {
            first = last = null;
        } else {
            last = last.getPrev();
            // need "last.setNext(null);" to breake "next" reference
        }
        return value;
    }

    public int peekLast() {
        if (isEmpty()) {
            throw new ListEmptyException();
        }

        return last.getValue();
    }

    public int peekFirst() {
        if (isEmpty()) {
            throw new ListEmptyException();
        }

        return first.getValue();
    }

    public boolean isEmpty() {
        return ((last == null) && (first == null));
    }

    public void show() {
        System.out.println("Wypisuję listę od początku!");
        ListItem tmp = first;
        if (first == last){
            System.out.println(tmp.getValue());
            return;
        }
        while (tmp != null) {
            System.out.print(tmp.getValue() + " ");
            tmp = tmp.getNext();
        }
        System.out.println();
    }

    public void showReverse() {
        System.out.println("Wypisuję listę od końca!");
        ListItem tmp = last;
        if (first == last){
            System.out.println(tmp.getValue());
            return;
        }
        while (tmp != null) {
            System.out.print(tmp.getValue() + " ");
            tmp = tmp.getPrev();
        }
        System.out.println();
    }

    public ListItem getFirst() { // not nedeed at all
        return first;
    }

    public ListItem getLast() { // not need at all
        return last;
    }
}
