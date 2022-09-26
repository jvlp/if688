package RPNStacker;

import java.util.Scanner;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import RPNStacker.Lexer.Token;
import RPNStacker.Lexer.TokenType;


public class RPNStackerClass {

    private static Scanner scanner = new Scanner(System.in);
    private static Stack<Token> buffer = new Stack<>();

    public static void main(String[] args) throws IOException {
        String filename = scanner.next();
        String input = "";
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            while (true) {

                input = br.readLine();
                Token newToken = GenerateToken(input);
                buffer.push(newToken);
                if(newToken.type == TokenType.EOF){
                    break;
                }
                System.out.println("> " + input);
                
                if (isOperation(newToken)) {
                    int current = parseOperation(buffer);
                    System.out.println(">> " + current);
                    buffer.push(new Token(TokenType.NUM, current));
                }
            }
            
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public static int parseOperation(Stack<Token> buffer) {
        String operation = buffer.pop().lexeme;
        int right = (buffer.empty()) ? 0 : Integer.parseInt(buffer.pop().lexeme);

        if (buffer.empty()) 
            return right;

        int left = Integer.parseInt(buffer.pop().lexeme);
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

    public static boolean isOperation(Token T) {
        if (T == null) return false;
        return T.type == TokenType.PLUS || T.type == TokenType.MINUS || T.type == TokenType.STAR || T.type == TokenType.SLASH;
    }

    public static Token GenerateToken(String input) {
        if (input == null) return new Token(TokenType.EOF, input);
        switch (input) {
            case "+": return new Token(TokenType.PLUS, input);
            case "-": return new Token(TokenType.MINUS, input);
            case "*": return new Token(TokenType.STAR, input);
            case "/": return new Token(TokenType.SLASH, input);
            case "q": return new Token(TokenType.EOF, input);
            default: 
                try {
                    Integer aux = Integer.parseInt(input);
                    return new Token(TokenType.NUM, aux);
                } catch (Exception e) {
                    System.out.println("Error: Unexpected character: " + input);
                    return new Token(TokenType.ERROR, input);
                }
        }
    }
}