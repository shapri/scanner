package scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class DigitalNumberParser {

    static int LINE_LENGTH = 27;
    static String ILLEGAL_CHAR = "?";
    static String ILLEGAL_TEXT = "ILL";

    private static Logger LOG = LoggerFactory.getLogger(DigitalNumberParser.class);
     
    public String[] parseFile(String filename) throws IOException {
        LOG.info("parseFile {}", filename);
        List<String> lines = Files.lines(Paths.get(getFile(filename).toURI())).collect(toList()); 
        return parse(lines.toArray(String[]::new));
    }

    private File getFile(String filename)
    {
        File file = new File(filename);

        if(!file.exists())
            throw new IllegalArgumentException(String.format("file <%s> not found!", filename));
        return file;
    }    
    
    public String[] parse(String[] _lines) {

        LOG.debug("parse {}", Arrays.toString(_lines));

        String[] lines = Arrays.stream(_lines).filter( e -> !e.isEmpty() ).toArray(String[]::new);

        if(lines.length% Digit.LINES != 0)
            throw new IllegalArgumentException(String.format("There must be exectly %d lines per number excluding blank lines", Digit.LINES));

        List<String> output = new ArrayList<>();
        for( int i=0; i<lines.length; i=i+Digit.LINES)
            output.add(parseOne(Arrays.copyOfRange(lines, i, i+ Digit.LINES)));
        
        return output.toArray(String[]::new);
    }
    
    private String parseOne(String[] lines) {

        LOG.debug("parseOne {}", Arrays.toString(lines));

        if(lines.length != Digit.LINES)
            throw new IllegalArgumentException(String.format("There must be exectly %d lines per number excluding blank lines", Digit.LINES));

        for(String line : lines )
            if(line.length() != LINE_LENGTH)
                throw new IllegalArgumentException(String.format("All Lines must be exactly %d long", LINE_LENGTH));

        StringBuilder buf = new StringBuilder();
        String[][] testDigits = split(lines);

        for(String[] testDigit : testDigits) {
            try {
                LOG.debug("parseInt {}", Arrays.toString(testDigit));
                buf.append(Digit.parseInt(testDigit));
            } catch(NumberFormatException ex) {
                buf.append(ILLEGAL_CHAR);
            }
        }

        String number = buf.toString();

        LOG.debug("parseOne {} with result {}", Arrays.toString(lines), number);

        return isLegal(number) ? number + " " + ILLEGAL_TEXT : number;
    }

    // split line into separate CHARS x CHARS digits
    private String[][] split(String[] lines) {
        
        List<String[]> arr = new ArrayList<>();
        
        for(int beginIndex=0; beginIndex<LINE_LENGTH; beginIndex=beginIndex+Digit.CHARS) {
            
            String[] digit = new String[Digit.CHARS];

            for(int i=0; i<lines.length; i++)
                digit[i] = lines[i].substring(beginIndex, beginIndex + Digit.CHARS);
            
            arr.add( digit);
        }
        
        return arr.toArray( String[][]::new);
    }
    
    private boolean isLegal(String str) {
        return str.contains(ILLEGAL_CHAR);        
    }
}