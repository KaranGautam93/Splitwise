import splitstrategy.Equal;
import splitstrategy.Exact;
import splitstrategy.Percent;
import user.UserStore;
import user.Users;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        UserStore userStore = new UserStore();

        Users user1 = new Users(0,"Karan");
        Users user2 = new Users(1,"Sanchit");

        userStore.addUser(user1);
        userStore.addUser(user2);

        ArrayList flatMates = new ArrayList<Integer>();

        flatMates.add(0);
        flatMates.add(1);

        userStore.split(user1,flatMates, new Equal(), 1000,new HashMap<Integer,Integer>());

        userStore.printUserOwnedAmounts(user1);
        userStore.printUserOwnedAmounts(user2);

        //strategy exact
        Map<Integer,Integer> exactAmountMap = new HashMap<Integer,Integer>();
        int totatExactAmount = 1243;

        exactAmountMap.put(0,243);
        exactAmountMap.put(1,1000);

        userStore.split(user2,flatMates, new Exact(), totatExactAmount, exactAmountMap);

        userStore.printUserOwnedAmounts(user1);
        userStore.printUserOwnedAmounts(user2);

        //strategy percent

        Map<Integer,Integer> percentAmountMap = new HashMap<Integer,Integer>();

        percentAmountMap.put(0,40);
        percentAmountMap.put(1,60);
        userStore.split(user1, flatMates, new Percent(), (float) 1540.24, percentAmountMap);

        userStore.printUserOwnedAmounts(user1);
        userStore.printUserOwnedAmounts(user2);
    }
}
