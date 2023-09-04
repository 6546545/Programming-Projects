package src;

import src.Token.TokenType;

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
    public String parseText(){
        String result = parseStringTerm();

        //Keywords
        while (currentToken.type == TokenType.IF || currentToken.type == TokenType.ELSE
                || currentToken.type == TokenType.WHILE || currentToken.type == TokenType.RETURN
                || currentToken.type == TokenType.FOR || currentToken.type == TokenType.ELIF
                || currentToken.type == TokenType.MEM || currentToken.type == TokenType.SWITCH
                || currentToken.type == TokenType.CASE || currentToken.type == TokenType.BREAK
                || currentToken.type == TokenType.SEMICOLON || currentToken.type == TokenType.EOF
                || currentToken.type == TokenType.LBRACKET || currentToken.type == TokenType.RBRACKET
                || currentToken.type == TokenType.LCBRACKET || currentToken.type == TokenType.RCBRACKET
                || currentToken.type == TokenType.OR || currentToken.type == TokenType.AND
                || currentToken.type == TokenType.CLASS || currentToken.type == TokenType.INTEGER
                || currentToken.type == TokenType.FLOAT || currentToken.type == TokenType.STRING
                || currentToken.type == TokenType.BOOL || currentToken.type == TokenType.OBJECT
                || currentToken.type == TokenType.ARRAY || currentToken.type == TokenType.BINTREE
                || currentToken.type == TokenType.DICT || currentToken.type == TokenType.HASHMAP
                || currentToken.type == TokenType.CHAR || currentToken.type == TokenType.LONG
                || currentToken.type == TokenType.VOID || currentToken.type == TokenType.DOUBLE
                || currentToken.type == TokenType.ENUM || currentToken.type == TokenType.BYTE
                || currentToken.type == TokenType.STATIC || currentToken.type == TokenType.VOLITILE
                || currentToken.type == TokenType.KEYWORD || currentToken.type == TokenType.AUTO
                || currentToken.type == TokenType.ABSTRACT || currentToken.type == TokenType.THROW
                || currentToken.type == TokenType.CATCH || currentToken.type == TokenType.DO) {
            Token opToken = currentToken;


            //@TODO: Implement the logic after each eat statement
            if (opToken.type == TokenType.IF) {
                eat(Token.TokenType.IF);
                //@TODO: Implement the logic 
            }else if (opToken.type == TokenType.ELSE) {
                eat(Token.TokenType.ELSE);
            }
        }
    }

    private int parseIntTerm() {
        int result = Integer.parseInt(currentToken.value);
        eat(Token.TokenType.INTEGER);
        return result;
    }
    private String parseStringTerm(){
        //@TODO: Parse String Terms
        //@TODO: Add all Text-based Token Types: Keywords, Program Flow etc.
        return "null";
    }


    public static void main(String[] args) {
        String input = "3-2+8/3*45*2";
        Lexer lexer = new Lexer(input);
        Parser parser = new Parser(lexer);

        int result = parser.parseInt();
        System.out.println("Result: " + result);
    }
}
