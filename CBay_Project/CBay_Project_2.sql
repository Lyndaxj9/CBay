CREATE USER cbayconnect
IDENTIFIED BY cbayconnectpassword;

GRANT DBA TO cbayconnect;

DROP TABLE MESSAGE;
DROP TABLE THREADS;
DROP TABLE IMAGE;
DROP TABLE SELLERRATING;
DROP TABLE ITEMRATING;
DROP TABLE TRANSACTIONS;
DROP TABLE ORDERS;
DROP TABLE ITEM;
DROP TABLE CLIENT;


CREATE TABLE CLIENT
(
    UserID NUMBER(6) NOT NULL,
    FirstName VARCHAR2(20) NOT NULL,
    LastName VARCHAR2(20) NOT NULL,
    UserType VARCHAR2(30) NOT NULL,
    UserName VARCHAR2(24) UNIQUE,
    PW VARCHAR2(60) NOT NULL,
    Email VARCHAR2(60) UNIQUE,
    RatingAvg NUMBER(6),
    Description VARCHAR2(200),
    CONSTRAINT PK_USER PRIMARY KEY  (UserID)
);

CREATE TABLE ITEM
(
    ItemID NUMBER(6) NOT NULL,
    UserID NUMBER(6) NOT NULL,
    ItemName VARCHAR2(20) NOT NULL,
    Description VARCHAR2(20) NOT NULL,
    Price NUMBER(6),
    RatingAvg NUMBER(5),
    CONSTRAINT PK_ITEM PRIMARY KEY  (ItemID),
    CONSTRAINT FK_OWNER FOREIGN KEY (UserID) 
    REFERENCES CLIENT (UserID)  ON DELETE CASCADE
    
);

CREATE TABLE ORDERS
(
    OrderID NUMBER(6) NOT NULL,
    BuyerID NUMBER(6) NOT NULL,
    Status VARCHAR2(20) NOT NULL,
    TotalItems NUMBER (4) NOT NULL,
    OrderTimeStamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT PK_ORDER PRIMARY KEY  (ORDERID),
    CONSTRAINT FK_BUYER_IN_ORDER FOREIGN KEY (BuyerID) 
    REFERENCES CLIENT (UserID)  ON DELETE CASCADE
);

CREATE TABLE TRANSACTIONS
(
    TransactionID NUMBER(6) NOT NULL,
    OrderID NUMBER(6),
    ItemID NUMBER(6) NOT NULL,
    BuyerID NUMBER(6) NOT NULL,
    SellerID NUMBER(6) NOT NULL,
    Status VARCHAR2(20) NOT NULL,
    Quantity NUMBER(4) NOT NULL,
    CONSTRAINT PK_TRANSACTION PRIMARY KEY  (TransactionID),
    CONSTRAINT FK_ITEM_IN_TRANSACTION FOREIGN KEY (ItemID) 
    REFERENCES ITEM (ItemID)  ON DELETE CASCADE,
    CONSTRAINT FK_ORDER_IN_TRANSACTION FOREIGN KEY (OrderID) 
    REFERENCES ORDERS (OrderID)  ON DELETE CASCADE,
    CONSTRAINT FK_BUYER_IN_TRANSACTION FOREIGN KEY (BuyerID) 
    REFERENCES CLIENT (UserID)  ON DELETE CASCADE,
    CONSTRAINT FK_SELLER_IN_TRANSACTION FOREIGN KEY (SellerID) 
    REFERENCES CLIENT (UserID)  ON DELETE CASCADE
);

CREATE TABLE ITEMRATING
(
    RatingID NUMBER(9) NOT NULL,
    ItemID NUMBER(9) NOT NULL,
    TextRating VARCHAR2(240),
    NumRating NUMBER(6),
    RatingTimeStamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT PK_RATING_ITEM PRIMARY KEY  (RatingID),
    CONSTRAINT FK_ITEM_IN_RATING FOREIGN KEY (ItemID) 
    REFERENCES ITEM (ItemID)  ON DELETE CASCADE
    
);

CREATE TABLE SELLERRATING
(
    RatingID NUMBER(9) NOT NULL,
    UserID NUMBER(9) NOT NULL,
    TextRating VARCHAR2(240),
    NumRating NUMBER(6),
    RatingTimeStamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT PK_RATING_SELLER PRIMARY KEY  (RatingID),
    CONSTRAINT FK_SELLER_IN_RATING FOREIGN KEY (UserID) 
    REFERENCES CLIENT (UserID)  ON DELETE CASCADE
    
);

CREATE TABLE THREADS
(
    ThreadID NUMBER(4) NOT NULL,
    SenderID NUMBER(6) NOT NULL,
    ResponderID NUMBER(6) NOT NULL,
    ThreadTimeStamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT PK_THREAD PRIMARY KEY  (ThreadID),
    CONSTRAINT FK_SENDER_IN_THREAD FOREIGN KEY (SenderID) 
    REFERENCES CLIENT (UserID)  ON DELETE CASCADE,
    CONSTRAINT FK_RESPONDER_IN_THREAD FOREIGN KEY (ResponderID) 
    REFERENCES CLIENT (UserID)  ON DELETE CASCADE
    
);

CREATE TABLE MESSAGE
(
    MessageID NUMBER(6) NOT NULL,
    ThreadID NUMBER(4) NOT NULL,
    TransactionID NUMBER(6) NOT NULL,
    SenderID NUMBER(6) NOT NULL,
    ResponderID NUMBER(6) NOT NULL,
    MessageContent VARCHAR2(240),
    Subject VARCHAR2(100),
    MessageTimeStamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT PK_MESSAGE PRIMARY KEY  (MessageID),
    CONSTRAINT FK_THREAD_IN_MESSAGE FOREIGN KEY (ThreadID) 
    REFERENCES THREADS (ThreadID)  ON DELETE CASCADE,
    CONSTRAINT FK_TRANSACTION_IN_MESSAGE FOREIGN KEY (TransactionID) 
    REFERENCES TRANSACTIONS (TransactionID)  ON DELETE CASCADE,
    CONSTRAINT FK_SENDER_IN_MESSAGE FOREIGN KEY (SenderID) 
    REFERENCES CLIENT (UserID)  ON DELETE CASCADE,
    CONSTRAINT FK_RESPONDER_IN_MESSAGE FOREIGN KEY (ResponderID) 
    REFERENCES CLIENT (UserID)  ON DELETE CASCADE
    
);

CREATE TABLE IMAGE
(
    ImageID NUMBER(6) NOT NULL,
    ItemID NUMBER(6) NOT NULL,
    Image Blob,
    FileName VARCHAR2(300) NOT NULL,
    CONSTRAINT PK_IMAGE PRIMARY KEY  (ImageID),
    CONSTRAINT FK_ITEM_IN_IMAGE FOREIGN KEY (ItemID) 
    REFERENCES ITEM (ItemID)  ON DELETE CASCADE
);



-----------------------------------------------------------------------------------------------


DROP SEQUENCE USER_ID_SEQ;
CREATE SEQUENCE USER_ID_SEQ
    start with 10000
    increment by 1;


DROP SEQUENCE ITEM_ID_SEQ;
CREATE SEQUENCE ITEM_ID_SEQ
    start with 20000
    increment by 1;

DROP SEQUENCE TRANS_ID_SEQ;
CREATE SEQUENCE TRANS_ID_SEQ
    start with 30000
    increment by 1;

DROP SEQUENCE ORDER_ID_SEQ;
CREATE SEQUENCE ORDER_ID_SEQ
    start with 40000
    increment by 1;

DROP SEQUENCE MESSAGE_ID_SEQ;
CREATE SEQUENCE MESSAGE_ID_SEQ
    start with 50000
    increment by 1;
    
DROP SEQUENCE THREAD_ID_SEQ;
CREATE SEQUENCE THREAD_ID_SEQ
    start with 1000
    increment by 1;

DROP SEQUENCE IMAGE_ID_SEQ;
CREATE SEQUENCE IMAGE_ID_SEQ
    start with 70000
    increment by 1;
    
DROP SEQUENCE SELLER_RATING_ID_SEQ;
CREATE SEQUENCE SELLER_RATING_ID_SEQ
    start with 80000
    increment by 1;
    
DROP SEQUENCE ITEM_RATING_ID_SEQ;
CREATE SEQUENCE ITEM_RATING_ID_SEQ
    start with 80000
    increment by 1;
    
commit;

delete from CLIENT WHERE UserId = 10124;
delete from CLIENT WHERE UserId = 10122;



select * from CLIENT;
select * from THREADS;
select * from ITEM;
select * from IMAGE;
select * from ITEMRATING;
select * from SELLERRATING;
select * from TRANSACTIONS;



ALTER TABLE CLIENT
MODIFY RatingAvg NUMBER(*,2);

ALTER TABLE CLIENT
MODIFY Description VARCHAR2(1000);

ALTER TABLE CLIENT
ADD Approval VARCHAR2(20);

ALTER TABLE TRANSACTIONS
ADD Quantity NUMBER(4);

--ALTER TABLE ITEM
--DROP COLUMN QUANTITY;
DELETE FROM CLIENT;

ALTER TABLE ITEM
MODIFY Price NUMBER(9,2);

--Update CLIENT set RatingAvg = 0 Where UserId = 10000;

Select * FROM TRANSACTIONS SellerID = 1000 AND Status != 'In-Cart';

--select USER_ID_SEQ.nextval from dual;
