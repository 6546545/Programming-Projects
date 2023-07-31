import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer{
    private List<String> tokens;
    private String src;
    private int currInd;

    public Lexer(){
        this.tokens = new ArrayList<>();
        this.src = null;
        this.currInd = 0;
    }

    public List<String> getTokens(){
        return tokens;
    }
    public void tokenize(String srcString){
        this.src = srcString;
        this.currInd = 0;
        this.tokens.clear();

        while(currInd < src.length()){
            if(isWhitespace()){
                jumpWhitespace();
            }else if (isOp()) {
                tokenizeOP();
            }else if (isParenthesis()) {
                tokenizeParenthesis();
            } else if (isDig()) {
                tokenizeDig();
            } else if (isLetter()) {
                tokenizeIdent();
            }else{
                throw new RuntimeException("Unexpected character '"+src.charAt(currInd)+"'");
            }


        }
    }
    private void tokenizeIdent() {
        Pattern idPat = Pattern.compile("[a-zA-Z_]\\w*");
        Matcher match = idPat.matcher(src.substring(currInd));
        if (match.find()) {
            String ident = match.group();
            tokens.add(ident);
            currInd += ident.length();
        }
    }
    private boolean isLetter() {
        return Character.isLetter(src.charAt(currInd)) || src.charAt(currInd) == '_';
    }
    private void tokenizeDig() {
        Pattern numPat = Pattern.compile("\\d+(\\.\\d+)?");
        Matcher match = numPat.matcher(src.substring(currInd));
        if (match.find()) {
            String num = match.group();
            tokens.add(num);
            currInd += num.length();
        }
    }
    private boolean isDig() {
        return Character.isDigit(src.charAt(currInd));
    }
    private void tokenizeParenthesis() {
        char p = src.charAt(currInd);
        tokens.add(Character.toString(p));
        currInd++;
    }
    private boolean isParenthesis() {
        Boolean tmpBool;
        if (src.charAt(currInd) == '(') {
            tmpBool = true;
        }else if(src.charAt(currInd) == ')'){
            tmpBool = true;
        }else{
            tmpBool = false;
        }

        return tmpBool;
    }
    private void tokenizeOP() {
        char op = src.charAt(currInd);
        tokens.add(Character.toString(op));
        currInd++;
    }
    private boolean isOp() {
        boolean tmpBool = false;
        if (src.charAt(currInd) == '-') {
            tmpBool = true;
        }
        else if (src.charAt(currInd) == '/') {
            tmpBool = true;
        }
        else if (src.charAt(currInd) == '+') {
            tmpBool = true;
        }
        else if (src.charAt(currInd) == '*'){
            tmpBool = true;
        }else{
            tmpBool = false;
        }

        return tmpBool;
    }
    private void jumpWhitespace() {
        while (currInd < src.length() && isWhitespace()) {
            currInd++;
        }
    }
    private boolean isWhitespace() {
        return Character.isWhitespace(src.charAt(currInd));
    }
}