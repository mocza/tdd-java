import java.util.Arrays;

/**
 * Created by Salty on 4/24/2018.
 */
public class PermMissingElem {

    int solution(int A[]) {
        int sumN = Arrays.stream(A).sum();
        int sumNPlus1 = (A.length + 1) * (A.length +2)/2;
        return sumNPlus1 - sumN;
    }

}
