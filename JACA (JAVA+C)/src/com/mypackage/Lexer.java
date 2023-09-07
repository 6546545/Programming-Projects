package src.com.mypackage;


import java.util.ArrayList;
import java.util.List;

//import src.Token.TokenType;

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

import src.Token;
import src.Token.TokenType;

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
            String KEYWORDS[] = {"int", "fl", "Str", "bool","Obj", "arr", "dict", "Hashmap", "char", "long", "void", "dbl", "enum", "byte", "static",
                "vol", "keyword", "auto", "abs", "throw", "catch", "do", "try", "class", "if", "else", "while", "return", "for", 
                 "elif", "mem", "switch", "case", "break", "public", "private", "final", "print",","};
            List<Token> tokens = new ArrayList<>();

        while (position < input.length()) {
            char currentChar = input.charAt(position);

            if (Character.isDigit(currentChar)) {
                StringBuilder number = new StringBuilder();
                while (position < input.length() && Character.isDigit(input.charAt(position))) {
                    number.append(input.charAt(position));
                    position++;
                }
                tokens.add(new Token(TokenType.INTEGER, number.toString()));
            } else if (currentChar == '+') {
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
                //If Keyword, create new keyword token.
                if (isKeyword) {
                    if (letter.toString().contains("int")) {
                        tokens.add(new Token(TokenType.INTEGER, "int"));
                        System.out.println("int");
                        
                    } else if (letter.toString().contains("fl")) {
                        tokens.add(new Token(TokenType.FLOAT, "fl"));
                    }
                        
                    
                }else{
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

        return tokens;
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


//====================================================================================================================
//TODO: Provide rules for special characters like  ',' OR '_' OR '^' etc.
    public static void main(String[] args) {
        String input = "print fl"; // 3 + 42 - 17 / 3 * 4
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
