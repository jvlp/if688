package rpnstacker;

import java.util.Scanner;
import java.util.Stack;

import rpnstacker.lexer.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RPNStacker {

    private static Scanner scanner = new Scanner(System.in);
    private static Stack<Token> buffer = new Stack<>();

    public static void main(String[] args) throws IOException, UnexpectedCharacter {
        String filename = scanner.next();
        String input = "";
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            while (true) {
                input = br.readLine();
                Token newToken = new Token(input);
                buffer.push(newToken);
                System.out.println(newToken);
                if (newToken.type == TokenType.EOF) {
                    break;
                }
                System.out.println("> " + input);

                if (Regex.isOperation(newToken.lexeme)) {
                    int current = parseOperation(buffer);
                    newToken = new Token(TokenType.NUM, current);
                    System.out.println(newToken);
                    System.out.println(">> " + current);
                    buffer.push(newToken);
                }
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public static int parseOperation(Stack<Token> buffer) {
        TokenType operation = buffer.pop().type;
        int right = (buffer.empty()) ? 0 : Integer.parseInt(buffer.pop().lexeme);

        if (buffer.empty())
            return right;

        int left = Integer.parseInt(buffer.pop().lexeme);
        switch (operation) {
            case PLUS:
                return left + right;
            case MINUS:
                return left - right;
            case STAR:
                return left * right;
            case SLASH: {
                if (right == 0) {
                    return left;
                }
                return left / right;
            }
            default:
                return left;
        }
    }
}