package src;

public class Lexer {
    private String input;
    private int position = 0;

    public Lexer(String input) {
        this.input = input;
    }

    public Token nextToken() {
        if (position >= input.length()) {
            return new Token(Token.TokenType.EOF, "");
        }

        char currentChar = input.charAt(position);

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

    private Token readInteger() {
        StringBuilder sb = new StringBuilder();
        while (position < input.length() && Character.isDigit(input.charAt(position))) {
            sb.append(input.charAt(position));
            position++;
        }
        return new Token(Token.TokenType.INTEGER, sb.toString());
    }
    private Token readAlpha(){
        StringBuilder sb = new StringBuilder();
        while(position < input.length() && Character.isAlphabetic(input.charAt(position))){
            sb.append(input.charAt(position));
            position++;
        }
        return new Token(Token.TokenType.STRING, sb.toString());
    }
}
