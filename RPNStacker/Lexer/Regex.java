package rpnstacker.lexer;

import java.util.regex.Pattern;

public class Regex {
	
	public static boolean isNum(String token) {
		Pattern pattern = Pattern.compile("-?\\d+$", Pattern.CASE_INSENSITIVE);
		return pattern.matcher(token).matches();
	}
	
	public static boolean isOperation(String token) {
		Pattern pattern = Pattern.compile("[+-/\\*]$", Pattern.CASE_INSENSITIVE);
		return pattern.matcher(token).matches();
	}

	public static TokenType getOP(String token){
		Pattern patternPlus = Pattern.compile("[+]$", Pattern.CASE_INSENSITIVE);
		System.out.println(patternPlus.matcher(token).matches());
		if (patternPlus.matcher(token).matches())
			return TokenType.PLUS;
			
		Pattern patternMinus = Pattern.compile("[-]$", Pattern.CASE_INSENSITIVE);
		if (patternMinus.matcher(token).matches())
			return TokenType.MINUS;
		
		Pattern patternStar = Pattern.compile("[\\*]$", Pattern.CASE_INSENSITIVE);
		if (patternStar.matcher(token).matches())
			return TokenType.STAR;
		
		Pattern patternSlash = Pattern.compile("[/]$", Pattern.CASE_INSENSITIVE);
		if (patternSlash.matcher(token).matches())
			return TokenType.SLASH;
		
		return null;
	}
}
