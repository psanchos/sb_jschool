CREATE TABLE IF NOT EXISTS accounts(
    id Integer AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    currency VARCHAR(3) NOT NULL,
    balance DECIMAL NOT NULL default 0
    );

INSERT INTO
    accounts(name,currency, balance)
VALUES
    ('VISA', 'RUB', 3000),
    ('MASTER', 'RUB', 1000);