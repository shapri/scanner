package scanner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Digit {

    static int LINES = 3;
    static int CHARS = 3;
    
    static final String[][] digits = {

    new String[] {
        " _ ",
        "| |",
        "|_|"
        },

    new String[] {
        "   ",
        "  |",
        "  |"
    },

    new String[] {
        " _ ",
        " _|",
        "|_ "
    },

    new String[] {
        " _ ",
        " _|",
        " _|"
    },

    new String[] {
        "   ",
        "|_|",
        "  |"
    },

    new String[] {
        " _ ",
        "|_ ",
        " _|"
    },

    new String[] {
        " _ ",
        "|_ ",
        "|_|"
    },

    new String[] {
        " _ ",
        "  |",
        "  |"
    },

    new String[] {
        " _ ",
        "|_|",
        "|_|"
    },

    new String[] {
        " _ ",
        "|_|",
        " _|"
    }};

    public static int parseInt(String[] testDigit) {

        if(testDigit.length != LINES)
            throw new NumberFormatException(String.format("Must have %d lines per digit", LINES));

        for(String line : testDigit)
            if( line.length() != CHARS)
                throw new NumberFormatException(String.format("Must have %d characters per line in digit", CHARS));

        List<Integer> matches = new ArrayList<>();

        for(int i = 0; i<digits.length; i++) {
            if(Arrays.equals(digits[i], testDigit) )
                matches.add(i);
        }

        if(matches.size() == 0)
            throw new NumberFormatException("No match!");

        if(matches.size() > 1)
            throw new NumberFormatException("Multiple matches! Check digit definitions");

        return matches.get(0);
    }
}
