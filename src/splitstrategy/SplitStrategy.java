package splitstrategy;

import java.util.ArrayList;
import java.util.Map;

public interface SplitStrategy {
    public Map split(ArrayList ids, float amount, Map extraInfo);
}
