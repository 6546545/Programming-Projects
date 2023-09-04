package src;

import src.Token.TokenType;

/*
 *@6546545
 * 
 *  This Parser class performs syntactic analysis of the tokens produced
 *          by the Lexer class to understand the meaning behind the code.
 *          -Initializes with a Lexer instance and the currentToken variable
 * 
 * 
 * 
 */
public class Parser {
    //Private Vars
    private final Lexer lexer;
    private Token currentToken;

    /* Constructor
     * 
     * @param Lexer
     */
    public Parser(Lexer lexer) {
        this.lexer = lexer;
        this.currentToken = lexer.nextToken();
    }

    /* Eat
     *  Consumes the cuurent Token and advances to next one
     * 
     * @param Token.TokenType
     * @throws IllegalArgumentException
     */
    private void eat(Token.TokenType expectedType) {
        if (currentToken.type == expectedType) {
            currentToken = lexer.nextToken();
        } else {
            throw new IllegalArgumentException("Expected " + expectedType + ", but found " + currentToken.type);
        }
    }

    /* Parse Int
     *  Parses logic based on algebraic expressions.
     *  -Subtraction
     *  -Addition
     *  -Multiplication
     *  -Division
     * 
     * @return int results
     */
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

    /* Parse Text
     *  Parses semantic and synactical expressions using keywords.
     * 
     * @returns String results
     */
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
            }else if (opToken.type == TokenType.WHILE) {
                eat(Token.TokenType.WHILE);
            }else if (opToken.type == TokenType.RETURN) {
                eat(Token.TokenType.RETURN);
            }else if (opToken.type == TokenType.FOR) {
                eat(Token.TokenType.FOR);
            }else if (opToken.type == TokenType.ELIF) {
                eat(Token.TokenType.ELIF);
            }else if (opToken.type == TokenType.MEM) {
                eat(Token.TokenType.MEM);
            }else if (opToken.type == TokenType.SWITCH) {
                eat(Token.TokenType.SWITCH);
            }else if (opToken.type == TokenType.CASE) {
                eat(Token.TokenType.CASE);
            }else if (opToken.type == TokenType.BREAK) {
                eat(Token.TokenType.BREAK);
            }else if (opToken.type == TokenType.SEMICOLON) {
                eat(Token.TokenType.SEMICOLON);
            }else if (opToken.type == TokenType.EOF) {
                eat(Token.TokenType.EOF);
            }else if (opToken.type == TokenType.LBRACKET) {
                eat(Token.TokenType.RBRACKET);
            }else if (opToken.type == TokenType.LCBRACKET) {
                eat(Token.TokenType.LCBRACKET);
            }else if (opToken.type == TokenType.RCBRACKET) {
                eat(Token.TokenType.RCBRACKET);
            }else if (opToken.type == TokenType.OR) {
                eat(Token.TokenType.OR);
            }else if (opToken.type == TokenType.AND) {
                eat(Token.TokenType.AND);
            }else if (opToken.type == TokenType.CLASS) {
                eat(Token.TokenType.CLASS);
            }else if (opToken.type == TokenType.INTEGER) {
                eat(Token.TokenType.INTEGER);
            }else if (opToken.type == TokenType.FLOAT) {
                eat(Token.TokenType.FLOAT);
            }else if (opToken.type == TokenType.STRING) {
                eat(Token.TokenType.STRING);
            }else if (opToken.type == TokenType.BOOL) {
                eat(Token.TokenType.BOOL);
            }else if (opToken.type == TokenType.OBJECT) {
                eat(Token.TokenType.OBJECT);
            }else if (opToken.type == TokenType.ARRAY) {
                eat(Token.TokenType.ARRAY);
            }else if (opToken.type == TokenType.BINTREE) {
                eat(Token.TokenType.BINTREE);
            }else if (opToken.type == TokenType.DICT) {
                eat(Token.TokenType.DICT);
            }else if (opToken.type == TokenType.HASHMAP) {
                eat(Token.TokenType.HASHMAP);
            }else if (opToken.type == TokenType.CHAR) {
                eat(Token.TokenType.CHAR);
            }else if (opToken.type == TokenType.LONG) {
                eat(Token.TokenType.LONG);
            }else if (opToken.type == TokenType.VOID) {
                eat(Token.TokenType.VOID);
            }else if (opToken.type == TokenType.DOUBLE) {
                eat(Token.TokenType.DOUBLE);
            }else if (opToken.type == TokenType.ENUM) {
                eat(Token.TokenType.ENUM);
            }else if (opToken.type == TokenType.BYTE) {
                eat(Token.TokenType.BYTE);
            }else if (opToken.type == TokenType.STATIC) {
                eat(Token.TokenType.STATIC);
            }else if (opToken.type == TokenType.VOLITILE) {
                eat(Token.TokenType.VOLITILE);
            }else if (opToken.type == TokenType.KEYWORD) {
                eat(Token.TokenType.KEYWORD);
            }else if (opToken.type == TokenType.AUTO) {
                eat(Token.TokenType.AUTO);
            }else if (opToken.type == TokenType.ABSTRACT) {
                eat(Token.TokenType.ABSTRACT);
            }else if (opToken.type == TokenType.THROW) {
                eat(Token.TokenType.THROW);
            }else if (opToken.type == TokenType.CATCH) {
                eat(Token.TokenType.CATCH);
            }else if (opToken.type == TokenType.DO) {
                eat(Token.TokenType.DO);
            }else if (opToken.type == TokenType.TRY) {
                eat(Token.TokenType.TRY);
            }
        }
        return result;
    }

    /* ParseIntTerm
     *  Parses integers.
     * 
     * @return int results
     */
    private int parseIntTerm() {
        int result = Integer.parseInt(currentToken.value);
        eat(Token.TokenType.INTEGER);
        return result;
    }

    /* Parse String Term
     *  Parses text.
     * 
     * @return String results
     */
    private String parseStringTerm(){
        //@TODO: Parse String Terms
        //@TODO: Add all Text-based Token Types: Keywords, Program Flow etc.
        return "null";
    }

//Temporary Main Method for debugging purposes
    public static void main(String[] args) {
        String input = "3-2+8/3*45*2";
        Lexer lexer = new Lexer(input);
        Parser parser = new Parser(lexer);

        int result = parser.parseInt();
        System.out.println("Result: " + result);
    }
}
