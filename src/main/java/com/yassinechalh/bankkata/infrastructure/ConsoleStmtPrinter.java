package com.yassinechalh.bankkata.infrastructure;

import com.yassinechalh.bankkata.service.StatementPrinter;

/**
 * @author Yassine CHALH
 */
public class ConsoleStmtPrinter implements StatementPrinter {

    @Override
    public void print(String statement) {
        System.out.println(statement);
    }
}
