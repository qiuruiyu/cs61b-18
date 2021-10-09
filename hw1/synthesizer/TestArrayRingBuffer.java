package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
        for(int i = 0; i < 10; i += 1) {
            arb.enqueue(i);
            assertEquals(i + 1, arb.fillCount);
        }
        assertEquals(true, arb.isFull());
        for(int i = 0; i < 10; i += 1) {
            int t = (int)arb.dequeue();
            assertEquals(i, t);
            assertEquals(9 - i, arb.fillCount);
        }
        assertEquals(true, arb.isEmpty());
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 

