package com.yassinechalh.bankkata;

import com.yassinechalh.bankkata.domain.TransactionRepository;
import com.yassinechalh.bankkata.service.StatementPrinter;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

/** Les test unitaires ::: TDD
 *
 * @author Yassine CHALH
 */
public class AccountTest {

    @Test
    void deposit_should_call_repo_addDeposit() {
        TransactionRepository repository = mock(TransactionRepository.class);
        StatementPrinter printer = mock(StatementPrinter.class);

        AccountService account = new Account(repository, printer);

        account.deposit(1000);

        verify(repository).addDeposit(1000);
    }

    @Test
    void withdraw_should_call_repo_addWithdrawal() {
        TransactionRepository repository = mock(TransactionRepository.class);
        StatementPrinter printer = mock(StatementPrinter.class);

        AccountService account = new Account(repository, printer);

        account.withdraw(500);

        verify(repository).addWithdrawal(500);
    }

    @Test
    void printStatement_should_call_generateStmt_and_print() {
        TransactionRepository repository = mock(TransactionRepository.class);
        StatementPrinter printer = mock(StatementPrinter.class);

        when(repository.generateStatement()).thenReturn("je test le print stmt");

        AccountService account = new Account(repository, printer);

        account.printStatement();

        verify(repository).generateStatement();
        verify(printer).print("je test le print stmt");
    }
}
