/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycollections;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Diogo Ramos
 */
public class ArrayStack<E> implements Stack<E> {
   
    private static final int CAPACITY=1000;
    private E[] data;
    private int t =-1;
    
    public ArrayStack(){this(CAPACITY);}
    
    public ArrayStack(int CAPACITY){
        data= (E[])  new Object[CAPACITY];
    }
    public int size(){return(t+1);}
    
    public boolean isEmpty(){return (t==-1);}
    
    public void push(E e) throws IllegalStateException{
        if( size()==data.length) throw new IllegalStateException("Stack is full");
        data[++t]=e;
    }
    
    public E top(){
        if(isEmpty())return null;
        return data[t];
    }
    
    public E pop(){
        if(isEmpty())return null;
        E answer= data[t];
        data[t]=null;
        t--;
        return answer;
    }   
    
    public Iterator<E> iterator(){
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<E>{
        private int j=0;
        
        public boolean hasNext(){ return j<size();}
        
        public E next(){
            if (j==size()) throw new NoSuchElementException("Sem próximo elemento");
            return data[j++];
            
        }
        
        public void remove(){
            throw new UnsupportedOperationException();
        }
    }
    
}
