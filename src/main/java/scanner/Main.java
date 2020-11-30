package scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    private static Logger LOG = LoggerFactory.getLogger(Main.class);
    
    public static void main(String... args) throws IOException {

        if(args.length != 1) {
            System.out.println("Usage java scanner.Main /path/to/input_file");
            return;
        }

        String filename = args[0];
        String[] result = new DigitalNumberParser().parseFile(filename);
        for(String r : result)
            LOG.info(r);
    }
}
