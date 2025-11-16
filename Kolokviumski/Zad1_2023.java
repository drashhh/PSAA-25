package Kolokviumski;
import java.util.Stack;

public class Zad1_2023 {
    static void main(String[] args) {
        SLinkedList<Integer> niza = new SLinkedList();
        niza.insertFirst(1);
        niza.insertLast(3);
        niza.insertLast(2);
        niza.insertLast(5);
        niza.insertLast(8);
        niza.insertLast(6);
        niza.insertLast(12);
        niza.insertLast(7);
        niza.insertLast(20);

        niza.pecatiLista();
        boolean sortiran = niza.isSortedBy(2);
        System.out.println("Nizata e sortirana spored iti clen > " + sortiran);
    }
    public static class Node<D> {
        protected D data;
        protected Node<D> next;

        public Node(){
            data = null;
            next = null;
        }
        public Node(D data, Node n){
            this.data = data;
            this.next = n;
        }
    }
    public static class SLinkedList<D> {
        private Node<D> head;

        public Node<D> getHead() {
            return head;
        }
        public SLinkedList() {
            head = null;
        }
        public void insertFirst(D d) {
            this.head = new Node(d, this.head);
        }

        public void insertLast(D d) {
            if(head != null){
                Node <D> tmp = head;
                while(tmp.next != null){
                    tmp = tmp.next;
                }
                Node <D> last = new Node<>(d, null);
                tmp.next = last;
            }
        }
        public void pecatiLista(){
            Node <D> tmp = this.head;
            System.out.print("Head > ");
            while(tmp.next != null){
                System.out.print(tmp.data + " > ");
                tmp = tmp.next;
            }
            System.out.println(tmp.data);
        }
        public boolean isSortedBy(int iti){
            boolean sortirana = true;
            if(iti <= 0){
                throw new IllegalArgumentException("Argumentot vo isSortedBy mora da e pogolem od 0");
            }else{
                Stack<Integer> magacin[] = new Stack[iti];
                for(int i= 0; i < iti; i++){
                    magacin[i] = new Stack<>();
                }
                Node <D> tmp = this.head;
                boolean[] sortiranMag = new boolean[iti];
                int brojac = 0;
                while(tmp.next != null){
                    magacin[brojac % iti].push((Integer) tmp.data);
                    tmp = tmp.next; brojac++;
                }
                for(int i =0; i < iti; i++){
                    sortiranMag[i] = sortirajMagacain(magacin[i]);
                    System.out.println("Magacinot " + i + " e sortiran "+ sortiranMag[i]);
                    if(sortiranMag[i] == false){
                        sortirana = false;
                    }
                }

            }
            return sortirana;
        }

    }

    private static boolean sortirajMagacain(Stack<Integer> integers) {
        int tmp; boolean vrati = true;
        Stack<Integer> tmpM = new Stack<>();
        System.out.print("Pecatenje na magacin > ");
        while(!integers.isEmpty()){
            tmpM.push(integers.pop());
        }
        while(!tmpM.isEmpty()){
            integers.push(tmpM.pop());
            System.out.print(integers.peek() + ", ");
        }
        System.out.println();
        tmp = integers.pop();
        while(!integers.isEmpty()){
            if(tmp < integers.peek()){
                vrati = false;
            }
            tmp = integers.pop();
        }
        return vrati;
    }
}
