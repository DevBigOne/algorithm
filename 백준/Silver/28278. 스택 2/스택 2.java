import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());

            switch (cmd) {
                case 1: { // 1 X : push X
                    int x = Integer.parseInt(st.nextToken());
                    stack.push(x);
                    break;
                }
                case 2: { // 2 : pop (비었으면 -1)
                    if (stack.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(stack.pop());
                    }
                    break;
                }
                case 3: { // 3 : size
                    System.out.println(stack.size());
                    break;
                }
                case 4: { // 4 : empty (비었으면 1, 아니면 0)
                    if (stack.isEmpty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                }
                case 5: { // 5 : top (비었으면 -1)
                    if (stack.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(stack.peek());
                    }
                    break;
                }
            }
        }
    }
}
