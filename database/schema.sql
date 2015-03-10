create table account(
                      accountid int(11) NOT NULL AUTO_INCREMENT,
                      username varchar(50) NOT NULL,
                      password varchar(50) NOT NULL,
                      balance decimal(20,0) NOT NULL,
                      status int(4) NOT NULL,
                      PRIMARY KEY(accountid)
);

create table admin(
                      id int(11) NOT NULL AUTO_INCREMENT,
                      username varchar(50) NOT NULL,
                      pwd varchar(50) NOT NULL,
                      PRIMARY KEY(id)
);

create table personinfo(
                      id int(11) NOT NULL AUTO_INCREMENT,
                      accountid int(50) NOT NULL, 
                      realname varchar(50) NOT NULL,
                      age int(20) NOT NULL,
                      sex char(4) NOT NULL,
                      cardid decimal(18,0) NOT NULL,
                      address varchar(50) NOT NULL,
                      telehpone varchar(50) NULL,   
                      PRIMARY KEY(id),
                      FOREIGN KEY(accountid) REFERENCES account(accountid)
);

create table status(
                      id int(11) NOT NULL AUTO_INCREMENT,
                      name varchar(50) NOT NULL,
                      PRIMARY KEY(id)
);

create table transaction_log(
                      id int(11) NOT NULL AUTO_INCREMENT,
                      accountid int(11) NOT NULL, 
                      otherid int(11) NOT NULL,
                      tr_money decimal(18,0) NOT NULL,
                      datetime varchar(50) NOT NULL,
                      ta_type int(11) NOT NULL,  
                      PRIMARY KEY(id)
);

create table transaction_type(
                      id int(11) NOT NULL AUTO_INCREMENT,
                      name varchar(50) NOT NULL,
                      PRIMARY KEY(id)
);
