CREATE DATABASE  IF NOT EXISTS `courses_web_app`;
USE `courses_web_app`;

DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `student`;
DROP TABLE IF EXISTS `course`;

create table `users` (
    username varchar(50) not null primary key,
    password varchar(120) not null,
    enabled boolean not null
);

create table `authorities` (
    username varchar(50) not null,
    authority varchar(50) not null,
    foreign key (username) references users (username)
);

create table `course`(
    `id` int(11) NOT NUll AUTO_INCREMENT,
    `name` varchar(45) DEFAULT NULL,
    `description` varchar(200) DEFAULT NULL,
    `instructor` varchar(45) DEFAULT NULL,
    `year` int(11) DEFAULT NULL,
    `semester` varchar(45) DEFAULT NULL,
    PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

create table `student`(
    `id` int(11) NOT NUll AUTO_INCREMENT,
    `first_name` varchar(45) DEFAULT NULL,
	`last_name` varchar(45) DEFAULT NULL,
    `course_id` int(11) DEFAULT NUll,
    `final_exam` int(11) default null,
    `project` int(11) default null,
    `year` int(11) default null,
    PRIMARY KEY (`id`),
    constraint `fk_course` foreign key (`course_id`) references `course` (`id`)
);

insert into users(username, password, enabled)values('zarras','{noop}zarras',true);
insert into authorities(username,authority)values('zarras','ROLE_ADMIN');

INSERT INTO `course` VALUES 
	(1,'Course_1','description','zarras',2022,'Summer'),
    (2,'Course_2','description','zarras',2022,'Summer');
    
insert into `student` values
	(1,'first_name_1','last_name_1',1,1,1,1),
	(2,'first_name_2','last_name_2',1,2,2,2),
    (3,'first_name_3','last_name_3',2,2,2,2);
