package src;


/*
 * @6546545
 * 
 * The Token class is represents the tokens produced from
 *         the operation of the Lexer class.
 *          -Represents Integers, Operators, and End of File
 * 
 * 
 * 
 * 
 */
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
        SQUARED,
        MODULUS,

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
        NOT,
        GREATERTHAN,
        LESSTHAN,
        GREATER_THAN_OR_EQUAL_TO,
        LESS_THAN_OR_EQUAL_TO,
        
        //SPECIAL
        CLASS,
        PUBLIC,
        PRIVATE,
        FINAL,
        PRINT,
        GENERIC,
        //NEED TO ADD
        ASSERT,
        CONST,
        CONTINUE,
        SUPER,
        SYNCHONIZED,
        EXTENDS,
        INSTANCEOF,
        NEW,
        PACKAGE,
        INTERFACE,
        THROWS,
        TRANSIENT,
        SHORT,
        NATIVE,
        IMPORT,
        PROTECTED,
        DEFAULT,
        STRICTFP,
        THIS,
        EXTERN,
        GOTO,
        REGISTER,
        SIGNED,
        SIZEOF,
        STRUCT,
        TYPEDEF,
        UNION,
        UNSIGNED,
        
    }

    public TokenType type;
    public String value;
    
    /*
     * @param TokenType, String
     */
    public Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
        
    }

    /*
     * @return the String type and value
     */
    @Override
    public String toString() {
        return "(" + type + ", " + value + ")";
    }


    
}
