package com.yassinechalh.bankkata;

import com.yassinechalh.bankkata.domain.TransactionRepository;
import com.yassinechalh.bankkata.infrastructure.ConsoleStmtPrinter;
import com.yassinechalh.bankkata.infrastructure.SysDateProvider;
import com.yassinechalh.bankkata.service.StatementPrinter;
import com.yassinechalh.bankkata.domain.DateProvider;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {


        DateProvider dateProvider = new SysDateProvider();
        TransactionRepository repo = new TransactionRepository(dateProvider);
        StatementPrinter printer = new ConsoleStmtPrinter();

        AccountService account = new Account(repo, printer);

        account.deposit(1000);
        account.deposit(2000);
        account.withdraw(500);

        account.printStatement();
    }
}
