public class ExpressNode extends ASTNode {
    private String varName;
    private String varType;
    private ASTNode init;

    public ExpressNode (String varName, String varType){
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
    public boolean isLiteral() {
        return false;
    }
    public String getType() {
        return null;
    }
    public boolean isVarRef() {
        return false;
    }
    public boolean isBinaryOp() {
        return false;
    }
    public ExpressNode getLeftOp() {
        return null;
    }
    public ExpressNode getRightOp() {
        return null;
    }
    public String getOp() {
        return null;
    }
}
