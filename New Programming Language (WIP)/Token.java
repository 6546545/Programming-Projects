public class Token {
    public enum TokenType {
        //Var Types
        INTEGER,
        FLOAT,
        STRING,
        BOOL,
        OBJECT,
        ARRAY,
        BINTREE,
        DICT,
        HASHMAP,
        CHAR,
        LONG,
        VOID,
        DOUBLE,
        ENUM,
        BYTE,
        STATIC,
        VOLITILE,
        KEYWORD, //Potential for new Keywords to be added?
        AUTO,
        ABSTRACT,
        THROW,
        CATCH,
        DO,


        //Operators
        PLUS,
        MINUS,
        MULTIPLY,
        DIVIDE,
        LPARENTH,
        RPARENTH,
        DECIMAL, // Token ' . ' in 1.45

        //Program Flow
        IF,
        ELSE,
        WHILE,
        RETURN,
        FOR,
        ELIF,
        MEM, //Memory Management
        SWITCH,
        CASE,
        BREAK,
        DOT, // Token ' . ' in Tonken.TokenType.DOT

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
