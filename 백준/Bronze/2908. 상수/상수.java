import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String[] input = br.readLine().split(" ");
        String num1 = new StringBuilder(input[0]).reverse().toString();
        String num2 = new StringBuilder(input[1]).reverse().toString();

        int a = Integer.parseInt(num1);
        int b = Integer.parseInt(num2);

        System.out.println(Math.max(a, b));
    }
}