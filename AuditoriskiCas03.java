import org.w3c.dom.Node;

import javax.swing.event.InternalFrameEvent;
import java.util.LinkedList;
public class AuditoriskiCas03 {
    public static void main(String[] args) {
        LinkedList<Integer> lista = new LinkedList<>();
    }
    class Node <D>{
        protected D data;
        protected AuditoriskiCas03.Node<D> next;
        public Node(D data, AuditoriskiCas03.Node<D> next){
            this.data = data;
            this.next = next;
        }
        public Node(){
            this.data = null;
            this.next = null;
        }
    }
    public static void change(LinkedList<Integer> list){
        Node<Integer> s1, s2, pom1, pom2;
        s1 = list.getFirst(); // napravi go so SlinkedList ne rabote so linked list
        s2 = s1.next;
        pom1 = s1; pom2 = s2;
        while(pom1 != null && pom2 != null && pom2.next != null && pom2.next.next != null){
            pom1.next = pom2.next;
            pom2.next = pom2.next.next;

            pom1 = pom1.next;
            pom2 = pom2.next;
        }
        pom1.next = s2;
        pom2.next = null;
    }
}


