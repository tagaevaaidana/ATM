package atm.dao;

import atm.model.UserAccount;

import java.util.ArrayList;
import java.util.List;

public class AccountDao {
    private List<UserAccount> userAccounts = new ArrayList<>();

    public List<UserAccount> getUserAccounts() {
        return userAccounts;
    }
}
