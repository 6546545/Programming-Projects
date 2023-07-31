import java.util.HashMap;
import java.util.Map;

public class SemanticAnalyzer {
    private Map<String, String> symbolTable;

    public SemanticAnalyzer(){
        this.symbolTable = new HashMap<>();
    }
    public void analyze(ASTNode root){
        analyzeNode(root);
    }
    public void analyzeNode(ASTNode node){
        if (node instanceof VarDecNode) {
            analyzeVarDec((VarDecNode)node);
        } else if (node instanceof IfStatementNode) {
            analyzeIf((IfStatementNode)node);
        } else if (node instanceof ExpressNode) {
            analyzeExpress((ExpressNode)node);
        }

        for(ASTNode child : node.getChildren()){
            analyzeNode(child);
        }
    }
    private String analyzeExpress(ExpressNode node) {
        if (node.isLiteral()) {
            return node.getType();
        } else if (node.isVarRef()) {
            String varName = node.getVarName();
            if (!symbolTable.containsKey(varName)) {
                throw new RuntimeException("Variable '" + varName + "' is not declared.");
            }
            return symbolTable.get(varName);
        } else if (node.isBinaryOp()) {
            String leftType = analyzeExpress(node.getLeftOp());
            String rightType = analyzeExpress(node.getRightOp());
            String op = node.getOp();

            if (!isOpSupported(op) || !isTypeCompatible(leftType, rightType)) {
                throw new RuntimeException("Invalid operator or type mismatch in expression.");
            }
            return getResultTypeForOp(op, leftType,rightType);
        }
        throw new RuntimeException("Unsupported expression type.");
            
        
    }
    private void analyzeIf(IfStatementNode node) {
        //TODO
    }
    private void analyzeVarDec(VarDecNode node) {
        String VarName = node.getVarName();
        String VarType = node.getVarType();

        if (symbolTable.containsKey(VarName)) {
            throw new RuntimeException("Variable '" + VarName + "' is already declared.");
        }
        if (node.hasInit()) {
            String initType = analyzeExpress(node.getInit())
            if (!isTypeCompatible(VarType, initType)) {
                throw new RuntimeException("Type mismatch in variable '" + VarName + "' declaration.");
            }
        }
        symbolTable.put(VarName, VarType);
    }
}
