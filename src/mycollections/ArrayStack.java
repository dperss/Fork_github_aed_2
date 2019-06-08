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
 * 
 * Classe filha da Stack
 * @param <E> Tipo de dados génerico.
 */

public class ArrayStack<E> implements Stack<E> {
   
    private static final int CAPACITY=1000;
    private E[] data;
    private int t =-1;
    
    public ArrayStack(){this(CAPACITY);}
    
    /**
     *  Constroi um novo ArrayStack vazio com uma capacidade pré definida.
     * @param CAPACITY o tamnho do array que nescaso é 1000
     */
    public ArrayStack(int CAPACITY){
        data= (E[])  new Object[CAPACITY];
    }

    /**
     *  O Tamanho do array.
     * @return o valor do tamanho do Array através da variavel t.
     */
    public int size(){return(t+1);}
    
    /**
     * Um metodo para ver se o array tá vazio.
     * @return se a stack estiver vazia no momento.
     */
    public boolean isEmpty(){return (t==-1);}
    
    /**
     * Empurra um novo item para o topo da stack.
     * @param e tipo de dados génericos.
     * @throws IllegalStateException se a stack se apresentar atualmente cheia.
     */
    public void push(E e) throws IllegalStateException{
        if(size()==data.length) throw new IllegalStateException("Stack is full");
        data[++t]=e;
    }
    
    /**
     * Metodo para ver o valor no top do stack.
     * @return o valor do item que está no topo da stack.
     */
    public E top(){
        if(isEmpty())return null;
        return data[t];
    }
    
    /**
     *  Remove o item no topo da stack e retorna-o.
     * @return retornao valor no topo da stack e se tiver vazia, o valor retornado é nulo.
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
