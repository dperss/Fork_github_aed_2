/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.util.Scanner;
import mycollections.ArrayStack;
import mycollections.Stack;

/*
 * @author João Coelho nº39961 EI
 * @author Diogo Ramos nº39954 EI
 */
public class Principal {

    /**
     * Classe principal 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner myObj = new Scanner(System.in);
        int i = 5;
        String stdvar;
        
        String st1 = "(abcd)";
        System.out.println("INTEGRIDADE DOS PARÊNTESIS" + st1 + "?" + " : " + verificaIntegridade(st1));
        String st2 = "{f>{e>{d>{a<b}}";
        System.out.println("INTEGRIDADE DOS PARÊNTESIS" + st2 + "?" + " : " + verificaIntegridade(st2));
        String st3 = "{7+{6-{5+{2+2}})";
        System.out.println("INTEGRIDADE DOS PARÊNTESIS" + st3 + "?" + " : " + verificaIntegridade(st3));
        String st4 = "{{b{ana}}na}(m)";
        System.out.println("INTEGRIDADE DOS PARÊNTESIS" + st4 + "?" + " : " + verificaIntegridade(st4));
        String st5 = "{j{d{m}d}](m)";
        System.out.println("INTEGRIDADE DOS PARÊNTESIS" + st5 + "?" + " : " + verificaIntegridade(st5));
        String st6 = "{{}}([]){}{}{}{}{[[[[]]]]}";
        System.out.println("INTEGRIDADE DOS PARÊNTESIS" + st6 + "?" + " : " + verificaIntegridade(st6));
           
        while(i != 0){
        System.out.println("Se deseja terminar o progama carregue 0\nSe desejar insirir um string carregue 1\n");
        i = myObj.nextInt();
        if(i == 0) System.exit(1);
        else{
            stdvar = myObj.next();
            System.out.println("INTEGRIDADE DOS PARÊNTESIS" + stdvar + "?" + verificaIntegridade(stdvar));
        }
        }
        
}

    /**
     *  Metodo para verificar a integridade dos parentes.
     * @param std Entra uma string.
     * @return true - se a verificação dos parêntises estiver correta e não 
     * houver parentises mal localizados || return false - se a verificação dos 
     * parêntises estiver errada e houver parentises mal localizados.
     */
    public static boolean verificaIntegridade(String std){
         Stack<Character> pilha = new ArrayStack<>(std.length());
         for (int i = 0; i < std.length(); i++){
            char c = std.charAt(i);

            
            if(c == '{' || c == '(' || c == '[' ){
                pilha.push(c);
            }else{
                if( (c == ']' || c == ')' || c == '}') && pilha.top() == null  ){
                return false;
                }else{
                    if( c == '}' && pilha.top() == '{'){
                    pilha.pop();
                    }else{
                        if( c == ')' && pilha.top() == '('){
                            pilha.pop();
                        }else{
                            if( c == ']' && pilha.top() == '['){
                            pilha.pop();
                            }
                           }
                }
            }
         }
         }
         
         
         if(pilha.size() == 0){
             return true;
         }else{
             return false;
         }
}
}

