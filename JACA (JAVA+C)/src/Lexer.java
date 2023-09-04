package src;
/*
 * @6546545
 * 
 * This Lexer class performs lexical analysis of input source code
 *          and breaks it down into tokens.
 *          -Takes in source code as an input
 *          -Tracks the position of the current character in the file
 * 
 * 
 */
public class Lexer {
    
    //Private Variables
    private String input;
    private int position = 0;

    /*Constructor
     * @param String
     */
    public Lexer(String input) {
        this.input = input;
    }

    /* Next Token 
     *  Returns the next Token 
     * 
     * 
     * @return Token
     * @throws IllegalArgumentException
     */
    public Token nextToken() {

        //End of File
        if (position >= input.length()) {
            return new Token(Token.TokenType.EOF, "");
        }

        //Set currentChar
        char currentChar = input.charAt(position);

        //Creates new Token if char mataches Token
        if (Character.isDigit(currentChar)) {
            return readInteger();
        } else if(Character.isAlphabetic(currentChar)){
            return readAlpha();
        } else if (currentChar == '+') {
            position++;
            return new Token(Token.TokenType.PLUS, "+");
        } else if (currentChar == '-') {
            position++;
            return new Token(Token.TokenType.MINUS, "-");
        } else if (currentChar == '/'){
            position++;
            return new Token(Token.TokenType.DIVIDE, "/");
        } else if (currentChar == '*'){
            position++;
            return new Token(Token.TokenType.MULTIPLY, "*");
        }else if (currentChar == '('){
            position++;
            return new Token(Token.TokenType.RPARENTH, "(");
        }else if (currentChar == ')'){
            position++;
            return new Token(Token.TokenType.LPARENTH, ")");
        }else if (currentChar == ';') {
            position++;
            return new Token(Token.TokenType.SEMICOLON, ";");
        }else if (currentChar == '['){
            position++;
            return new Token(Token.TokenType.LBRACKET, "[");
        }else if (currentChar == ']'){
            position++;
            return new Token(Token.TokenType.RBRACKET, "]");
        }else if (currentChar == '{'){
            position++;
            return new Token(Token.TokenType.LCBRACKET, "{");
        }else if (currentChar == '}'){
            position++;
            return new Token(Token.TokenType.RCBRACKET, "}");
        }else if (currentChar == '|'){
            position++;
            return new Token(Token.TokenType.OR, "|");
        }else if (currentChar == '&'){
            position++;
            return new Token(Token.TokenType.AND, "&");
        }

        throw new IllegalArgumentException("Invalid character: " + currentChar);
    }

    /* Read Integer
     *  Translates the Int into appropriate Token, then returns new Token to nextToken()
     * 
     * @return Token
     */
    private Token readInteger() {
        StringBuilder sb = new StringBuilder();
        while (position < input.length() && Character.isDigit(input.charAt(position))) {
            sb.append(input.charAt(position));
            position++;
        }
        return new Token(Token.TokenType.INTEGER, sb.toString());
    }

     /* Read Alphas
     *  Translates the alphas into appropriate Token, then returns new Token to nextToken()
     * 
     * @return Token
     */
    private Token readAlpha(){
        StringBuilder sb = new StringBuilder();
        while(position < input.length() && Character.isAlphabetic(input.charAt(position))){
            sb.append(input.charAt(position));
            position++;
        }
        return new Token(Token.TokenType.STRING, sb.toString());
    }
}
