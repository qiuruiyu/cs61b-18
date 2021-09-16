import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TestArrayDequeGold {

    @Test
    public void testDequeMethods() {
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
        /* test addFirst and addLast */
        for (int i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();
            if (numberBetweenZeroAndOne < 0.5) {
                sad.addLast(i);
                ads.addLast(i);
                Integer expected = sad.get(sad.size() - 1);
                Integer actual = ads.get(ads.size() - 1);
                assertEquals("addLast()", expected, actual);
            } else {
                sad.addFirst(i);
                ads.addFirst(i);
                Integer expected = sad.get(0);
                Integer actual = ads.get(0);
                assertEquals("addFirst Error()", expected, actual);
            }
        }

        /* test removeFirst and removeLast */
        for (int i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();
            if (numberBetweenZeroAndOne < 0.5) {
                Integer sadLast = sad.removeLast();
                Integer adsLast = ads.removeLast();
                assertEquals("removeLast()", adsLast, sadLast);
            } else {
                Integer sadFirst = sad.removeFirst();
                Integer adsFirst = ads.removeFirst();
                assertEquals("removeFirst()", adsFirst, sadFirst);
            }
        }
    }
}
