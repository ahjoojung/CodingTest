package test;

public class Income {
    public static void main(String[] args) {
        int[][] taxes1 = {{1200,6},{4600,15},{8800,24},{15000,35},{0,38}};
        int income1 = 9500;
        System.out.println(Solution(taxes1, income1));

        int[][] taxes2 = {{1000, 1}, {0, 10}};
        int income2 = 2000;
        System.out.println(Solution(taxes2, income2));

        int[][] taxes3 = {{1500, 12}, {3500, 23}, {5700, 29}, {0, 30}};
        int income3 = 6400;
        System.out.println(Solution(taxes3, income3));


    }

    public static int Solution(int[][] taxes, int income) {

        int n = taxes.length;
        int res=0;

        res = (int)((float)taxes[0][0] * (float)taxes[0][1] * 0.01);

        int i=1;
        for ( ; i< n; i++) {
            if (income <= taxes[i][0] || taxes[i][0] == 0) {
                res += (int)((float)(income - taxes[i-1][0]) * ((float)taxes[i][1] * 0.01));
                break;
            } else {
                res += (int)((float)(taxes[i][0] - taxes[i-1][0]) * ((float)taxes[i][1] * 0.01));
            }
        }

        return res;
    }
}
