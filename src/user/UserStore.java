package user;

import splitstrategy.SplitStrategy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class UserStore {
    private List users = new ArrayList<Users>();

    public List getUsers() {
        return users;
    }

    public void addUser(Users user) {
        users.add(user);
    }

    public void printUserOwnedAmounts(Users user) {
        Map<Integer, Float> userMap = user.getUserBalances();

        Iterator<Map.Entry<Integer, Float>> it = userMap.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<Integer, Float> entry = it.next();

            if (entry.getKey() != user.getId()) {
                if (entry.getValue() < 0) {
                    System.out.println(user.getName() + " owes $" + Math.abs(entry.getValue()) + " to " + getUserById(entry.getKey()).getName());
                } else if (entry.getValue() > 0) {
                    System.out.println(user.getName() + " expecting $" + Math.abs(entry.getValue()) + " from " + getUserById(entry.getKey()).getName());
                }
            }

        }
    }

    public Users getUserById(int id) {
        return (Users) users.get(id);
    }

    public void split(Users user, ArrayList ids, SplitStrategy strategy, float amount, Map extraInfo) {
        Map<Integer, Float> updates = strategy.split(ids, amount, extraInfo);

        Iterator<Map.Entry<Integer, Float>> it = updates.entrySet().iterator();

        while (it.hasNext()) {
            //update for user who made payment
            Map.Entry<Integer, Float> entry = it.next();
            user.setOwedMap(entry.getKey(), entry.getValue());

            //update for user for whom transaction was made
            Users otherUser = getUserById(entry.getKey());
            otherUser.setOwedMap(user.getId(), -entry.getValue());
        }
    }
}
