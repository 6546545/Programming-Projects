package src;


/*
 * This is the main class for this project.
 * 
 */
public class Main {
    public static void main(String[] args) {
        Interpreter interpreter = new Interpreter();
        String code = "x = 10\n" +
                    "y = 5\n" + //To see error change to '+='
                    "z = 7";

        interpreter.execute(code);
        System.out.println(interpreter.variables);
    }
}
