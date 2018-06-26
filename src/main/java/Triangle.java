import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Salty on 4/26/2018.
 */
public class Triangle {

    int solution(int A[], int N) {
        if (N < 3) {
            return 0;
        }
        Arrays.sort(A);
        for (int i = 0; i < N-2; i++) {
            if (A[i] + A[i+1] > A[i+2]) {
                return 1;
            }
        }
        return 0;
    }
}
