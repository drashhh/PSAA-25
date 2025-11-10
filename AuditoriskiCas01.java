import java.util.Stack;

public class AuditoriskiCas01 {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(3);
        s.push(4);

        Stack<Integer> temp = new Stack();
        temp = (Stack<Integer>) s.clone();
        while(!temp.isEmpty()){
            System.out.print(temp.pop()+", ");

        }
        System.out.println("");
        recursiveReverse(s);

        while(!s.isEmpty()){
            System.out.print(s.pop()+", ");
        }
    }

    private static void recursiveReverse(Stack<Integer> s) {
        if(s.isEmpty()){
            return;
        }

        int top = s.pop();
        recursiveReverse(s); //mora da e tuka ako e pod insertAtBottom ima beskonecen loop
        insertAtBottom(s, top); //ja sostavuva vo obraten redosled clen po clen
    }

    private static void insertAtBottom(Stack<Integer> s, int el) {
        if(s.isEmpty()){
            s.push(el);
            return;
        }
        int top = s.pop();
        insertAtBottom(s, el);
        s.push(top);
    }
}
