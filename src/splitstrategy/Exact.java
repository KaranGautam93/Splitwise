package splitstrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Exact implements SplitStrategy {
    @Override
    public Map split(ArrayList ids, float amount, Map extraInfo) {
        int len = ids.size();
        Map<Integer, Float> amountMap = new HashMap<Integer, Float>();

        for (int i = 0; i < len; i++) {
            amountMap.put((int) ids.get(i),  (float) 1.0 * ((int) extraInfo.get((int) ids.get(i))));
        }

        return amountMap;
    }
}
