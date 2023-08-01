import java.util.List;

public class Parser {
    private List<String> tokens;
    private int currIndex;

    public Parser(List<String> tokens){
        this.tokens = tokens;
        this.currIndex = 0;
    }
    public Parser(){}

    private void progressIndex(){
        currIndex ++;
    }
    public void parse(){
        parsePrgm();
    }
    public ASTNode parse(List<String> tokens){
        this.tokens = tokens;
        this.currIndex = 0;
        return parsePrgm();
    }

    private ASTNode parsePrgm() {
        ASTNode root = new ASTNode();
        while (currIndex < tokens.size()) {
            ASTNode statement = parseStatement();
            if (statement!=null) {
                root.addChild(statement);
            }
        }
        return root;
    }

/// SUBJECT TO CHANGE IN FURTHER UPDATES
    private ASTNode parseStatement() {
        if (match("let")) {
            return parseVarDec();
        } else if (match("if")) {
            return parseIf();
        } else {
            return parseExpress();
        }
    }
private ASTNode parseExpress() {
    
    parseTerm();
    while (match("+")||match("-")) {
        progressIndex();
        parseTerm();
        
    }
    //AST Nodes for further processing
}

    private void parseTerm() {
        parseFact();
        while (match("*")||match("/")) {
            progressIndex();
            parseFact();
        }
    //AST Nodes for further processing
}

    private void parseFact() {
        if (match("(")) {
            progressIndex();
            parseExpress();
            expect(")");
        }else{
            if (match("-") && isDig(tokens.get(currIndex+1))) {
                progressIndex();
            }
            expectNumOrIdent();
        }
    }

    private void expectNumOrIdent() {
        String toke = tokens.get(currIndex);
        if (!isDig(toke) && !isValidIdent(toke)) {
            throw new RuntimeException("Invalid number or identifier '"+ toke +"'");
        }
        progressIndex();
    }

    private boolean isValidIdent(String toke) {
        if (toke.matches("[a-zA-Z_][a-zA-Z0-9_]*")) {
            return true;
        }
        return false;
    }

    private boolean isDig(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            try {
                Float.parseFloat(string);
                return true;
            } catch (NumberFormatException ex) {
                return false;
            }
        }
    }

    private void expect(String string) {
        if (match(string)) {
            progressIndex();
        } else {
            throw new RuntimeException("Expected '" + string + "', but found '" + tokens.get(currIndex));
        }
    }

    /*
 * Parses IF - Then - Else Statements
 */
    private ASTNode parseIf() {
        expect("if");
        ASTNode condition = parseExpress();
        expect("then");
        ASTNode thenStatement = parseStatement();

        ASTNode elseStatement = null;
        if (match("else")) {
            progressIndex();
            elseStatement = parseStatement();
        }
        expect("end");
        //AST Nodes for further processing
        return new IfStatementNode(condition, thenStatement,elseStatement);
    }

    private ASTNode pareseExpress() {
        /*
         * Implement parsing expressions based on Grammer rules: TBD
         */


        parseTerm();

        while (match("+") || match("-")) {
            progressIndex();
            parseTerm();
        }
        //AST Nodes for further processing
        return new ExpressNode(null, null);
    }

    private ASTNode parseVarDec() {
        //SUBJECT TO CHANGE IN FURTHER UPDATES
        expect("let");
        String varName = expectIdent();
        String varType = "int";

        if (match(":")) {
            progressIndex();
            varType = expectType();
            expect("=");
        } else {
            expect("=");
        }
        parseExpress();
        //AST Nodes for further processing
        ASTNode init = parseExpress();
        VarDecNode varDecNode = new VarDecNode(varName, varType);
        if (init!=null) {
            varDecNode.setInitilizer(init);   
        }
        return varDecNode;
    }

    private String expectType() {
        String varType = tokens.get(currIndex);
        if (!isValidIdent(varType)) {
            throw new RuntimeException("Invalid Type '" + varType + "'");
        }
        progressIndex();
        return varType;
    }

    private String expectIdent() {
        String ident = tokens.get(currIndex);
        if (!isValidIdent(ident)) {
            throw new RuntimeException("Invalid identifier '"+ ident + "'");
        }
        progressIndex();
        return ident;
    }

    private boolean match(String string) {
        if(currIndex < tokens.size() && tokens.get(currIndex).equals(string)){
            return true;
        }
        return false;
    }
}
