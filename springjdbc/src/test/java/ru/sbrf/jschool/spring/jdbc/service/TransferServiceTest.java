package ru.sbrf.jschool.spring.jdbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import ru.sbrf.jschool.spring.jdbc.config.TestSpringConfig;
import ru.sbrf.jschool.spring.jdbc.dao.AccountDao;

import java.math.BigDecimal;

import static org.testng.Assert.*;

/**
 * Created by SBT-Pozdnyakov-AN on 30.07.2018.
 */
@ContextConfiguration(classes = TestSpringConfig.class)
public class TransferServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private TransferService transferService;

    @Autowired
    private AccountDao accountDao;

    @Test
    public void testTransfer(){
        try {
            transferService.transfer(1,2,new BigDecimal(300));
        }finally {
            System.out.println(accountDao.getAll());
        }


    }
}