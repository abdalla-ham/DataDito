-- PACKAGE table creation --
DROP TABLE PACKAGE IF EXISTS;

CREATE TABLE PACKAGE ( -- WHAT IS NULL AND WHAT IN NOT NULL --
PACKAGE_ID INTEGER NOT NULL PRIMARY KEY,
PACKAGE_NAME VARCHAR(200),
PRICE FLOAT, -- INTEGER OR FLOAT? --
AMOUNT_MINUTES INTEGER,
AMOUNT_DATA INTEGER, 
AMOUNT_SMS INTEGER,
PERIOD INTEGER
);

-- CUSTOMER table creation --
DROP TABLE CUSTOMER IF EXISTS;
CREATE TABLE CUSTOMER ( -- WHAT IS NULL AND WHAT IN NOT NULL --
CUST_ID INTEGER NOT NULL PRIMARY KEY,
MSISDN VARCHAR(15),
NAME VARCHAR(100),
SURNAME VARCHAR(100),
EMAIL VARCHAR(100),
PASSWORD VARCHAR(20),
SDATE TIMESTAMP,
TC_NO VARCHAR(20), -- ADDED IT SINCE IT'S A NECESSARY FOR CREATING AN ACCOUNT
--STATUS VARCHAR(2), -- IS IT REQUIRED? --
--SECURITY_KEY VARCHAR(200) -- IS IT REQUIRED? --
);

-- BALANCE table creation --
DROP TABLE BALANCE IF EXISTS;
CREATE TABLE BALANCE( -- WHAT IS NULL AND WHAT IN NOT NULL --
BALANCE_ID INTEGER NOT NULL PRIMARY KEY,
PACKAGE_ID INTEGER NOT NULL,
CUST_ID INTEGER NOT NULL,
PARTITION_ID INTEGER,
BAL_LVL_MINUTES INTEGER,
BAL_LVL_SMS INTEGER,
BAL_LVL_DATA INTEGER,
SDATE TIMESTAMP,
EDATE TIMESTAMP,
PRICE INTEGER, 
BAL_LVL_MONEY INTEGER, -- IS IT REQUIRED? --
FOREIGN KEY (CUST_ID) REFERENCES CUSTOMER(CUST_ID),
FOREIGN KEY (PACKAGE_ID) REFERENCES PACKAGE(PACKAGE_ID)
);
 
-- CHECK PERSONAL_USAGE AND NOTIFICATION_LOGS TABLES (ASK THE HOCA) --