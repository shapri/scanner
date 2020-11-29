package scanner;

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.Assert.*;

public class DigitParserTest {

    @Test
    public void shouldBe000000000(){

        String[] testPattern = new String[] {
                " _  _  _  _  _  _  _  _  _ ",
                "| || || || || || || || || |",
                "|_||_||_||_||_||_||_||_||_|",
        };

        assertArrayEquals(new String[]{"000000000"}, new DigitalNumberParser().parse(testPattern));
    }

    @Test
    public void shouldBe111111111(){
        String[] testPattern = new String[] {
                "                           ",
                "  |  |  |  |  |  |  |  |  |",
                "  |  |  |  |  |  |  |  |  |"
        };

        assertArrayEquals(new String[]{"111111111"}, new DigitalNumberParser().parse(testPattern));
    }

    @Test
    public void shouldBe222222222(){
        String[] testPattern = new String[] {
                " _  _  _  _  _  _  _  _  _ ",
                " _| _| _| _| _| _| _| _| _|",
                "|_ |_ |_ |_ |_ |_ |_ |_ |_ "
        };

        assertArrayEquals(new String[]{"222222222"}, new DigitalNumberParser().parse(testPattern));
    }

    @Test
    public void shouldBe333333333(){
        String[] testPattern = new String[] {
                " _  _  _  _  _  _  _  _  _ ",
                " _| _| _| _| _| _| _| _| _|",
                " _| _| _| _| _| _| _| _| _|"
        };

        assertArrayEquals(new String[]{"333333333"}, new DigitalNumberParser().parse(testPattern));
    }

    @Test
    public void shouldBe444444444(){
        String[] testPattern = new String[] {
                "                           ",
                "|_||_||_||_||_||_||_||_||_|",
                "  |  |  |  |  |  |  |  |  |"
        };

        assertArrayEquals(new String[]{"444444444"}, new DigitalNumberParser().parse(testPattern));
    }

    @Test
    public void shouldBe555555555(){
        String[] testPattern = new String[] {
                " _  _  _  _  _  _  _  _  _ ",
                "|_ |_ |_ |_ |_ |_ |_ |_ |_ ",
                " _| _| _| _| _| _| _| _| _|"
        };

        assertArrayEquals(new String[]{"555555555"}, new DigitalNumberParser().parse(testPattern));
    }

    @Test
    public void shouldBe666666666(){
        String[] testPattern = new String[] {
                " _  _  _  _  _  _  _  _  _ ",
                "|_ |_ |_ |_ |_ |_ |_ |_ |_ ",
                "|_||_||_||_||_||_||_||_||_|"
        };

        assertArrayEquals(new String[]{"666666666"}, new DigitalNumberParser().parse(testPattern));
    }

    @Test
    public void shouldBe777777777(){
        String[] testPattern = new String[] {
                " _  _  _  _  _  _  _  _  _ ",
                "  |  |  |  |  |  |  |  |  |",
                "  |  |  |  |  |  |  |  |  |"
        };

        assertArrayEquals(new String[]{"777777777"}, new DigitalNumberParser().parse(testPattern));
    }

    @Test
    public void shouldBe888888888(){
        String[] testPattern = new String[] {
                " _  _  _  _  _  _  _  _  _ ",
                "|_||_||_||_||_||_||_||_||_|",
                "|_||_||_||_||_||_||_||_||_|"
        };

        assertArrayEquals(new String[]{"888888888"}, new DigitalNumberParser().parse(testPattern));
    }

    @Test
    public void shouldBe999999999(){

        String[] testPattern = new String[] {
                " _  _  _  _  _  _  _  _  _ ",
                "|_||_||_||_||_||_||_||_||_|",
                " _| _| _| _| _| _| _| _| _|"
        };

        assertArrayEquals(new String[]{"999999999"}, new DigitalNumberParser().parse(testPattern));
    }

    @Test
    public void shouldBe123456789(){
        String[] testPattern = new String[] {
                "    _  _     _  _  _  _  _ ",
                "  | _| _||_||_ |_   ||_||_|",
                "  ||_  _|  | _||_|  ||_| _|"
        };

        assertArrayEquals(new String[]{"123456789"}, new DigitalNumberParser().parse(testPattern));
    }

    @Test
    public void shouldBe123456789_Ill_One(){
        String[] testPattern = new String[] {
                "    _  _     _  _  _  _  _ ",
                "  | _| _||_||_ |_   ||_||_|",
                "  ||_  _|  | _||_|  ||_|  |"
        };

        assertArrayEquals(new String[]{"12345678? ILL"}, new DigitalNumberParser().parse(testPattern));
    }

    @Test
    public void shouldBe123456789_Ill_Two(){
        String[] testPattern = new String[] {
                "    _  _     _  _  _  _  _ ",
                "  | _| _||_||_ |_   ||_||_|",
                " _||_  _|  | _||_|  ||_|  |"
        };

        assertArrayEquals(new String[]{"?2345678? ILL"}, new DigitalNumberParser().parse(testPattern));
    }

    @Test
    public void shouldBe123456789_Ill_Three(){
        String[] testPattern = new String[] {
                "    _  _     _  _  _  _  _ ",
                "  | _| _||_||_ |_   ||_||_|",
                " _||_| _|  | _||_|  ||_|  |"
        };

        assertArrayEquals(new String[]{"??345678? ILL"}, new DigitalNumberParser().parse(testPattern));
    }

    @Test
    public void shouldBe123456789_Ill_All(){
        String[] testPattern = new String[] {
                "    _  _     _  _  _  _  _ ",
                "  | _| _||_||_ |_   ||_||_|",
                " _||_||_| _| |_||_|  ||_| |"
        };

        assertArrayEquals(new String[]{"????????? ILL"}, new DigitalNumberParser().parse(testPattern));
    }
    
    
    @Test
    public void multipleChunks(){
        String[] testPattern = new String[] {

                "    _  _     _  _  _  _  _ ",
                "  | _| _||_||_ |_   ||_||_|",
                "  ||_  _|  | _||_|  ||_| _|",
                "",
                "    _  _     _  _  _  _  _ ",
                "  | _| _||_||_ |_   ||_||_|",
                "  ||_  _|  | _||_|  ||_| _|",
                "",
                "    _  _     _  _  _  _  _ ",
                "  | _| _||_||_ |_   ||_||_|",
                "  ||_  _|  | _||_|  ||_| _|",
        };

        String[] expected = {"123456789", "123456789", "123456789"};
        assertArrayEquals(expected, new DigitalNumberParser().parse(testPattern));
    }


    @Test
    public void multipleChunksWithIllegalRow(){
        String[] testPattern = new String[] {

                "    _  _     _  _  _  _  _ ",
                "  | _| _||_||_ |_   ||_||_|",
                "  ||_  _|  | _||_|  ||_| _|",
                "",
                "    _  _     _  _  _  _  _ ",
                "  | _| _||_||_ |_   ||_||_|",
                "  ||_  _|  | _||_|| ||_| _|",
                "",
                "    _  _     _  _  _  _  _ ",
                "  | _| _||_||_ |_   ||_||_|",
                "  ||_  _|  | _||_|  ||_| _|"

        };

        String[] expected = {"123456789", "123456?89 ILL", "123456789"};
        assertArrayEquals(expected, new DigitalNumberParser().parse(testPattern));
    }

    @Test
    public void singleChunk(){
        String[] testPattern = new String[] {

                " _  _  _  _  _  _  _  _  _ ",
                "| || || || || || || || || |",
                "|_||_||_||_||_||_||_||_||_|"
        };

        String[] expected = {"000000000"};
        assertArrayEquals(expected, new DigitalNumberParser().parse(testPattern));
    }

    @Test(expected = IllegalArgumentException.class)
    public void linesShouldBeExactly27CharactersLong(){
        String[] testPattern = new String[] {

                " _  _  _  _  _  _  _  _  _    ",
                "| || || || || || || || || |",
                "|_||_||_||_||_||_||_||_||_|"
        };

        new DigitalNumberParser().parse(testPattern);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldBeThreeLinesPerNumber(){
        String[] testPattern = new String[] {

                "| || || || || || || || || |",
                "|_||_||_||_||_||_||_||_||_|"
        };

        new DigitalNumberParser().parse(testPattern);
    }

    @Test()
    public void shouldNotThrowForAnEmptyArray(){
        String[] testPattern = new String[] {
        };

        new DigitalNumberParser().parse(testPattern);
    }

    @Test()
    public void shouldReadMultipleChunksFile() throws IOException {
        String[] expected = {"123456789", "123456789", "123456789"};
        String[] actual = new DigitalNumberParser().parseFile("src/test/resources/multipleChunks.txt");
        
        assertArrayEquals(expected, actual);
    }

    @Test()
    public void shouldReadMultipleChunksWithIllegalRowFile() throws IOException {

        String[] expected = {"123456789", "123456?89 ILL", "123456789"};
        String[] actual = new DigitalNumberParser().parseFile("src/test/resources/multipleChunksWithIllegalRow.txt");
        assertArrayEquals(expected, actual);
    }

    @Test()
    public void shouldReadSingleChunkFile() throws IOException {
        String[] expected = {"000000000"};
        String[] actual = new DigitalNumberParser().parseFile("src/test/resources/singleChunk.txt");
        assertArrayEquals(expected, actual);
    }

    @Test()
    public void shouldReadHappyPathFile() throws IOException {
        String[] expected = {"000000000", "111111111", "222222222", "333333333", "444444444", "555555555", 
                "666666666", "777777777", "888888888", "999999999", "123456789"};
        String[] actual = new DigitalNumberParser().parseFile("src/test/resources/happy_path.txt");
        assertArrayEquals(expected, actual);
    }
    
    
    

}