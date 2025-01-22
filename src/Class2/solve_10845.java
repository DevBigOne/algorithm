package Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solve_10845 {
    private int front;
    private int back;
    private int[] q;

    public solve_10845(int capacity) {
        front = back = 0;
        q = new int[capacity];
    }

    public int qisEmpty() {
        if (front == back) {
            return 1;
        }
        return 0;
    }

    public int size() {
        return back - front;
    }

    public void push(int val) {
        q[back++] = val;
    }

    public int pop() {
        if (qisEmpty() == 1) {
            return -1;
        }
        return q[front++];
    }

    public int front() {
        if (qisEmpty() == 1) {
            return -1;
        }
        return q[front];
    }

    public int back() {
        if (qisEmpty() == 1) {
            return -1;
        }
        return q[back - 1];
    }

    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        solve_10845 qu = new solve_10845(N);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            switch (s) {
                case "push":
                    int val = Integer.parseInt(st.nextToken());
                    qu.push(val);
                    break;

                case "pop":
                    System.out.println(qu.pop());
                    break;

                case "empty":
                    System.out.println(qu.qisEmpty());
                    break;

                case "size":
                    System.out.println(qu.size());
                    break;

                case "front":
                    System.out.println(qu.front());
                    break;

                case "back":
                    System.out.println(qu.back());
                    break;
            }
        }
    }
}
