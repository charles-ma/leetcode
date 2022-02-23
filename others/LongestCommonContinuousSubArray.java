import java.util.*;

public class LongestCommonContinuousSubArray {
    public static void main(String... args) {
        String[] a1 = new String[]{"3234.html", "xys.html", "7hsaa.html"};
        String[] a2 = new String[]{"3234.html", "sdhsfjdsh.html", "xys.html", "7hsaa.html"};
        String[] result = new LongestCommonContinuousSubArray().solve(a1, a2);

        for (String s : result) {
            System.out.print(s + ",");
        }
        System.out.println();
    }

    public String[] solve(String[] a1, String[] a2) {
        int m = a1.length, n = a2.length;
        int[][] dp = new int[m + 1][n + 1];
        int index = -1;
        int max = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a1[i - 1].equals(a2[j - 1])) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > max) {
                        index = i - 1;
                        max = dp[i][j];
                    }
                }
            }
        }

        String[] result = new String[max];
        // System.out.println(max + "," + index);
        for (int i = index - max + 1; i <= index; i++) {
            result[i - index + max - 1] = a1[i];
        }

        return result;
    }
}
