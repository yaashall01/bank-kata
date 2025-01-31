package com.yassinechalh.bankkata;

import com.yassinechalh.bankkata.domain.DateProvider;
import com.yassinechalh.bankkata.domain.TransactionRepository;
import com.yassinechalh.bankkata.infrastructure.ConsoleStmtPrinter;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

/** test d'acceptation pour assurer le resultat attendu (TDD)
 * @author Yassine CHALH
 */
class AccountAcceptanceTest {

    @Test
    void should_print_correct_stmt_after_deposits_and_withdrawal() {

        // mocking data
        DateProvider dateProvider = mock(DateProvider.class);
        when(dateProvider.today())
                .thenReturn("10-01-2012")
                .thenReturn("13-01-2012")
                .thenReturn("14-01-2012");

        TransactionRepository repository = new TransactionRepository(dateProvider);
        ConsoleStmtPrinter printer = spy(new ConsoleStmtPrinter());

        AccountService account = new Account(repository, printer);

        account.deposit(1000);   // date le 10-01-2012
        account.deposit(2000);   //13-01-2012
        account.withdraw(500);   // 14-01-2012
        account.printStatement();

        // verification final
        verify(printer).print(
                "Date       || Amount || Balance\n" +
                        "14-01-2012 || -500   || 2500\n" +
                        "13-01-2012 || 2000   || 3000\n" +
                        "10-01-2012 || 1000   || 1000\n"
        );
    }
}
