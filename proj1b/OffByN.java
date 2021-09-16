public class OffByN implements CharacterComparator {

    /**
     * private variables
     */
    private int n;

    /**
     * Constructor
     */
    public OffByN(int N) {
        n = N;
    }

    /**
     * check equal N
     */
    public boolean equalChars(char x, char y) {
        if (Math.abs(x - y) == n) {
            return true;
        }
        return false;
    }
}
