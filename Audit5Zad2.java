public class Audit5Zad2 {
    public static void main(String[] args){
        int suma = 125;
        int pari[] = {50,20,10,5,1};
        System.out.println("Minimum pari za suma "+suma+" se > "+min_pari_greedy(pari, suma));

    }
    public static int min_pari_greedy(int []pari, int suma){
        int i,j, br = 0, pom;
        int [] brPari = new int[5];
        for(i = 0; i < pari.length-1; i++){
            for(j = i + 1; j<pari.length; j++){
                if(pari[i] < pari[j]){
                    pom = pari[i];
                    pari[i] = pari[j];
                    pari[j] = pom;
                }
            }
        }
        i = 0;
        while(suma > 0 && i < pari.length){
            brPari[i] = suma / pari[i];
            suma -= brPari[i]*pari[i];
            br+= brPari[i];
            i++;
        }
        return br;
    }
}
