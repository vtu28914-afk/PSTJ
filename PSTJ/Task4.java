import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task4 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String text = reader.readLine();
        String pattern = reader.readLine();

        if (text == null || pattern == null || text.isEmpty() || pattern.isEmpty()) {
            return;
        }

        kmpSearch(text, pattern);
    }

    private static void kmpSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int[] lps = computeLPSArray(pattern, m);

        StringBuilder result = new StringBuilder();
        int i = 0; 
        int j = 0;
        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            if (j == m) {
                result.append(i - j).append(" ");
                j = lps[j - 1]; 
            } else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        System.out.println(result.toString().trim());
    }

    private static int[] computeLPSArray(String pattern, int m) {
        int[] lps = new int[m];
        int len = 0; 
        int i = 1;

        lps[0] = 0; 
        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}