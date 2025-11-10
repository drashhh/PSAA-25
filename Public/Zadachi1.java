package Public;
/*
Dve dvojno povrzani listi cii jazli sodrzat paren broj na celi broevi,
Da se napisi funkcija koja prima argumenti po dva elementi od dvete listi
(dva broja od pocetok na prvata i dva od krajot na vtorata)
i se proveruva da li zbirot e isti vo dvete listi, ako e ispolnet se smestuva zbirot vo nova dvojno povrzana lista
ako ne e ispolnet togas se zapisuva 0, ako se izmine edna pred druga togas rezultatot se stava vo rezultatnata lista

 */
public class Zadachi1 {
    public void main(String[] args) {
        DLinkedList<Integer> lista1 = new DLinkedList<Integer>();
        DLinkedList<Integer> lista2 = new DLinkedList<Integer>();
        lista1.insertFirst(2);
        lista1.insertLast(5); lista1.insertLast(7); lista1.insertLast(9); lista1.insertLast(3); lista1.insertLast(3);
        lista1.insertLast(7); lista1.insertLast(1);

        lista2.insertFirst(5);
        lista2.insertLast(3); lista2.insertLast(4); lista2.insertLast(1); lista2.insertLast(5); lista2.insertLast(1); lista2.insertLast(1); lista2.insertLast(5);
        lista2.insertLast(5); lista2.insertLast(3); lista2.insertLast(4); lista2.insertLast(4); lista2.insertLast(1); lista2.insertLast(3);

        lista1.printList();
        lista2.printList();
        listaPresmetaj(lista1, lista2);

    }

    private void listaPresmetaj(DLinkedList<Integer> lista1, DLinkedList<Integer> lista2) {
        DLinkedList<Integer> rezultantna = new DLinkedList<Integer>();
        Node<Integer> l11, l12, l21,l22; int zbir;
        l11 = lista1.getHead();
        l12 = l11.next;
        l22 = lista2.getTail();
        l21 = l22.prev;

        if(l12.next.next != null && l21.prev.prev != null){
            zbir = presmetajZbir(l11,l12,l21,l22);
            rezultantna.insertLast(zbir);
            l11 = l12.next;
            l12 = l11.next; // da se dovrsat edge kejsovite
        }else{
            if(l12.next != null){

            }
        }

    }

    private int presmetajZbir(Node<Integer> l11, Node<Integer> l12, Node<Integer> l21, Node<Integer> l22) {
        if((l11.data+l12.data) == (l21.data+l22.data)){
            return (l11.data+l12.data);
        }else{
            return 0;
        }
    }

    public class Node<E> {
        protected E data;
        protected Node<E> prev, next;

        public Node() {
            data = null;
            prev = next = null;
        }

        public Node(E data, Node<E> prev, Node<E> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    public class DLinkedList<E> {
        private Node<E> head, tail;

        public Node<E> getHead() {
            return head;
        }

        public Node<E> getTail() {
            return tail;
        }

        public DLinkedList() {
            head = null;
            tail = null;
        }

        public void insertFirst(E e) {
            Node<E> first = new Node(e, null, head);

            if (head != null) {
                head.prev = first;
            }

            if (tail == null) {
                tail = first;
            }

            head = first;
        }

        public void insertLast(E e) {
            if (head != null) {
                Node<E> last = new Node(e, tail, null);
                tail.next = last;
                tail = last;
            } else {
                this.insertFirst(e);
            }
        }

        public void printList() {
            Node<E> tmp = head;
            if (tmp != null) {
                while (tmp.next != null) {
                    System.out.print(tmp.data + " <-> ");
                    tmp = tmp.next;
                }
                System.out.println(tmp.data);
            }
        }
    }
}
