import java.util.HashMap;

public class Cyrus {
    String code;

    public Cyrus(String code){
        this.code = code;
    }

    public HashMap<Object, String> tokenize(){
        int len = this.code.length();
        int pos = 0;
        HashMap<Object, String> tokens = new HashMap<Object, String>();
        String[] KEYWORDS = {"print"};

        CharSequence allowedChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_";
        String allowedCharsString = String.valueOf(allowedChars);
        
        while (pos < len) {
            char currChar = this.code.charAt(pos);


            if (currChar == ' ' || currChar == '\n') {
                pos++;
                continue;
            } else if (currChar == '"') {
                String tempString = "";
                pos++;

                while (this.code.charAt(pos) != '"' && this.code.charAt(pos) != '\n' && pos < len) {
                    tempString += this.code.charAt(pos);
                    pos++;
                }
                if (this.code.charAt(pos) != '"') {
                    throw new Error("String is not valid.");
                }
                pos++;
                tokens.put("string", tempString);
            } else if (allowedChars.toString().contains(String.valueOf(currChar))) {
                String tempString = String.valueOf(currChar);
                pos++;

                while (allowedChars.toString().contains(String.valueOf(currChar)) && pos < len) {
                    tempString += this.code.charAt(pos);
                    pos++;

                }
                if (!tempString.matches(KEYWORDS[0])) {
                    throw new Error("Unexpected token: " + tempString);
                }
                tokens.put("keyword", tempString);
            }
            
        }
        return tokens;
    }
    public void run(){
        HashMap<Object, String> newMap = new HashMap<Object,String>();
        String newTokenERROR = this.tokenize().toString();
        //newMap.put(newTokenERROR, newTokenERROR);
        System.out.println(newTokenERROR);
    }

    public static void main(String[] args) {
    Cyrus newCyrus = new Cyrus("print");
    newCyrus.run();
    }
}
