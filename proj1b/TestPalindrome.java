import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        String text = "Hello World";
        Deque d = palindrome.wordToDeque(text);
        String actual = "";
        for (int i = 0; i < text.length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("Hello World", actual);
    }

    @Test
    public void testIsPalindrome() {
        CharacterComparator cc = new OffByN(3);
        String test = "racecer";
//        String test = "hello olleh";
        boolean actual = palindrome.isPalindrome(test);
        assertEquals(true, actual);
    }
}
