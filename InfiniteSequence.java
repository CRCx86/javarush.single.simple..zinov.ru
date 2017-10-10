import java.math.BigInteger;

public class InfiniteSequence {

    private String R = new String();
    private BigInteger bigInteger;

    public long findSequence(String A) {

        long result = 0;
        this.bigInteger = BigInteger.ONE;
        R = this.bigInteger.toString();
        while (true) {

            result = equalStrings(R, A);
            if (result > 0)
                break;
            else {
                fillString();
            }

        }

        return result;
    }

    private void fillString() {
        bigInteger = bigInteger.add(BigInteger.ONE);
        R = R + bigInteger.toString();
    }

    public int equalStrings(String first, String second) {

        return kmp(first, second) + 1;

    }

    public static int kmp(String search, String target) {
        int[] failureTable = failureTable(target);

        int targetPointer = 0;
        int searchPointer = 0;

        while (searchPointer < search.length()) {
            if (search.charAt(searchPointer) == target.charAt(targetPointer)) {
                targetPointer++;
                if (targetPointer == target.length()) {
                    int x = target.length();
                    return searchPointer - x + 1;
                }
                searchPointer++;
            } else if (targetPointer > 0) {
                targetPointer = failureTable[targetPointer];
            } else {
                searchPointer++;
            }
        }
        return -1;
    }

    public static int[] failureTable(String target) {
        int[] table = new int[target.length() + 1];

        table[0] = -1;
        table[1] = 0;

        int left = 0;
        int right = 2;

        while (right < table.length) {
            if (target.charAt(right - 1) == target.charAt(left)) {
                left++;
                table[right] = left;
                right++;
            }  else if (left > 0) {

                left = table[left];
            } else {
                table[right] = left;
                right++;
            }
        }
        return table;
    }

}
