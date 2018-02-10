
public class BinaryZip {

    private int getLength(int i) {

        int res = 0;
        while (0 != i >> 1) {
            res++;
            i >>= 1;
        }
        return res;
    }

    private int getMarker(int val) {

        int res = 1;
        for (int i = 0; i < val; i++) {
            res <<= 1;
        }
        return res;
    }



    public int solution(int A, int B) {
        StringBuilder string = new StringBuilder();

        int margerA = getMarker(getLength(A));
        int margerB = getMarker(getLength(B));

        // common part
        while (margerA > 0 && margerB > 0) {

            if ((A & margerA) != 0) {
                string.append('1');
            } else {
                string.append('0');
            }

            if ((B & margerB) != 0) {
                string.append('1');
            } else {
                string.append('0');
            }

            margerA >>= 1;
            margerB >>= 1;
        }

        // rest part
        int restMarker;
        int restValue;

        if (0 != margerA) {
            restMarker = margerA;
            restValue = A;
        } else {
            restMarker = margerB;
            restValue = B;
        }

        while (restMarker > 0) {
            if ((restValue & restMarker) != 0) {
                string.append('1');
            } else {
                string.append('0');
            }
            restMarker >>= 1;
        }

        return Integer.parseInt(string.toString(), 2);
    }


    //  main
    public static void main(String[] args) {

        BinaryZip zip = new BinaryZip();

        int zip = cod.solution(12, 56);

        System.out.println(zip);
    }
