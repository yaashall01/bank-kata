package com.yassinechalh.bankkata.infrastructure;

import com.yassinechalh.bankkata.domain.DateProvider;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Yassine CHALH
 */
public class SysDateProvider implements DateProvider {

    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public String today() {
        return LocalDate.now().format(FORMAT);
    }
}