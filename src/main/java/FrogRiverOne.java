import java.util.Arrays;

/**
 * Created by Salty on 4/27/2018.
 */
public class FrogRiverOne {

    int solution(int X, int A[]) {
        int[] leaves = new int[X+1];
        for (int i = 0; i < A.length; i++) {
            leaves[A[i]] = A[i];
            boolean continuous = true;
            for (int j = 1; j < leaves.length; j++) {
                if (leaves[j] != j) {
                    continuous = false;
                    break;
                }
            }
            if (continuous == true) {
                return i;
            }
        }
        return -1;
    }


}
