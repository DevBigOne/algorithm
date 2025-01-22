package Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solve_10828 {
    private int max;
    private int prx;
    private int[] stk;

    public solve_10828(int capacity) {
        prx = 0;
        max = capacity;
        stk = new int[max];

    }

    public void push(int x)  {
        stk[prx++] = x;
    }

    public int pop() {
        if (prx <= 0) {
            return -1;
        }
        return stk[--prx];
    }

    public int Empty() {
       if (prx == 0) {
           return 1;
       }
       return 0;
    }

    public int size() {
        return prx;
    }

    public int top() {
        if (prx <= 0) {
            return -1;
        }
        return stk[prx - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        solve_10828 stack = new solve_10828(N);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            switch (s) {
                case "push":
                    int val = Integer.parseInt(st.nextToken());
                    stack.push(val);
                    break;

                case "pop":
                    System.out.println(stack.pop());
                    break;

                case "empty":
                    System.out.println(stack.Empty());
                    break;

                case "size":
                    System.out.println(stack.size());
                    break;

                case "top":
                    System.out.println(stack.top());
                    break;
            }
        }
    }
}
