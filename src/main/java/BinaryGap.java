/**
 * Created by Salty on 4/23/2018.
 */
public class BinaryGap {

    public int solution(int N) {
        if (N < 1) {
            throw new IllegalArgumentException("N must be larger than zero");
        }
        int dividend = N;
        int maxBinGap = 0;
        int gapSize = 0;
        boolean hasOne = false;
        while (dividend != 0) {
            int remainder = dividend % 2;
            if (remainder == 1) {
                maxBinGap = gapSize > maxBinGap ? gapSize : maxBinGap;
                gapSize = 0;
                hasOne = true;
            } else if (hasOne) {
                gapSize += 1;
            }
            dividend = dividend / 2;
        }
        return maxBinGap;
    }
}
