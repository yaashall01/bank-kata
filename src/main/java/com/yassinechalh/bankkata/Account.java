package com.yassinechalh.bankkata;

import com.yassinechalh.bankkata.domain.TransactionRepository;
import com.yassinechalh.bankkata.service.StatementPrinter;

/**
 * @author Yassine CHALH
 */
public class Account implements AccountService {

    private final TransactionRepository transactionRepository;
    private final StatementPrinter statementPrinter;

    public Account(TransactionRepository transactionRepository, StatementPrinter statementPrinter) {
        this.transactionRepository = transactionRepository;
        this.statementPrinter = statementPrinter;
    }

    @Override
    public void deposit(int amount) {
        transactionRepository.addDeposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        transactionRepository.addWithdrawal(amount);
    }

    @Override
    public void printStatement() {
        String statement = transactionRepository.generateStatement();


        statementPrinter.print(statement);
    }
}