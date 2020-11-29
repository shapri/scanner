package scanner;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public static void main(String... args) throws IOException {

        if(args.length != 1) {
            System.out.println("Usage java scanner.Main /path/to/input_file");
            return;
        }

        String filename = args[0];
        String[] result = new DigitalNumberParser().parseFile(filename);
        System.out.println(Arrays.stream(result).collect(Collectors.joining(System.lineSeparator())));
    }
}
