
public class DoOp {

    public static String operate(String[] args) {
        if (args == null || args.length != 3) {
            return "Error";
        }
        try {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[2]);
            String op = args[1];
            String res = switch (op) {
                case "+" ->
                    String.valueOf(a + b);
                case "-" ->
                    String.valueOf(a - b);
                case "*" ->
                    String.valueOf(a * b);
                case "/" ->
                    String.valueOf(a / b);
                case "%" ->
                    String.valueOf(a % b);
                default ->
                    "Error";
            };
            return res;

        } catch (Exception e) {
            return "Error";
        }
    }
}
