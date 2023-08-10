public class Token {
    public enum TokenType {
        INTEGER,
        PLUS,
        MINUS,
        EOF // End of File
    }

    public TokenType type;
    public String value;

    public Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return "(" + type + ", " + value + ")";
    }
}
