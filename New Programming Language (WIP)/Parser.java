
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

    public int parse() {
        int result = parseTerm();
        while (currentToken.type == Token.TokenType.PLUS || currentToken.type == Token.TokenType.MINUS) {
            Token opToken = currentToken;
            if (opToken.type == Token.TokenType.PLUS) {
                eat(Token.TokenType.PLUS);
                result += parseTerm();
            } else if (opToken.type == Token.TokenType.MINUS) {
                eat(Token.TokenType.MINUS);
                result -= parseTerm();
            }else if (opToken.type == Token.TokenType.DIVIDE){
                eat(Token.TokenType.DIVIDE);
                result /= parseTerm();
            }else if (opToken.type == Token.TokenType.MULTIPLY){
                eat(Token.TokenType.MULTIPLY);
                result *= parseTerm();
            }
        }
        return result;
    }

    private int parseTerm() {
        int result = Integer.parseInt(currentToken.value);
        eat(Token.TokenType.INTEGER);
        return result;
    }

    public static void main(String[] args) {
        String input = "3+5-2";
        Lexer lexer = new Lexer(input);
        Parser parser = new Parser(lexer);

        int result = parser.parse();
        System.out.println("Result: " + result);
    }
}
