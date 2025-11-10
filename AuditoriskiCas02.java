import java.util.Stack;
public class AuditoriskiCas02 {
    public static void main(String[] args){
        
        // treba da se potpune so informacii
        // proveruva dali sekoj ns-ti clen e sortiran u nizata
        //that's it im done.
    }
    class Node <D>{
        protected D data;
        protected AuditoriskiCas02.Node<D> next;
        public Node(D data, AuditoriskiCas02.Node<D> next){
            this.data = data;
            this.next = next;
        }
        public Node(){
            this.data = null;
            this.next = null;
        }
    }
    class EPLista <D>{
        private AuditoriskiCas02.Node<D> head;
        public EPLista(){
            this.head = null;
        }
        public void vnesiPrv(D data){
            this.head = new AuditoriskiCas02.Node(data, this.head);
        }
        public void vnesiPosleden(D data){
            if(head != null){
                AuditoriskiCas02.Node<D> tmp = head;
                while(tmp.next != null){
                    tmp = tmp.next;
                }
                AuditoriskiCas02.Node<D> last = new AuditoriskiCas02.Node<>(data, null);
                tmp.next = last;
            }
        }
        public AuditoriskiCas02.Node getHead(){
            return this.head;
        }
        public void pecatiLista(){
            AuditoriskiCas02.Node<D> tmp = head;
            System.out.print("Head > ");
            while(tmp.next != null){
                System.out.print(tmp.data + " > ");
                tmp = tmp.next;
            }
            System.out.println(tmp.data);
        }
        public void brisiPosleden(){
            AuditoriskiCas02.Node<D> tmp = head;
            while(tmp.next.next != null){
                tmp = tmp.next;
            }
            tmp.next = null;
        }
        public void prevrtiLista(){
            AuditoriskiCas02.Node<D> tmp = head;
            AuditoriskiCas02.Node<D> prethodnik = null;
            AuditoriskiCas02.Node<D> sledbenik = null;
            while(tmp != null){
                sledbenik = tmp.next;
                tmp.next = prethodnik;
                prethodnik = tmp;
                tmp = sledbenik;
            }
            head = prethodnik;
        }
        public boolean isSortedBy(int ns){
            if(ns < 1){
                throw new IllegalArgumentException("NS invalid.");
            }

            Stack<D> [] stacks = new Stack[ns];
            for(int i = 0; i < ns; i ++){
                stacks[i] = new Stack<>();
            }
            Node<D> pom = getHead();
            while(pom != null){
                for(int i = 0; i < ns && pom != null; i++, pom = pom.next){
                    stacks[i].push(pom.data);
                }
            }
            boolean check = true;
            for(int i = 0; i < ns; i++){
                if(!isSorted(stacks[i])){
                    check = false;
                }
            }

            return check;
        }
    }

    private <D> boolean isSorted(Stack<D> stack) {
        boolean check = true;
        D el = stack.pop();
        while(!stack.isEmpty()){
            if((int) el < (int)stack.pop()){
                check = false;
            }
        }
        return check;
    }
}
