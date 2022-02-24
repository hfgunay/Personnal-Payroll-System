
import java.io.IOException;


public class Main {                                                 // Main class.
    public static void main(String[] args) throws IOException {     // Main function.
        Calculate calculate = new Calculate();
        calculate.readandcalculate(args[0],args[1]);
        
    }
}
