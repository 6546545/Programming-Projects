public class IfStatementNode extends ASTNode {
    private String varName;
    private String varType;
    private ASTNode init;

    public IfStatementNode (String varName, String varType){
        this.varName = varName;
        this.varType = varType;
    }
    public void setInit(ASTNode init){
        this.init = init;
    }
    public boolean hasInit(){
        return init != null;
    }
    public ASTNode getInitializer(){
        return init;
    }
    public String getVarName(){
        return varName;
    }
    public String getVarType(){
        return varType;
    }
//++++++++++++++++++++++++++++++++++++++
    public ASTNode getThenStatement() {
        return null;
    }
    public boolean hasElseStatement() {
        return false;
    }
    public ASTNode getElseStatement() {
        return null;
    }
    public ASTNode getCondition() {
        return null;
    }
}
