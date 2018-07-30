package ru.sbrf.jschool.spring.jdbc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.sbrf.jschool.spring.jdbc.config.TestSpringConfig;
import ru.sbrf.jschool.spring.jdbc.model.Account;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ContextConfiguration(classes = TestSpringConfig.class)
public class AccountDaoTest extends AbstractTestNGSpringContextTests{

    @Autowired
    private AccountDao accountDao;

    @Test
    public void testGetAll(){
        List<Account> accountList=accountDao.getAll();
        Assert.assertNotNull(accountList);
    }

    @Test
    public void testGetById(){
        Account account = accountDao.getById(1);
        Assert.assertNotNull(account);
    }

    @Test
    public void testGetByAcceptor(){
        AccountAcceptor acceptor = new AccountAcceptor();
        acceptor.setName("VISA");
        List<Account> accounts = accountDao.getByAcceptor(acceptor);
        Assert.assertNotNull(accounts);
    }

    @Test
    public void testGetByParam(){
        Map<String,Object> params = new HashMap<String, Object>();
        params.put("id",1);
        List<Account> accounts = accountDao.getByParam(params);
        Assert.assertNotNull(accounts);
    }
    @Test
    public void TestWithdraw(){
        int rowsUpdated = accountDao.withdraw(Integer.valueOf(1), new BigDecimal(10));
        Assert.assertEquals(rowsUpdated, 1);
        Account account = accountDao.getById(1);
        Assert.assertEquals(account.getBalance(),new BigDecimal(2990));
    }

    @Test
    public void testDeposit(){
        int rowsUpdated = accountDao.deposit(Integer.valueOf(2), new BigDecimal(10));
        Assert.assertEquals(rowsUpdated, 1);
        Account account = accountDao.getById(2);
        Assert.assertEquals(account.getBalance(),new BigDecimal(1010));
    }

    @Test
    public void testCreateAccounts(){
        Account account = new Account();
        account.setName("Acc1");
        account.setCurrency("USD");
        account.setBalance(new BigDecimal(100500));

        Account account2 = new Account();
        account2.setName("Acc2");
        account2.setCurrency("USD");
        account2.setBalance(new BigDecimal(100));

        int countRows = accountDao.createAccounts(account, account2);
        Assert.assertEquals(countRows, 3);

        System.out.println(accountDao.getAll());
    }

}
