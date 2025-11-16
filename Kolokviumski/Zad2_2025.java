package Kolokviumski;

public class Zad2_2025 {
    static void main(String[] args) {
        SLinkedList<Integer> niza = new SLinkedList<>();
        SLinkedList<Integer> promeneta = new SLinkedList<>();
        niza.insertLast(1);
        niza.insertLast(2);
        niza.insertLast(3);
        niza.insertLast(4);
        niza.pecatiLista();
        promeneta = niza.razmestiLista(niza);
        promeneta.pecatiLista();
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
            }else{
                this.head = new Node(d, this.head);
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
        public SLinkedList<Integer> razmestiLista(SLinkedList<Integer> lista){
            SLinkedList<Integer> temp = new SLinkedList<>();
            SLinkedList<Integer> temp2 = new SLinkedList<>();
            Node <Integer> tmp = lista.head;
            int brojac = 0;
            while(tmp.next != null){
                if(brojac % 2 == 0){
                    temp.insertLast(tmp.data);
                    System.out.println("Ovde go dodavame "+tmp.data+ " na pocetok");
                }else{
                    temp2.insertLast(tmp.data);
                    System.out.println("Ovde go dodavame "+tmp.data+ " na kraj");
                }
                tmp = tmp.next; brojac++;
            }
            if(brojac % 2 == 0){
                temp.insertLast(tmp.data);
                System.out.println("Ovde go dodavame "+tmp.data+ " na pocetok");
            }else{
                temp2.insertLast(tmp.data);
                System.out.println("Ovde go dodavame "+tmp.data+ " na kraj");
            }
            tmp = temp2.head;
            while(tmp.next!=null){
                temp.insertLast(tmp.data);
                tmp = tmp.next;
            }
            temp.insertLast(tmp.data);
            return temp;
        }
    }
}
