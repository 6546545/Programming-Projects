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
    private String analyzeExpress(ASTNode astNode) {
        if (astNode.isLiteral()) {
            return astNode.getType();
        } else if (astNode.isVarRef()) {
            String varName = astNode.getVarName();
            if (!symbolTable.containsKey(varName)) {
                throw new RuntimeException("Variable '" + varName + "' is not declared.");
            }
            return symbolTable.get(varName);
        } else if (astNode.isBinaryOp()) {
            String leftType = analyzeExpress(astNode.getLeftOp());
            String rightType = analyzeExpress(astNode.getRightOp());
            String op = astNode.getOp();

            if (!isOpSupported(op) || !isTypeCompatible(leftType, rightType)) {
                throw new RuntimeException("Invalid operator or type mismatch in expression.");
            }
            return getResultTypeForOp(op, leftType,rightType);
        }
        throw new RuntimeException("Unsupported expression type.");
            
        
    }
    private String getResultTypeForOp(String op, String leftType, String rightType) {
        if (op.equals("+")||op.equals("-")||op.equals("*")||op.equals("/")) {
            return "int";
        }
        throw new RuntimeException("Unsupported operator: " + op);
    }
    private boolean isTypeCompatible(String leftType, String rightType) {
        return leftType.equals(rightType);
    }
    private boolean isOpSupported(String op) {
        return op.equals("+")||op.equals("-")||op.equals("*")||op.equals("/");
    }
    private void analyzeIf(IfStatementNode node) {
        String conditionType = analyzeExpress(node.getCondition());

        if (!conditionType.equals("bool")) {
            throw new RuntimeException("The condition in the IF statement must be of type 'bool'");
        }
        analyzeNode(node.getThenStatement());

        if (node.hasElseStatement()) {
            analyzeNode(node.getElseStatement());
        }
    }
    private void analyzeVarDec(VarDecNode node) {
        String VarName = node.getVarName();
        String VarType = node.getVarType();

        if (symbolTable.containsKey(VarName)) {
            throw new RuntimeException("Variable '" + VarName + "' is already declared.");
        }
        if (node.hasInit()) {
            String initType = analyzeExpress(node.getInitializer());
            if (!isTypeCompatible(VarType, initType)) {
                throw new RuntimeException("Type mismatch in variable '" + VarName + "' declaration.");
            }
        }
        symbolTable.put(VarName, VarType);
    }
}
