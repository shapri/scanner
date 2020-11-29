package scanner;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DigitTest {

    @Test
    public void shouldBe0(){

        String[] testPattern = new String[] {
                " _ ",
                "| |",
                "|_|"
        };

        assertEquals(0, Digit.parseInt(testPattern));
    }

    @Test
    public void shouldBe1(){
        String[] testPattern = new String[] {
                "   ",
                "  |",
                "  |"
        };

        assertEquals(1, Digit.parseInt(testPattern));
    }

    @Test
    public void shouldBe2(){
        String[] testPattern = new String[] {
                " _ ",
                " _|",
                "|_ "
        };

        assertEquals(2, Digit.parseInt(testPattern));
    }

    @Test
    public void shouldBe3(){
        String[] testPattern = new String[] {
                " _ ",
                " _|",
                " _|"
        };

        assertEquals(3, Digit.parseInt(testPattern));
    }

    @Test
    public void shouldBe4(){
        String[] testPattern = new String[] {
                "   ",
                "|_|",
                "  |"
        };

        assertEquals(4, Digit.parseInt(testPattern));
    }

    @Test
    public void shouldBe5(){
        String[] testPattern = new String[] {
                " _ ",
                "|_ ",
                " _|"
        };

        assertEquals(5, Digit.parseInt(testPattern));
    }

    @Test
    public void shouldBe6(){
        String[] testPattern = new String[] {
                " _ ",
                "|_ ",
                "|_|"
        };

        assertEquals(6, Digit.parseInt(testPattern));
    }

    @Test
    public void shouldBe7(){
        String[] testPattern = new String[] {
                " _ ",
                "  |",
                "  |"
        };

        assertEquals(7, Digit.parseInt(testPattern));
    }

    @Test
    public void shouldBe8(){
        String[] testPattern = new String[] {
                " _ ",
                "|_|",
                "|_|"
        };

        assertEquals(8, Digit.parseInt(testPattern));
    }

    @Test
    public void shouldBe9(){
        String[] testPattern = new String[] {
                " _ ",
                "|_|",
                " _|"
        };

        assertEquals(9, Digit.parseInt(testPattern));
    }

    @Test(expected = NumberFormatException.class)
    public void shouldThrow(){
        String[] testPattern = new String[] {
                "   ",
                "|_|",
                "| |"
        };

        assertEquals(9, Digit.parseInt(testPattern));
    }
}