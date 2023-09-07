
import java.util.HashMap;
import java.util.Map;
/*
 * @6546545
 * 
 * This Interpreter class performs the Interpretation of the code.
 * 
 * 
 * 
 */
public class Interpreter {
    //Variables
    Map<String, Integer> variables;

    //Constructor
    public Interpreter() {
        variables = new HashMap<>();
    }

    /* Assign
     *    Assigns the variable name and value of Map<S,I>
     * 
     * @param String, int
     * 
     */
    public void assign(String varName, int value) {
        variables.put(varName, value);
    }

    /* Execute
     *    Executes the digestion of the code.
     * 
     * 
     * @param String code
     */
    public void execute(String code) {
        String[] lines = code.split("\n");
        for (String line : lines) {
            String[] tokens = line.split("\\s+");
            if (tokens.length >= 3) {
                String varName = tokens[0];
                String operator = tokens[1];
                int value = Integer.parseInt(tokens[2]);
                
                if (operator.equals("=")) {
                    assign(varName, value);
                } else if (operator.equals("+=")) {
                    if (variables.containsKey(varName)) {
                        variables.put(varName, variables.get(varName) + value);
                    } else {
                        System.out.println("Variable '" + varName + "' not defined.");
                    }
                } else {
                    System.out.println("Invalid operator: " + operator);
                }
            } else {
                System.out.println("Invalid statement: " + line);
            }
        }
    }

}