import java.util.Scanner;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RPNStacker {

    private static Scanner scanner = new Scanner(System.in);
    private static Stack<Integer> buffer = new Stack<>();

    public static void main(String[] args) throws IOException {
        String filename = scanner.next();
        String input = "";
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            while (true) {

                try {
                    input = br.readLine();
                    System.out.println(input);
                    if(input.equals("q")){
                        break;
                    };
                } catch (Exception e) {
                    System.out.println("erro readLine");
                }

                if (isOperation(input)) {
                    int current = parseOperation(input, buffer);
                    System.out.println(">> " + current);
                    buffer.push(current);
                } else {
                    buffer.push(Integer.parseInt(input));
                }
            }
            
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public static int parseOperation(String operation, Stack<Integer> buffer) {
        int right = (buffer.empty()) ? 0 : buffer.pop();

        if (buffer.empty()) 
            return right;

        int left = buffer.pop();
        switch (operation) {
            case "+": return left + right;
            case "-": return left - right;
            case "*": return left * right;
            case "/": {
                if (right == 0) {
                    return left;
                }
                return left / right;
            }
            default: return left;
        }
    }

    public static boolean isInteger(String input) {
        if (input == null) return false;

        try {
            Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }

    public static boolean isOperation(String input) {
        if (input == null) return false;
        return input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/");
    }
}