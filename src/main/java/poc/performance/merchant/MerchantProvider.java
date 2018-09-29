package poc.performance.merchant;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;

public class MerchantProvider {

    public List<String> all() {
        List<String> merchants = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            merchants.add(
                    RandomStringUtils.random(10, true, false));
        }
        return merchants;
    }
}
