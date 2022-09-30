/* *******************************************************************
 * Copyright (c) 2021 Universidade Federal de Pernambuco (UFPE).
 * 
 * This file is part of the Compilers course at UFPE.
 * 
 * During the 1970s and 1980s, Hewlett-Packard used RPN in all 
 * of their desktop and hand-held calculators, and continued to 
 * use it in some models into the 2020s. In computer science, 
 * reverse Polish notation is used in stack-oriented programming languages 
 * such as Forth, STOIC, PostScript, RPL and Joy.
 *  
 * Contributors: 
 *     Henrique Rebelo      initial design and implementation 
 *     http://www.cin.ufpe.br/~hemr/
 * ******************************************************************/

package rpnstacker.lexer;

/**
 * @author Henrique Rebelo
 */
public class Token {

	public final TokenType type; // token type
	public final String lexeme; // token value

	public Token (String value) throws UnexpectedCharacter {

		if (value == null){
			this.type = TokenType.EOF;
			this.lexeme = value;
			return;
		}

		if (Regex.isNum(value)){
			this.type = TokenType.NUM;
			this.lexeme = value;
			return;
		}

        switch (value) {
            case "+":
				this.type = TokenType.PLUS;
				this.lexeme = value;
				break;
            case "-":
				this.type = TokenType.MINUS;
				this.lexeme = value;
                break;
            case "*":
				this.type = TokenType.STAR;
				this.lexeme = value;
                break;
            case "/":
				this.type = TokenType.SLASH;
				this.lexeme = value;
                break;
            case "q":
				this.type = TokenType.EOF;
				this.lexeme = value;
                break;
            default:
				throw new UnexpectedCharacter(value);
        }
	}

	public Token (TokenType type, Integer value) {
		this.type = type;
		this.lexeme = String.valueOf(value);
	}

	@Override
	public String toString() {
		return "Token [type=" + this.type + ", lexeme=" + this.lexeme + "]";
	}
}