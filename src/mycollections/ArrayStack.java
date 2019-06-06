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
 * @author João Coelho nº39961 EI
 * @author Diogo Ramos nº39954 EI
 * @param <E> (NAO SEI)
 */

public class ArrayStack<E> implements Stack<E> {
   
    private static final int CAPACITY=1000;
    private E[] data;
    private int t =-1;
    
    public ArrayStack(){this(CAPACITY);}
    
    /**
     *
     * @param Constroi um novo ArrayStack vazio com maximo de capacidade (int CAPACITY)
     */
    public ArrayStack(int CAPACITY){
        data= (E[])  new Object[CAPACITY];
    }

    /**
     *
     * @return o valor do tamanho do Array através da variavel t.
     */
    public int size(){return(t+1);}
    
    /**
     * 
     * @return se a stack estiver vazia no momento.
     */
    public boolean isEmpty(){return (t==-1);}
    
    /**
     *
     * @param Empurra um novo item para o topo da stack.
     * @throws IllegalStateException se a stack se apresentar atualmente cheia.
     */
    public void push(E e) throws IllegalStateException{
        if(size()==data.length) throw new IllegalStateException("Stack is full");
        data[++t]=e;
    }
    
    /**
     * 
     * @return o valor do item que está no topo da stack.
     */
    public E top(){
        if(isEmpty())return null;
        return data[t];
    }
    
    /**
     *  Pops o item no topo da stack fora da stack e retorna-o. Caso a stack esteja vazia, o valor retornado é nulo.
     * @return (NAO SEI)
     */
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
