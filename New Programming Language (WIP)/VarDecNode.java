public class VarDecNode extends ASTNode {
    private String varName;
    private String varType;
    private ASTNode initializer;

    public VarDecNode(String varName, String varType) {
        this.varName = varName;
        this.varType = varType;
    }
    public void setInitilizer(ASTNode initializer){
        this.initializer = initializer;
    }
    public boolean hasInit(){
        return initializer != null;
    }
    public ASTNode getInitializer(){
        return initializer;
    }
    public String getVarName(){
        return varName;
    }
    public String getVarType(){
        return varType;
    }

    
}
