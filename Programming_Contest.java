import java.util.*;

public class Programming_Contest {

    static void subset(int[] b, int i, long cur, ArrayList<Long> res) {
        if (i == b.length) {
            res.add(cur);
            return;
        }
        subset(b, i + 1, cur + b[i], res);
        subset(b, i + 1, cur, res);
    }

    static int upperBound(ArrayList<Long> v, long tar) {
        int low = 0, high = v.size() - 1;
        int ans = v.size();
        while (low <= high) {
            int mid = (low + high) / 2;
            if (v.get(mid) > tar) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long T = sc.nextLong();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] a = Arrays.copyOfRange(arr, 0, n / 2);
        int[] b = Arrays.copyOfRange(arr, n / 2, n);

        ArrayList<Long> s1 = new ArrayList<>();
        ArrayList<Long> s2 = new ArrayList<>();

        subset(a, 0, 0L, s1);
        subset(b, 0, 0L, s2);

        Collections.sort(s2);

        long ans = 0;
        for (long v : s1) {
            long tar = T - v;
            if (tar < 0) continue;

            int idx = upperBound(s2, tar) - 1;
            if (idx >= 0) {
                ans = Math.max(ans, v + s2.get(idx));
            }
        }

        System.out.println(ans);
    }
}
