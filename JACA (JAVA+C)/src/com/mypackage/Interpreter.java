package src.com.mypackage;


import java.util.HashMap;
import java.util.Map;

public class Interpreter {
    private Map<String, Integer> variables;

    public Interpreter() {
        variables = new HashMap<>();
    }

    public void assign(String varName, int value) {
        variables.put(varName, value);
    }

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

    public static void main(String[] args) {
        Interpreter interpreter = new Interpreter();

        String code = "x = 10\n" +
                      "y += 5\n" +
                      "z = 7";

        interpreter.execute(code);

        System.out.println(interpreter.variables);
    }
}
