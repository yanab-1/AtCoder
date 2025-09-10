import java.util.Scanner;

public class Frog_2 {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        if(n == 1){
            System.out.println(0);
        }
        int[] dp = new int[n];
        // Arrays.fill(dp, -1);
        // Tabulation
        dp[0] = 0;
        for(int i = 1; i < n; i++){
            int minSteps = Integer.MAX_VALUE;
            for(int j = 1; j <= k; j++){
                if(i - j >= 0){
                    int jump = dp[i - j] + Math.abs(arr[i] - arr[i - j]);
                    minSteps = Math.min(minSteps, jump);
                }
            }
            dp[i] = minSteps;
        }
        System.out.println(dp[n - 1]);
        // System.out.println(cost(arr, n - 1, dp, k));
    }
    // Memoization
    private static int cost(int[] arr, int i, int[] dp, int k){
        if(i <= 0){
            return 0; 
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int minSteps = Integer.MAX_VALUE;
        for(int j = 1; j <= k; j++){
            if(i - j >= 0){
                int jump = cost(arr, i - j, dp, k) + Math.abs(arr[i] - arr[i - j]);
                minSteps = Math.min(minSteps, jump);
            }
        }
        return dp[i] = minSteps;
    }
}
