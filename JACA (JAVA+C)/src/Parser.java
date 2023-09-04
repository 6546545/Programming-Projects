package src;

public class Parser {
    private final Lexer lexer;
    private Token currentToken;

    public Parser(Lexer lexer) {
        this.lexer = lexer;
        this.currentToken = lexer.nextToken();
    }

    private void eat(Token.TokenType expectedType) {
        if (currentToken.type == expectedType) {
            currentToken = lexer.nextToken();
        } else {
            throw new IllegalArgumentException("Expected " + expectedType + ", but found " + currentToken.type);
        }
    }

    public int parseInt() {
        int result = parseIntTerm();
        while (currentToken.type == Token.TokenType.PLUS || currentToken.type == Token.TokenType.MINUS 
        || currentToken.type == Token.TokenType.DIVIDE || currentToken.type == Token.TokenType.MULTIPLY
        || currentToken.type == Token.TokenType.RPARENTH || currentToken.type == Token.TokenType.LPARENTH) {
            Token opToken = currentToken;
            if (opToken.type == Token.TokenType.PLUS) {
                eat(Token.TokenType.PLUS);
                result += parseIntTerm();
            } else if (opToken.type == Token.TokenType.MINUS) {
                eat(Token.TokenType.MINUS);
                result -= parseIntTerm();
            }else if (opToken.type == Token.TokenType.DIVIDE){
                eat(Token.TokenType.DIVIDE);
                result /= parseIntTerm();
            }else if (opToken.type == Token.TokenType.MULTIPLY){
                eat(Token.TokenType.MULTIPLY);
                result *= parseIntTerm();
            }else if (opToken.type == Token.TokenType.RPARENTH){
                eat(Token.TokenType.RPARENTH);
                //@TODO: ODER OF OPERATIONS
            }else if (opToken.type == Token.TokenType.LPARENTH){
                eat(Token.TokenType.LPARENTH);
                //@TODO: ORDER OF OPERATIONS
            }
        }
        return result;
    }

    private int parseIntTerm() {
        int result = Integer.parseInt(currentToken.value);
        eat(Token.TokenType.INTEGER);
        return result;
    }


    public static void main(String[] args) {
        String input = "3-2+8/3*45*2";
        Lexer lexer = new Lexer(input);
        Parser parser = new Parser(lexer);

        int result = parser.parseInt();
        System.out.println("Result: " + result);
    }
}
