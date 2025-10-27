public class AV1 {
    public static void main(String[] args){
        int[] scores = new int[10];
        for(int i = 0; i < 10; i++){
            scores[i] = (int)(100 * Math.random());
        }
        System.out.print("Poeni > ");
        for(int i = 0; i < 10; i++)
            System.out.print(scores[i]+ " ");

        System.out.println();
    }

}
