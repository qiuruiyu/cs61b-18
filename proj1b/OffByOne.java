public class OffByOne implements CharacterComparator {

    /**
     * check whether two characters are equal alphabetically
     */
    public boolean equalChars(char x, char y) {
        if (Math.abs(x - y) == 1) {
            return true;
        }
        return false;
    }
}
