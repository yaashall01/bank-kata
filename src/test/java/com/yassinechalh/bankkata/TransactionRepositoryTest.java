package com.yassinechalh.bankkata;

import com.yassinechalh.bankkata.domain.DateProvider;
import com.yassinechalh.bankkata.domain.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/** Les test unitaires ::: TDD
 * @author Yassine CHALH
 */
public class TransactionRepositoryTest {

    private DateProvider dateProvider;
    private TransactionRepository repository;

    @BeforeEach
    void setup() {
        dateProvider = Mockito.mock(DateProvider.class);
        repository = new TransactionRepository(dateProvider);
    }

    @Test
    void should_add_deposit_with_correct_date() {
        when(dateProvider.today()).thenReturn("10-01-2012");

        repository.addDeposit(1000);
        String statement = repository.generateStatement();

        String expected =
                "Date       || Amount || Balance\n" +
                        "10-01-2012 || 1000   || 1000\n";

        assertEquals(expected, statement);
    }

    @Test
    void should_add_withdrawall_with_correct_date() {
        when(dateProvider.today()).thenReturn("14-01-2012");

        repository.addWithdrawal(500);
        String statement = repository.generateStatement();

        String expected =
                "Date       || Amount || Balance\n" +
                        "14-01-2012 || -500   || -500\n";

        assertEquals(expected, statement);
    }

    @Test
    void should_generate_stmt_desc_order() {
        when(dateProvider.today())
                .thenReturn("10-01-2012")
                .thenReturn("13-01-2012")
                .thenReturn("14-01-2012");

        repository.addDeposit(1000);
        repository.addDeposit(2000);
        repository.addWithdrawal(500);

        String expected =
                "Date       || Amount || Balance\n" +
                        "14-01-2012 || -500   || 2500\n" +
                        "13-01-2012 || 2000   || 3000\n" +
                        "10-01-2012 || 1000   || 1000\n";

        assertEquals(expected, repository.generateStatement());
    }
}
