package br.ufpb.disciplina.estrutura.dados.atividades.atv1;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class Stack1 <Item> implements Iterable <Item> {
    private Node<Item> first;
    private int n;

    private static class Node<Item> {
        private Item item;
        private Node<Item> next; //Guarda o endereço de um objeto da classe Nó;
        //Esse endereço pode ser nulo
    }

    public Stack1() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        first = null;
        return true; // se for vazio ele retorna verdadeiro
    }

    public int size() {
        return n;
    }

    /**
     * Adds the item to this stack
     *
     * @param item the item to add
     */
    public void push(Item item) {
        Node<Item> oldFirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item; // save item to return
        first = first.next;     // delete first node
        n--;
        return item;            // return the saved item
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.item;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    }

    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);

    }

    private class ListIterator<Item> implements Iterator<Item>{
        private Node<Item> current;


        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main (String[]args){
        Stack1 <String> stack = new Stack1<String>();
        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            if(!item.equals("-"))
                stack.push(item);
            else if (!stack.isEmpty())
                StdOut.print(stack.pop() + " ");

        }
        StdOut.println("(" + stack.size() +  "left on stack)");
    }



}