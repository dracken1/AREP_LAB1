package edu.escuelaing.arem.ASE.app;


import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyMeanStandardLinkedList implements List{

    Node head = new Node(0,null);
    Node tail = new Node(0,null);
    int size = 0;
    int mean;
    int total = 0;
    int innermean;

    public static class Node{
        int index;
        double data;
        Node next;
        Node prior;

        public Node(double data, Node prior){
            this.data = data;
            this.prior = prior;
            this.next = null;
        }
    }

    public double calcMean(){
        mean = total/size;
        return mean;
    }

    public  double calcStandard(){
        double tmp = 0;
        innermean = total/size;
        Node data = head;
        for (int i=0;i<size;i++){
            tmp += (double)Math.pow((data.data - innermean),2);
        }
        return (double)Math.sqrt(tmp/(size-1));
    }


    // Insert the object o at the end of the list
    public boolean add(double o) {
        if(head.next == null && head.data == 0){
            head.data = o;
            total += o;
            tail = head;
            System.out.println("node: [ data: " + tail.data + ",prior: "+ tail.prior +"]");
            head.index = size;
            size++;
            return true;
        }else{
            Node addo = new Node(o, tail);
            tail.next = addo;
            total += o;
            tail = addo;
            System.out.println("node: [ data: " + tail.data + ",prior: "+ tail.prior.data +"]");
            tail.index = size;
            size++;
            return true;
        }
    }
/*
    public boolean add2(Object o) {

        if(head.next == null){
            System.out.println("entra if");
            Node addo = new Node(o, head);
            head.next = addo;
            return true;
        }else{
            System.out.printf("entra else");
            Node tail = head;
            while(tail.next != null){
                tail = tail.next;
            }
            Node new_tail = new Node(o,tail);
            tail.next = new_tail;
            return true;
        }
    }*/

    public static void printMyLinkedList(MyMeanStandardLinkedList list){
        Node tail = list.head;
        String myLinkedList = "MyLinkedList: ";
        while(tail.next != null){
            myLinkedList+= " [ "+ tail.data +" ] ";
            tail = tail.next;
        }
        System.out.printf(myLinkedList);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {
        return false;
    }

    public Iterator iterator() {
        return null;
    }

    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    public boolean remove(double o) {
        Node tail = head;
        for(int i=0; i<size;i++){
            if(i==0 && tail.data == o){
                System.out.println("entra if");
                head = head.next;
                size--;
                return true;
            } else if(i== size-1 && tail.data == o){
                System.out.println("entra else if 1");
                tail.prior.next = null;
                size--;
            }else if(tail.data == o){
                System.out.println("entra else if 2");
                tail.prior.next = tail.next;
                size--;
            }
            tail = tail.next;
        }

        return true;
    }

    public boolean addAll(Collection c) {
        return false;
    }

    public boolean addAll(int index, Collection c) {
        return false;
    }

    public void clear() {

    }

    public Object get(int index) {
        return null;
    }

    public Object set(int index, Object element) {
        return null;
    }

    public void add(int index, Object element) {

    }

    public Object remove(int index) {
        Node tail = head;
        while(index != tail.index){
            tail= tail.next;
        }
        tail.prior.next = tail.next;
        size--;
        return tail;
    }

    public int indexOf(Object o) {
        return 0;
    }

    public int lastIndexOf(Object o) {
        return 0;
    }

    public ListIterator listIterator() {
        return null;
    }

    public ListIterator listIterator(int index) {
        return null;
    }

    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    public boolean retainAll(Collection c) {
        return false;
    }

    public boolean removeAll(Collection c) {
        return false;
    }

    public boolean containsAll(Collection c) {
        return false;
    }

    public Object[] toArray(Object[] a) {

        return new Object[0];
    }

    public static void main(String[] args) {
        MyMeanStandardLinkedList list = new MyMeanStandardLinkedList();
        list.add(15.0);
        list.add(69.9);
        list.add(6.5);
        list.add(22.4);
        list.add(28.4);
        list.add(65.9);
        list.add(19.4);
        list.add(198.7);
        list.add(38.8);
        list.add(138.2);
        System.out.println("size: " + list.size);
        System.out.println("size: " + list.size);
        System.out.println("total : " + list.total);
        double mean = list.calcMean();
        System.out.println("mean: "+mean);
        System.out.println(mean == 550.6);
        System.out.println("standard: " + list.calcStandard());
        printMyLinkedList(list);
    }
}
