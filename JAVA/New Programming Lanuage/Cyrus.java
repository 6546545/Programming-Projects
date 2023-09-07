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
    
    public void parse(String[] tokens){
        int len = tokens.length;
        int pos = 0;

        while (pos < len) {
            String token = tokens[pos];
            //Implement Code
            if (token == "keyword" && token == "print") { //token.type == keyword && token == "print"
                if (tokens[pos+1].isEmpty()) {
                    System.out.println("Unexpected end of line, expected a string");
                }
                boolean isString = false;
                if (!tokens[pos+1].isEmpty()) {
                    isString = true;
                }

                if (!isString) {
                    System.out.println("Unexpected token: " + tokens[pos+1] + ", expected a string.");
                }
                System.out.println("\\x1b[35m%s\\x1b[0m" + tokens[pos+1]);
                pos += 2;
            }else{
                System.out.println("Unexpected Token: " + tokens[pos+1]);
                pos += 2;
            }
        }
    }
    
    
    
    
    public void run(){
        HashMap<Object, String> newMap = new HashMap<Object,String>();
        String newTokenERROR = this.tokenize().toString();
        String tmp = newTokenERROR.substring(1, newTokenERROR.length()-1);
        String[] tmpString = tmp.split("=");
        newMap.put(tmpString[0], tmpString[1]);

        this.parse(tmpString);


        System.out.println(newMap);
    }

    public static void main(String[] args) {
        String code = "print";
        Cyrus newCyrus = new Cyrus(code);
        newCyrus.run();
    }
}
