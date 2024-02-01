package atm.service.impl;

import atm.dao.AccountDao;
import atm.model.UserAccount;
import atm.service.AccountService;
import java.util.Random;
import java.util.Scanner;

public class AccountServiceImpl implements AccountService {
    private final AccountDao accountDao = new AccountDao();
    private final Random random = new Random();
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void singUp(String name, String lastName) {
        UserAccount userAccount = new UserAccount();
        userAccount.setName(name);
        userAccount.setLastName(lastName);
        userAccount.setPinCode(String.valueOf(random.nextInt(1000,9999)));
        userAccount.setCardName(String.valueOf(random.nextInt(10_000_000,99_999_999)));
        accountDao.getUserAccounts().add(userAccount);
        System.out.println(userAccount);
    }

    @Override
    public void singIn(String name, String lastName) {
        UserAccount userAccount = null;
        for (int i = 0; i < accountDao.getUserAccounts().size(); i++) {
            if (accountDao.getUserAccounts().get(i).getName().equals(name)
            && accountDao.getUserAccounts().get(i).getLastName().equals(lastName)){
                userAccount = accountDao.getUserAccounts().get(i);
            }
        }
//        if (userAccount == null) {
//            throw new RuntimeException("Пользователь не найден ");
//        }


        System.out.println("Чтобы узнать баланс нажмите на 1");
        System.out.println("Чтобы пополнить баланс нажмите на 2");
        System.out.println("Перевести деньги к другу нажми на 3");


        int atm = scanner.nextInt();
        switch (atm){
            case 1:{
                System.out.println("write to card  number");
                String cardNumber= String.valueOf(scanner.nextInt());
                System.out.println("Write pincode");
                String pinCode= String.valueOf(scanner.nextInt());
                balance(cardNumber,pinCode);
            }

                break;
            case 2:
                System.out.println("Ваш баланс");
                int
                break;
            case 3:
                break;
            case 4:
                System.out.println("Чтобы снять деньги нажми на 4");
                break;
        }
    }

    @Override
    public void balance(String cardNumber, String pinCode) {
        UserAccount userAccount = null;
            for (int i = 0; i < accountDao.getUserAccounts().size(); i++) {
                if (accountDao.getUserAccounts().get(i).getCardName().equals(cardNumber)
                        && accountDao.getUserAccounts().get(i).getPinCode().equals(pinCode)) {
                    throw new RuntimeException("Not found user! ");
                }
            }

    }

    @Override
    public void deposit(String cardNumber, String pinCode) {
        System.out.println("На какую сумму хотите пополнится?");
        int sum = scanner.nextInt();
        for (int i = 0; i < accountDao.getUserAccounts().size(); i++) {
            if (accountDao.getUserAccounts().get(i).getCardName().equals(cardNumber)
                    && accountDao.getUserAccounts().get(i).getPinCode().equals(pinCode)){
                accountDao.getUserAccounts().set(sum,accountDao.getUserAccounts().get(i));

            }
        }
    }

    @Override
    public void sendToFriend(String friendCardNumber) {
        System.out.println("Сколько хотите отправить деньги к другу?");
        Scanner scanner = new Scanner(System.in);
        int balance = scanner.nextInt();
        for (int i = 0; i < accountDao.getUserAccounts().size(); i++) {
            if (accountDao.getUserAccounts().get(i).getBalance() == 500){
                accountDao.getUserAccounts().get(i).setBalance(balance);
            }
        }

    }

    @Override
    public void withdrawMoney(int amount) {
        for (int i = 0; i < accountDao.getUserAccounts().size(); i++) {
            System.out.println(accountDao.getUserAccounts().get(i));
        }

    }

}
