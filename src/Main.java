import atm.service.AccountService;
import atm.service.impl.AccountServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AccountServiceImpl accountService = new AccountServiceImpl();
        accountService.singUp("Aidana","Tagaeva");
        accountService.singUp("Timur","Kasymbaev");
        System.out.println("Name: ");
        String name = scanner.nextLine();
        System.out.println("Last Name: ");
        String lastName = scanner.nextLine();
        accountService.singIn(name,lastName);
    }
}