public class ConcatStrategy implements OperationStrategy {
    @Override
    public int execute(int a, int b) {
        return Integer.parseInt(String.valueOf(a) + String.valueOf(b));
    }
}