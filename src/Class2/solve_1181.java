package Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class solve_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] n = new String[N];

        for (int i = 0; i < N; i++) {
            n[i]  = br.readLine();
        }
        List<String> list = new ArrayList<>(Arrays.asList(n));

        Collections.sort(list, (a,b) -> {
            if (a.length() != b.length()) {
                return Integer.compare(a.length(), b.length());
            }
            return a.compareTo(b);
        });

        Set<String> words = new LinkedHashSet<>(list);
        for (String word : words) {
            System.out.println(word);
        }

    }
}
