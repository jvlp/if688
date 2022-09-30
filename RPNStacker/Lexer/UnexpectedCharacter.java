package rpnstacker.lexer;
public class UnexpectedCharacter extends Exception { 
    public UnexpectedCharacter(String message){
        super(message);
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}