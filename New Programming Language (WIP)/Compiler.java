import java.util.List;

public class Compiler {
    private Lexer lexer;
    private ASTNode parser;
    private SemanticAnalyzer semanticAnalyzer;

    public Compiler(){
        this.lexer = lexer;
        this.parser = parser;
        this.semanticAnalyzer = new SemanticAnalyzer();
    }
    public void compile(String src){
        try {
            //STEP 1: Tokenization
            lexer.tokenize(src);
            List<String> tokens = lexer.getTokens();

            //STEP 2: Parsing
            ASTNode root = parser;

            //STEP 3: Semantic Analysis
            semanticAnalyzer.analyze(root);

            //STEP 4: Code Generation
            //TODO


            System.out.println("Compilation successful!");
        } catch (Exception e) {
            System.out.println("Compilation error: "+ e.getMessage());
        }
    }
    public static void main(String[] args) {
        //TODO: Change to allow file input
        String srcCode = "";

        Compiler compiler = new Compiler();
        compiler.compile(srcCode);
    }
}
