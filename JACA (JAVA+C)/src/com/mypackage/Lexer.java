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

package src.com.mypackage;
import src.Token;
import src.Token.TokenType;
import java.util.ArrayList;
import java.util.List;

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


    private List<Token> tokenize(){
        //Variables
        String KEYWORDS[] = {"int", "fl", "Str", "bool","Obj", "arr", "dict", "Hashmap", "char", "long", "void", "dbl", "enum", "byte", "static",
                "vol", "keyword", "auto", "abs", "throw", "catch", "do", "try", "class", "if", "else", "while", "return", "for", 
                 "elif", "mem", "switch", "case", "break", "public", "private", "final", "print",","};
        List<Token> tokens = new ArrayList<>();

        // Determines if the input is a number
        while (position < input.length()) {
            char currentChar = input.charAt(position);
            if (Character.isDigit(currentChar)) {
                StringBuilder number = new StringBuilder();
                while (position < input.length() && Character.isDigit(input.charAt(position))) {
                    number.append(input.charAt(position));
                    position++;
                }
                tokens.add(new Token(TokenType.INTEGER, number.toString()));
            } 
            
            //Create mathematical keywords
            else if (currentChar == '+') {
                tokens.add(new Token(TokenType.PLUS, "+"));
                position++;
            } else if (currentChar == '-') {
                tokens.add(new Token(TokenType.MINUS, "-"));
                position++;
            } else if (currentChar == '/') {
                tokens.add(new Token(TokenType.DIVIDE, "/"));
                position++;
            } else if (currentChar == '*') {
                tokens.add(new Token(TokenType.MULTIPLY, "*"));
                position++;
            } else if (currentChar == '&') {
                tokens.add(new Token(TokenType.AND, "&"));
                position++;
            }else if (currentChar == '|'){
                tokens.add(new Token(TokenType.OR, "|"));
                position++;
            }
           

            // Checks if input is a string
            else if (Character.isLetter(currentChar)) {
                StringBuilder letter = new StringBuilder();
                while (position < input.length() && Character.isLetter(input.charAt(position))) {
                    letter.append(input.charAt(position));
                    position++;
                }
                
                // isKeyword?
                boolean isKeyword = false;
                for (int i = 0; i < KEYWORDS.length; i++) {
                    if (KEYWORDS[i].matches(letter.toString())) {
                        isKeyword = true;
                    }
                }
                // If input is a keyword, create new keyword token.
                if (isKeyword) {

                    // Creates native variable tokens
                    if (letter.toString().contains("int") && !letter.toString().contains("print")) {
                        tokens.add(new Token(TokenType.INTEGER, "int")); // int
                    } else if (letter.toString().contains("fl")) {
                        tokens.add(new Token(TokenType.FLOAT, "fl")); //float
                    } else if (letter.toString().contains("Str")) {
                        tokens.add(new Token(TokenType.STRING, "Str")); //String
                    } else if (letter.toString().contains("bool")) {
                        tokens.add(new Token(TokenType.BOOL, "bool")); //bool
                    } else if (letter.toString().contains("Obj")) {
                        tokens.add(new Token(TokenType.OBJECT, "Obj")); //Object
                    } else if (letter.toString().contains("arr")) {
                        tokens.add(new Token(TokenType.ARRAY, "arr")); //Array
                    } else if (letter.toString().contains("dict")) {
                        tokens.add(new Token(TokenType.DICT, "dict")); //Dictionary
                    } else if (letter.toString().contains("Hashmap")) {
                        tokens.add(new Token(TokenType.HASHMAP, "Hashmap")); //Hashmap
                    } else if (letter.toString().contains("char")) {
                        tokens.add(new Token(TokenType.CHAR, "char")); //Char
                    } else if (letter.toString().contains("long")) {
                        tokens.add(new Token(TokenType.LONG, "long")); //Long
                    } else if (letter.toString().contains("dbl")) {
                        tokens.add(new Token(TokenType.DOUBLE, "dbl")); //Double
                    } else if (letter.toString().contains("byte")) {
                        tokens.add(new Token(TokenType.BYTE, "byte")); //Byte
                    }

                    // Creates special keyword tokens for Classes and Methods
                    else if (letter.toString().contains("void")) {
                        tokens.add(new Token(TokenType.VOID, "void")); //void                  
                    } else if (letter.toString().contains("enum")) {
                        tokens.add(new Token(TokenType.ENUM, "enum")); //enum
                    }else if (letter.toString().contains("static")) {
                        tokens.add(new Token(TokenType.STATIC, "static")); //static
                    } else if (letter.toString().contains("vol")) {
                        tokens.add(new Token(TokenType.VOLITILE, "vol")); //volitile
                    } else if (letter.toString().contains("keyword")) {
                        tokens.add(new Token(TokenType.KEYWORD, "keyword")); //keyword -> Possible addition to tokens list
                    } else if (letter.toString().contains("auto")) {
                        tokens.add(new Token(TokenType.AUTO, "auto")); //auto
                    } else if (letter.toString().contains("abs")) {
                        tokens.add(new Token(TokenType.ABSTRACT, "abs")); //abstract
                    } else if (letter.toString().contains("class")) {
                        tokens.add(new Token(TokenType.CLASS, "class")); //class
                    } else if (letter.toString().contains("mem")) {
                        tokens.add(new Token(TokenType.MEM, "mem")); //memory -> Memory management token
                    } else if (letter.toString().contains("public")) {
                        tokens.add(new Token(TokenType.PUBLIC, "public")); //public
                    } else if (letter.toString().contains("private")) {
                        tokens.add(new Token(TokenType.PRIVATE, "private")); //private
                    } else if (letter.toString().contains("final")) {
                        tokens.add(new Token(TokenType.FINAL, "final")); //final
                    } else if (letter.toString().contains("print")) {
                        tokens.add(new Token(TokenType.PRINT, "print")); //System.out.print Function
                    }
                    
                    // Creates error-related keyword tokens
                    else if (letter.toString().contains("throw")) {
                        tokens.add(new Token(TokenType.THROW, "throw")); //throw error
                    } else if (letter.toString().contains("catch")) {
                        tokens.add(new Token(TokenType.CATCH, "catch")); //catch error
                    } else if (letter.toString().contains("do")) {
                        tokens.add(new Token(TokenType.DO, "do")); //do
                    } else if (letter.toString().contains("try")) {
                        tokens.add(new Token(TokenType.TRY, "try")); //try
                    } 
                    
                    // Creates program flow keyword tokens
                     else if (letter.toString().contains("if")) {
                        tokens.add(new Token(TokenType.IF, "if")); //if
                    } else if (letter.toString().contains("else")) {
                        tokens.add(new Token(TokenType.ELSE, "else")); //else
                    } else if (letter.toString().contains("while")) {
                        tokens.add(new Token(TokenType.WHILE, "while")); //while
                    } else if (letter.toString().contains("return")) {
                        tokens.add(new Token(TokenType.RETURN, "return")); //return
                    } else if (letter.toString().contains("for")) {
                        tokens.add(new Token(TokenType.FOR, "for")); //for
                    } else if (letter.toString().contains("elif")) {
                        tokens.add(new Token(TokenType.ELIF, "elif")); //elif
                    } else if (letter.toString().contains("switch")) {
                        tokens.add(new Token(TokenType.SWITCH, "switch")); //switch
                    } else if (letter.toString().contains("case")) {
                        tokens.add(new Token(TokenType.CASE, "case")); //case
                    } else if (letter.toString().contains("break")) {
                        tokens.add(new Token(TokenType.BREAK, "break")); //break
                    }  
                }else{
                    // Handles Strings - Creates a string token when a non-keyword string is an input
                    tokens.add(new Token(TokenType.STRING, letter.toString()));
                }   
                
            }
            else if (currentChar == ' ') {
                // Skip whitespace
                position++;
            } else {
                // Handle unrecognized characters or tokens
                throw new RuntimeException("Invalid character: " + currentChar);
            }
        }
        // METHOD RETURN
        return tokens;
    }
//_____________________________________________________________________________________________________________
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
        }else if (currentChar == '^') {
            position++;
            return new Token(Token.TokenType.SQUARED, "^");
        } else if (currentChar == '%') {
            position++;
            return new Token(Token.TokenType.MODULUS, "%");
        } else if (currentChar == '!') {
            position++;
            return new Token(Token.TokenType.NOT, "!");
        } else if (currentChar == '<') {
            position++;
            return new Token(Token.TokenType.LESSTHAN, "<");
        } else if (currentChar == '>') {
            position++;
            return new Token(Token.TokenType.GREATERTHAN, ">");
        } else if (String.valueOf(currentChar) == "<=") {
            position++;
            return new Token(TokenType.LESS_THAN_OR_EQUAL_TO, "<=");
        } else if (String.valueOf(currentChar) == ">=") {
            position++;
            return new Token(TokenType.GREATER_THAN_OR_EQUAL_TO, ">=");
        }

        throw new IllegalArgumentException("Invalid character: " + currentChar);
    }
//___________________________________________________________________________________________________________________
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
//___________________________________________________________________________________________________________________
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


//====================================================================================================================
//TODO: Provide rules for special characters like  ',' OR '_' OR '^' etc.
    public static void main(String[] args) {
        String input = "print Hello"; // 3 + 42 - 17 / 3 * 4
        Lexer lexer = new Lexer(input);
        List<Token> tokens = lexer.tokenize();

        for (Token token : tokens) {
            System.out.println(token);
        }
    }




/* 


        String result = "";
        int length = this.input.length();
        int pos = 0;
        String tokens[] = new String[40];
        String KEYWORDS[] = {"int", "fl", "Str", "bool","Obj", "arr", "dict", "Hashmap", "char", "long", "void", "dbl", "enum", "byte", "static",
        "vol", "keyword", "auto", "abs", "throw", "catch", "do", "try", "class", "if", "else", "while", "return", "for", 
        "elif", "mem", "switch", "case", "break", "public", "private", "final", "print",","};
        
        String charsString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_";

        while (pos<length) {
            char current = this.input.charAt(pos); // i
            String firstChar = String.valueOf(current);////////////////////
            CharSequence charSequence = this.input; //"if"
            String currString = Character.toString(current); //currString ="if", current = i


            if (current == ' ' || current == '\n') {
                pos++;
                continue;
            }else if (current == '"') {
                
                pos++;

                while (current != '"' && current != '\n' && pos <length) {
                    result += current;
                    pos++;
                }
                if (current != '"') {
                    throw new Error("Variable is not a valid String.");
                }
                pos++;
                for(int i = 0; i<pos; i++){
                    for (int j = 0; j < pos; j++) {
                        String[] tmps= {"string",result};
                        tokens[pos] = tmps[pos];
                    }
                }

            
            }else if (charsString.contains(firstChar)) {
               
                String[] letArr = new String[length+1];
                letArr[0]= String.valueOf(currString);
                
                pos++;

                while (charsString.contains(currString) && pos < length) {
                    letArr[pos] = String.valueOf(this.input.charAt(pos)); ////////////////////////////////////
                    letArr[letArr.length-1] = ",";
                    result = String.join(",", letArr);
                    String tmp = result.replace(",", "");
                    result = tmp;
                    pos++;
                }
                for (int i = 0; i < length; i++) {
                    KEYWORDS[KEYWORDS.length- 1] = ",";
                    String tmp = String.join(",", KEYWORDS);
                    String tmp1 = tmp.replace(",", "");
                    if (!tmp1.contains(result)) {
                        throw new Error("Unexpected Token:" + result);
                    }
                }
                    String[] tmps= {"string",result};
                for (int i = 0; i < tmps.length; i++) {
                    tokens[i] = tmps[i];
                }
            } else {
                throw new Error("Unexpected Character at index: " + pos + ".");
            }
        }
        return tokens;*/
    


}
