public class Audit3Zad2 {
    public static void main(String[] args) {

    }
    class Node<D>{
        protected D data;
        protected Node<D> next;
        protected Node<D> prev;
        public Node(){
            data = null;
            next = null;
            prev = null;
        }
        public Node(D data, Node <D> next, Node <D> prev){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
    class DPLista <D>{
        protected Node<D> head;
        protected Node<D> tail;
        public DPLista(){
            head = null;
            tail = null;
        }
        public void vnesiPrv(D data){
            Node<D> prv = new Node<>(data,null,head);
            if(head != null)
                head.prev = prv;
            if(tail == null)
                tail = prv;
            head = prv;
        }
        public void vnesiPosleden(D data){
            if(head != null){
                Node<D> pos = new Node<>(data,tail,null);
                tail.next = pos;
                tail = pos;
            }else{
                vnesiPrv(data);
            }

        }
    }
}
