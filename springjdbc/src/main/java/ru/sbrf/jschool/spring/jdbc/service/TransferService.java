package ru.sbrf.jschool.spring.jdbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import ru.sbrf.jschool.spring.jdbc.dao.AccountDao;

import java.math.BigDecimal;

@Component
public class TransferService {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Transactional
    public void transfer(final int accountFromId, final int accountToId, final BigDecimal amount) {
        accountDao.withdraw(accountFromId, amount);
        boolean debug = true;
        if (debug) {
            throw new RuntimeException("Some terrible error");
        }
        accountDao.deposit(accountToId, amount);
    }
}
