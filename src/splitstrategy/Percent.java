package splitstrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Percent implements SplitStrategy{
    @Override
    public Map split(ArrayList ids, float amount, Map extraInfo) {
        int len = ids.size();
        Map<Integer, Float> amountMap = new HashMap<Integer, Float>();

        for (int i = 0; i < len; i++) {
            amountMap.put((int) ids.get(i),  (amount * ((int) extraInfo.get((int) ids.get(i))))/100);
        }

        return amountMap;
    }
}
