package ru.sbrf.jschool.spring.jdbc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
import ru.sbrf.jschool.spring.jdbc.model.Account;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by SBT-Pozdnyakov-AN on 30.07.2018.
 */
@Component
public class AccountDao {
    private DataSource dataSource;

    @Autowired
    public AccountDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Account> getAll() {
        final JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        final List<Account> resultList;
        resultList = jdbcTemplate.query("Select * from accounts", new AccountRowMapper());
        return resultList;
    }

    public Account getById(int i) {
        final JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Account account = jdbcTemplate.queryForObject(
                "Select * from accounts Where id=?",
                new AccountRowMapper(), i);
        System.out.println(account);
        return account;
    }

    public List<Account> getByAcceptor(AccountAcceptor acceptor) {
        final NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        SqlParameterSource params = new BeanPropertySqlParameterSource(acceptor);
        List<Account> accountList = jdbcTemplate.query(
                "Select * from accounts Where name=:name",
                params,
                new AccountRowMapper());
        System.out.println(accountList);
        return accountList;
    }

    public List<Account> getByParam(Map<String, Object> params) {
        final NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        SqlParameterSource paramSource = new MapSqlParameterSource(params);
        List<Account> accountList = jdbcTemplate.query(
                "Select * from accounts Where id=:id",
                params,
                new AccountRowMapper());
        System.out.println(accountList);
        return accountList;
    }

    public int createAccounts(final Account... accounts) {
        final JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        int[] updatedRows = jdbcTemplate.batchUpdate(
                "Insert INTO accounts(name, currency, balance) Values(?,?,?)",
                new BatchPreparedStatementSetter() {
                    public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                        preparedStatement.setString(1, accounts[i].getName());
                        preparedStatement.setString(2, accounts[i].getCurrency());
                        preparedStatement.setBigDecimal(3,accounts[i].getBalance());
                    }

                    public int getBatchSize() {
                        return accounts.length;
                    }
                });
        System.out.println("Updated rows "+updatedRows);
        int countRows = 0;
        for(int i:updatedRows){
            countRows+=i;
        }
        return countRows;
    }

    public int withdraw(Integer id, BigDecimal amount) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        int updateRows =  jdbcTemplate.update(
                "UPDATE accounts SET balance=balance-? WHERE id=?",
                amount,
                id);
        return updateRows;
    }

    public int deposit(Integer id, BigDecimal amount) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        int updateRows =  jdbcTemplate.update(
                "UPDATE accounts SET balance=balance+? WHERE id=?",
                amount,
                id);
        return updateRows;
    }

    private class AccountRowMapper implements RowMapper<Account> {
        public Account mapRow(ResultSet resultSet, int i) throws SQLException {
            Account account = new Account();
            account.setId(resultSet.getInt("id"));
            account.setBalance(resultSet.getBigDecimal("balance"));
            account.setCurrency(resultSet.getString("currency"));
            account.setName(resultSet.getString("name"));
            return account;
        }
    }
}
