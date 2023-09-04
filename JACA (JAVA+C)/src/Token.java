package src;
public class Token {
    public enum TokenType {
        //Var Types
        INTEGER,//Added to Lexer
        FLOAT,
        STRING, // Added to Lexer
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
        TRY,
        

        //Operators
        PLUS, //Added to Lexer
        MINUS, //Added to Lexer
        MULTIPLY, //Added to Lexer
        DIVIDE, //Added to Lexer
        LPARENTH, //Added to Lexer
        RPARENTH, //Added to Lexer

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
        SEMICOLON, //Added to Lexer               End of Line
        EOF, // End of File
        LBRACKET, //Added to Lexer
        RBRACKET, //Added to Lexer
        LCBRACKET, //Added to Lexer
        RCBRACKET, //Added to Lexer
        OR, //Added to Lexer
        AND, //Added to Lexer
        //SPECIAL
        CLASS
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
