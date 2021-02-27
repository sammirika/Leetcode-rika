package array;

import java.util.Stack;

public class isMonotonic_896 {

    public boolean isMonotonic(int[] A) {
        boolean a = true, b = true;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                a = false;
            }
            if (A[i] < A[i - 1]) {
                b = false;
            }
        }
        return a || b;
    }
}
