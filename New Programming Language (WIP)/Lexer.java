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
}
