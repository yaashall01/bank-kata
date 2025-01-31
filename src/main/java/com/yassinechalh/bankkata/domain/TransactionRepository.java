package com.yassinechalh.bankkata.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Yassine CHALH
 */
public class TransactionRepository {

    private final DateProvider dateProvider;
    private final List<Transaction> transactions = new ArrayList<>();

    public TransactionRepository(DateProvider dateProvider) {
        this.dateProvider = dateProvider;
    }

    public void addDeposit(int amount) {
        String today = dateProvider.today();
        transactions.add(new Transaction(today, amount));
    }

    public void addWithdrawal(int amount) {
        String today = dateProvider.today();
        transactions.add(new Transaction(today, -amount));
    }

    public String generateStatement() {
        // En-tête
        StringBuilder sb = new StringBuilder();
        sb.append("Date       || Amount || Balance\n");

        // On veut le plus récent en premier => on inverse la liste
        List<Transaction> reversed = new ArrayList<>(transactions);
        Collections.reverse(reversed);

        int runningBalance = calculateBalance(); // solde final

        for (Transaction tx : reversed) {
            int amount = tx.getAmount();
            sb.append(String.format("%s || %d   || %d\n",
                    tx.getDate(),
                    amount,
                    runningBalance
            ));
            // On retranche l’opération pour remonter le temps
            runningBalance -= amount;
        }
        return sb.toString();
    }

    private int calculateBalance() {
        int balance = 0;
        for (Transaction t : transactions) {
            balance += t.getAmount();
        }
        return balance;
    }
}
