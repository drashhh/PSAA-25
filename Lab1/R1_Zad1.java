package Lab1;
import org.w3c.dom.*;

import java.util.LinkedList;

public class R1_Zad1 {
    static void main(String[] args) {
        LinkedList <Integer> lista = new LinkedList<>();
        for(int i = 0; i < 5; i++){
            lista.add((int)(Math.random() * 10));
        }
        System.out.print("Pecatenje na listata > ");
        for(int broj : lista){
            System.out.print(broj+ " ");
        }
        System.out.println();
        lista = otstraniClen(4, lista);
        System.out.print("Pecatenje na nova lista > ");
        for(int broj : lista){
            System.out.print(broj+ " ");
        }
        System.out.println();
    }

    public static LinkedList<Integer> otstraniClen(int n, LinkedList<Integer> lista){
        int i = 0;
        for(i = 0; i < lista.size(); i++){
        }
        lista.remove(i - n);

        return lista;
    }
}
