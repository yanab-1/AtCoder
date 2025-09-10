
import java.util.Scanner;

public class Frog_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        if(n == 1){
            System.out.println(0);
        }
        int[] dp = new int[n];
        // Tabulation
        dp[0] = 0;
        dp[1] = Math.abs(arr[0] - arr[1]);
        for(int i = 2; i < n; i++){
            int one = dp[i - 1] + Math.abs(arr[i] - arr[i - 1]);
            int two = dp[i - 2] + Math.abs(arr[i] - arr[i - 2]);
            dp[i] = Math.min(one, two);
        }
        System.out.println(dp[n - 1]);
        // System.out.println(cost(arr, n - 1, dp));
    }
    // Memoization
    private static long cost(long[] arr, int i, long[] dp){
        if(i <= 0){
            return 0; 
        }
        if(dp[i] != 0){
            return dp[i];
        }
        long one = cost(arr, i - 1, dp) + Math.abs(arr[i] - arr[i - 1]);
        long two = Integer.MAX_VALUE;
        if(i > 1){
            two = cost(arr, i - 2, dp) + Math.abs(arr[i] - arr[i - 2]);
        }
        return dp[i] = Math.min(one, two);
    }
}
