package poc.performance.merchant;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.util.Random;

public class DelayProcessor implements Processor {

    private final Random random = new Random();

    @Override
    public void process(Exchange exchange) throws Exception {
        // do some random delay between 0 - 50 millisecs
        int delay = random.nextInt(50);
        Thread.sleep(delay);
    }
}
