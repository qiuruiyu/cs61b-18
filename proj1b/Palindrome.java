public class Palindrome {

    /**
     * break the String into Characters in deque
     */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> res = new LinkedListDeque<Character>();
        for (int i = 0; i < word.length(); i += 1) {
            res.addLast(word.charAt(i));
        }
        return res;
    }

    /**
     * check whether a word is palindrome recursively
     */
    public boolean isPalindrome(String word) {
        if (word.length() <= 1) {
            return true;
        } else {
            if (word.charAt(0) == word.charAt(word.length() - 1)) {
                return isPalindrome(word.substring(1, word.length() - 1));
            } else {
                return false;
            }
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.length() <= 1) {
            return true;
        } else {
            if (cc.equalChars(word.charAt(0), word.charAt(word.length() - 1))) {
                return isPalindrome(word.substring(1, word.length() - 1), cc);
            } else {
                return false;
            }
        }
    }
}
