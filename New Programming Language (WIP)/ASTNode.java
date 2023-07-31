import java.util.ArrayList;
import java.util.List;

public class ASTNode {
    private List<ASTNode> children;

    public ASTNode(){
        this.children = new ArrayList<>();
    }
    public void addChild(ASTNode child){
        children.add(child);
    }
    public List<ASTNode> getChildren(){
        return children;
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
    public String getVarName() {
        return null;
    }
    public boolean isBinaryOp() {
        return false;
    }
    public ASTNode getLeftOp() {
        return null;
    }
    public String getOp() {
        return null;
    }
    public ASTNode getRightOp() {
        return null;
    }

}
