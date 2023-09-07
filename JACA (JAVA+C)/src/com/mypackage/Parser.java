package src.com.mypackage;




import src.Token;


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
        while (currentToken.type == Token.TokenType.IF || currentToken.type == Token.TokenType.ELSE
                || currentToken.type == Token.TokenType.WHILE || currentToken.type == Token.TokenType.RETURN
                || currentToken.type == Token.TokenType.FOR || currentToken.type == Token.TokenType.ELIF
                || currentToken.type == Token.TokenType.MEM || currentToken.type == Token.TokenType.SWITCH
                || currentToken.type == Token.TokenType.CASE || currentToken.type == Token.TokenType.BREAK
                || currentToken.type == Token.TokenType.SEMICOLON || currentToken.type == Token.TokenType.EOF
                || currentToken.type == Token.TokenType.LBRACKET || currentToken.type == Token.TokenType.RBRACKET
                || currentToken.type == Token.TokenType.LCBRACKET || currentToken.type == Token.TokenType.RCBRACKET
                || currentToken.type == Token.TokenType.OR || currentToken.type == Token.TokenType.AND
                || currentToken.type == Token.TokenType.CLASS || currentToken.type == Token.TokenType.INTEGER
                || currentToken.type == Token.TokenType.FLOAT || currentToken.type == Token.TokenType.STRING
                || currentToken.type == Token.TokenType.BOOL || currentToken.type == Token.TokenType.OBJECT
                || currentToken.type == Token.TokenType.ARRAY || currentToken.type == Token.TokenType.BINTREE
                || currentToken.type == Token.TokenType.DICT || currentToken.type == Token.TokenType.HASHMAP
                || currentToken.type == Token.TokenType.CHAR || currentToken.type == Token.TokenType.LONG
                || currentToken.type == Token.TokenType.VOID || currentToken.type == Token.TokenType.DOUBLE
                || currentToken.type == Token.TokenType.ENUM || currentToken.type == Token.TokenType.BYTE
                || currentToken.type == Token.TokenType.STATIC || currentToken.type == Token.TokenType.VOLITILE
                || currentToken.type == Token.TokenType.KEYWORD || currentToken.type == Token.TokenType.AUTO
                || currentToken.type == Token.TokenType.ABSTRACT || currentToken.type == Token.TokenType.THROW
                || currentToken.type == Token.TokenType.CATCH || currentToken.type == Token.TokenType.DO) {
            Token opToken = currentToken;


            //@TODO: Implement the logic after each eat statement
            if (opToken.type == Token.TokenType.IF) {
                eat(Token.TokenType.IF);
                //@TODO: Implement the logic 
            }else if (opToken.type == Token.TokenType.ELSE) {
                eat(Token.TokenType.ELSE);
            }else if (opToken.type == Token.TokenType.WHILE) {
                eat(Token.TokenType.WHILE);
            }else if (opToken.type == Token.TokenType.RETURN) {
                eat(Token.TokenType.RETURN);
            }else if (opToken.type == Token.TokenType.FOR) {
                eat(Token.TokenType.FOR);
            }else if (opToken.type == Token.TokenType.ELIF) {
                eat(Token.TokenType.ELIF);
            }else if (opToken.type == Token.TokenType.MEM) {
                eat(Token.TokenType.MEM);
            }else if (opToken.type == Token.TokenType.SWITCH) {
                eat(Token.TokenType.SWITCH);
            }else if (opToken.type == Token.TokenType.CASE) {
                eat(Token.TokenType.CASE);
            }else if (opToken.type == Token.TokenType.BREAK) {
                eat(Token.TokenType.BREAK);
            }else if (opToken.type == Token.TokenType.SEMICOLON) {
                eat(Token.TokenType.SEMICOLON);
            }else if (opToken.type == Token.TokenType.EOF) {
                eat(Token.TokenType.EOF);
            }else if (opToken.type == Token.TokenType.LBRACKET) {
                eat(Token.TokenType.RBRACKET);
            }else if (opToken.type == Token.TokenType.LCBRACKET) {
                eat(Token.TokenType.LCBRACKET);
            }else if (opToken.type == Token.TokenType.RCBRACKET) {
                eat(Token.TokenType.RCBRACKET);
            }else if (opToken.type == Token.TokenType.OR) {
                eat(Token.TokenType.OR);
            }else if (opToken.type == Token.TokenType.AND) {
                eat(Token.TokenType.AND);
            }else if (opToken.type == Token.TokenType.CLASS) {
                eat(Token.TokenType.CLASS);
            }else if (opToken.type == Token.TokenType.INTEGER) {
                eat(Token.TokenType.INTEGER);
            }else if (opToken.type == Token.TokenType.FLOAT) {
                eat(Token.TokenType.FLOAT);
            }else if (opToken.type == Token.TokenType.STRING) {
                eat(Token.TokenType.STRING);
            }else if (opToken.type == Token.TokenType.BOOL) {
                eat(Token.TokenType.BOOL);
            }else if (opToken.type == Token.TokenType.OBJECT) {
                eat(Token.TokenType.OBJECT);
            }else if (opToken.type == Token.TokenType.ARRAY) {
                eat(Token.TokenType.ARRAY);
            }else if (opToken.type == Token.TokenType.BINTREE) {
                eat(Token.TokenType.BINTREE);
            }else if (opToken.type == Token.TokenType.DICT) {
                eat(Token.TokenType.DICT);
            }else if (opToken.type == Token.TokenType.HASHMAP) {
                eat(Token.TokenType.HASHMAP);
            }else if (opToken.type == Token.TokenType.CHAR) {
                eat(Token.TokenType.CHAR);
            }else if (opToken.type == Token.TokenType.LONG) {
                eat(Token.TokenType.LONG);
            }else if (opToken.type == Token.TokenType.VOID) {
                eat(Token.TokenType.VOID);
            }else if (opToken.type == Token.TokenType.DOUBLE) {
                eat(Token.TokenType.DOUBLE);
            }else if (opToken.type == Token.TokenType.ENUM) {
                eat(Token.TokenType.ENUM);
            }else if (opToken.type == Token.TokenType.BYTE) {
                eat(Token.TokenType.BYTE);
            }else if (opToken.type == Token.TokenType.STATIC) {
                eat(Token.TokenType.STATIC);
            }else if (opToken.type == Token.TokenType.VOLITILE) {
                eat(Token.TokenType.VOLITILE);
            }else if (opToken.type == Token.TokenType.KEYWORD) {
                eat(Token.TokenType.KEYWORD);
            }else if (opToken.type == Token.TokenType.AUTO) {
                eat(Token.TokenType.AUTO);
            }else if (opToken.type == Token.TokenType.ABSTRACT) {
                eat(Token.TokenType.ABSTRACT);
            }else if (opToken.type == Token.TokenType.THROW) {
                eat(Token.TokenType.THROW);
            }else if (opToken.type == Token.TokenType.CATCH) {
                eat(Token.TokenType.CATCH);
            }else if (opToken.type == Token.TokenType.DO) {
                eat(Token.TokenType.DO);
            }else if (opToken.type == Token.TokenType.TRY) {
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

        System.out.println(Token.TokenType.AND);
    }
}
