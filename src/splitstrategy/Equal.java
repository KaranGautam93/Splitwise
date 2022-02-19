package splitstrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Equal implements SplitStrategy {
    @Override
    public Map<Integer, Float> split(ArrayList ids, float amount, Map extraInfo) {
        int len = ids.size();
        Map<Integer, Float> amountMap = new HashMap<Integer, Float>();

        for (int i = 0; i < len; i++) {
            amountMap.put((int) ids.get(i), (float) amount / len);
        }
        return amountMap;
    }
}
