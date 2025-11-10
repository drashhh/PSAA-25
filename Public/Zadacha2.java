package Public;

import java.util.Stack;

public class Zadacha2 {
    boolean proveriHTML(String[] niza){
        Stack<String> st = new Stack<String>();

        return false;
    }
    static void main(String[] args) {
        String htmlTekst = "<html><head></head><body><div></div></body></html>";
        int zavtorenTag = (int)'>';
        int posledenPatPojaveno = htmlTekst.indexOf('>');
        System.out.println(htmlTekst.substring(1, posledenPatPojaveno));
        posledenPatPojaveno++;
        posledenPatPojaveno = htmlTekst.indexOf('>', posledenPatPojaveno);
        System.out.println(htmlTekst.substring(1, posledenPatPojaveno));
       //da se doprave! while(htmlTekst.length())
    }
}
