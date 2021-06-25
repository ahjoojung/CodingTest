package test;

public class TwoDigrams {
    public static void main(String[] args) {

    }

    public int solution (String s) {
        int n=s.length();

        int max=-1;
        for (int i=0; i<n-1; i++) {
            String key = s.substring(i,i+2);
//                System.out.println("key = " + key);

            for (int j=i+1; j<n-1; j++) {
                String twoLetters = s.substring(j, j+2);
//                    System.out.printf("%s ", twoLetters);
                if ( key.equals(twoLetters) && j-i > max) {
                    max = j - i;
//                        System.out.println("twoLetters = " + twoLetters);
//                        System.out.println("key = " + key);
                }
            }
//                System.out.println();
        }
        return max;
    }
}
