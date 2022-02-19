package user;

import java.util.HashMap;
import java.util.Map;

public class Users {
    private int id;
    private String name;

    private Map<Integer,Float>userBalanceMap = new HashMap<Integer,Float>();

    public Users(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map getUserBalances()
    {
        return this.userBalanceMap;
    }

    public void setOwedMap(int id, float amount)
    {
        if(userBalanceMap.get(id) != null)
        {
            amount+= userBalanceMap.get(id);
        }
        userBalanceMap.put(id,amount);
    }

}
