import java.util.ArrayList;

public class Audit3Zad1 {
    public void main(String[] args){
        EPLista <Integer> lista = new EPLista();
        lista.vnesiPrv(5);
        lista.vnesiPosleden(2);
        lista.vnesiPosleden(3);
        lista.vnesiPosleden(4);
        lista.vnesiPrv(7);
        lista.pecatiLista();
        lista.brisiPosleden();
        lista.pecatiLista();
        lista.vnesiPosleden(10);
        lista.pecatiLista();
        lista.prevrtiLista();
        lista.pecatiLista();

    }
    class Node <D>{
        protected D data;
        protected Node <D> next;
        public Node(D data, Node <D> next){
            this.data = data;
            this.next = next;
        }
        public Node(){
            this.data = null;
            this.next = null;
        }
    }
    class EPLista <D>{
        private Node <D> head;
        public EPLista(){
            this.head = null;
        }
        public void vnesiPrv(D data){
            this.head = new Node(data, this.head);
        }
        public void vnesiPosleden(D data){
            if(head != null){
                Node <D> tmp = head;
                while(tmp.next != null){
                    tmp = tmp.next;
                }
                Node <D> last = new Node<>(data, null);
                tmp.next = last;
            }
        }
        public Node getHead(){
            return this.head;
        }
        public void pecatiLista(){
            Node <D> tmp = head;
            System.out.print("Head > ");
            while(tmp.next != null){
                System.out.print(tmp.data + " > ");
                tmp = tmp.next;
            }
            System.out.println(tmp.data);
        }
        public void brisiPosleden(){
            Node <D> tmp = head;
            while(tmp.next.next != null){
                tmp = tmp.next;
            }
            tmp.next = null;
        }
        public void prevrtiLista(){
            Node <D> tmp = head;
            Node <D> prethodnik = null;
            Node <D> sledbenik = null;
            while(tmp != null){
                sledbenik = tmp.next;
                tmp.next = prethodnik;
                prethodnik = tmp;
                tmp = sledbenik;
            }
            head = prethodnik;
        }
    }
}
