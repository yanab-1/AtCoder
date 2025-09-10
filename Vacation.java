import java.util.Scanner;

public class Vacation{
    // Tabulation(Space Optimized)
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][3];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 3; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int[] prev = new int[4];
        for(int bc = 0; bc < 4; bc++){
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < 3; i++){
                if(i != bc){
                    max = Math.max(max, arr[0][i]);
                }
            }
            prev[bc] = max;
        }
        for(int day = 1; day < n; day++){
            int[] curr = new int[4];
            for(int last = 0; last < 4; last++){
                int max = Integer.MIN_VALUE;
                for(int i = 0; i < 3; i++){
                    if(i != last){
                        max = Math.max(max, arr[day][i] + prev[i]);
                    }
                }
                curr[last] = max;
            }
            prev = curr;
        }
        // System.out.println(vacation(arr, n-1, 3, dp));
        System.out.println(prev[3]);
    }

    // Tabulation
    // public static void main(String[] args){
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     int[][] arr = new int[n][3];
    //     for(int i = 0; i < n; i++){
    //         for(int j = 0; j < 3; j++){
    //             arr[i][j] = sc.nextInt();
    //         }
    //     }
    //     int[][] dp = new int[n][4];
    //     for(int bc = 0; bc < 4; bc++){
    //         int max = Integer.MIN_VALUE;
    //         for(int i = 0; i < 3; i++){
    //             if(i != bc){
    //                 max = Math.max(max, arr[0][i]);
    //             }
    //         }
    //         dp[0][bc] = max;
    //     }
    //     for(int day = 1; day < n; day++){
    //         for(int last = 0; last < 4; last++){
    //             int max = Integer.MIN_VALUE;
    //             for(int i = 0; i < 3; i++){
    //                 if(i != last){
    //                     max = Math.max(max, arr[day][i] + dp[day - 1][i]);
    //                 }
    //             }
    //             dp[day][last] = max;
    //         }
    //     }
    //     System.out.println(vacation(arr, n-1, 3, dp));
    //     System.out.println(dp[n - 1][3]);
    // }
    
    // Memoization
    private static int vacation(int[][] arr, int day, int t, int[][] dp) {
        if(day == 0){
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < 3; i++){
                if(i != t){
                    max = Math.max(max, arr[day][i]);
                }
            }
            return max;
        }
        if(dp[day][t] != -1){
            return dp[day][t];
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < 3; i++){
            if(i != t){
                max = Math.max(max, arr[day][i] + vacation(arr, day - 1, i, dp));
            }
        }
        return dp[day][t] = max;
    }
    
}