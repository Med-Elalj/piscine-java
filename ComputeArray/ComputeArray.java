public class ComputeArray {

    public static int[] computeArray(int[] array) {
        if (array == null) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            int v = array[i];
            int m = v % 3;
            if (m == 0) {
                array[i] = v * 5;
            } else if (m == 1) {
                array[i] = v + 7;
            }
        }
        return array;
    }
}
