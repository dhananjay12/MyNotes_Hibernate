CREATE TABLE `customer` (
  `name` varchar(100) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `phone` varchar(100) NOT NULL,
  `active` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8


INSERT INTO `customer` (`name`,`age`,`phone`,`active`) VALUES ("Jack",31,"(09) 6131 9120",0),("Shaine",48,"(03) 4792 7932",1),("Quincy",38,"(07) 4610 5525",1),("Henry",40,"(02) 1821 3844",1),("Leslie",24,"(04) 2822 5137",0),("Darius",23,"(05) 0142 7083",1),("Neru",33,"(05) 0160 8025",1),("Rhoda",45,"(01) 3785 4950",0),("Lynn",35,"(06) 3612 3167",0),("Mark",32,"(08) 8146 8339",0);



create user testdb with password 'testdb';
grant all privileges on database testdb to testdb;

DROP USER testdb;


CREATE TABLE customer (
  name varchar(100) DEFAULT NULL,
  age int DEFAULT NULL,
  phone varchar(100) NOT NULL,
  active smallint DEFAULT NULL,
  PRIMARY KEY (phone)
) 



INSERT INTO customer (name,age,phone,active) VALUES ('Jack',31,'(09) 6131 9120',0),('Shaine',48,'(03) 4792 7932',1),('Quincy',38,'(07) 4610 5525',1),('Henry',40,'(02) 1821 3844',1),('Leslie',24,'(04) 2822 5137',0),('Darius',23,'(05) 0142 7083',1),('Neru',33,'(05) 0160 8025',1),('Rhoda',45,'(01) 3785 4950',0),('Lynn',35,'(06) 3612 3167',0),('Mark',32,'(08) 8146 8339',0);



