USER toeiconline

create table role (
		roleid bigint not null PRIMARY KEY auto_increment,
    name varchar (100)
);

CREATE TABLE user (
      userid bigint not null PRIMARY KEY auto_increment,
      name VARCHAR (255) null,
      password VARCHAR (255) ,
      fullname VARCHAR (300) null,
      createdate TIMESTAMP null,
      roleid bigint not null,
      FOREIGN KEY (roleid) REFERENCES role(roleid)
);

CREATE TABLE listenguideline (
      listenguidelineid bigint not null PRIMARY KEY auto_increment,
      title VARCHAR (512) null,
      image VARCHAR (255) NULL ,
      content text NULL ,
      createdate TIMESTAMP null,
      modifieddate TIMESTAMP null
);

CREATE TABLE comment (
      commentid bigint not null PRIMARY KEY auto_increment,
      content text NULL ,
      createdate TIMESTAMP null,
      userid bigint not null,
      listenguidelineid bigint not null,
      FOREIGN KEY (userid) REFERENCES user(userid),
      FOREIGN KEY (listenguidelineid) REFERENCES listenguideline(listenguidelineid)
);
INSERT INTO user( name, password, fullname, createdate, roleid) VALUES ('hung','abcd','vo van hung',CURRENT_TIMESTAMP(),2)

SELECT * FROM user



















