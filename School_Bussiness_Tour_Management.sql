CREATE DATABASE Bussiness_Tour_Management;
USE Bussiness_Tour_Management;

CREATE TABLE tbl_account(
	id int primary key auto_increment,
	username nvarchar(255) not null,
	password nvarchar(255) not null,
	role nvarchar(255) not null
);

CREATE TABLE tbl_class(
	id int primary key auto_increment,
	code nvarchar(255) not null,
	name nvarchar(255) not null
);

CREATE TABLE tbl_student(
	id int primary key auto_increment,
	code nvarchar(255) not null,
	firstName nvarchar(255) not null,
	lastName nvarchar(255) not null,
	birthDate varchar(255) not null,
	address nvarchar(255) not null,
	phoneNumber nvarchar(255) not null,
	email nvarchar(255) not null,
    imagePath nvarchar(255) not null,
    accountId int not null,
	classId int not null,
	foreign key (classId) references tbl_class(id) On DELETE CASCADE,
    foreign key (accountId) references tbl_account(id) On DELETE CASCADE 
);

CREATE TABLE tbl_company(
	id int primary key auto_increment,
	code nvarchar(255) not null,
	name nvarchar(255) not null,
	description nvarchar(255) not null,
	email nvarchar(255) not null,
	phoneNumber nvarchar(255) not null,
	address nvarchar(255) not null
);

CREATE TABLE tbl_teacher(
    id int primary key auto_increment,
    code nvarchar(255) not null, 
    firstName nvarchar(255) not null,
    lastName nvarchar(255) not null, 
    birthDate varchar(255) not null,
    address nvarchar(255) not null,
    phoneNumber nvarchar(255) not null,
    imagePath nvarchar(255) not null,
    email nvarchar(255) not null,
    accountId int not null,
    foreign key (accountId) references tbl_account(id) On DELETE CASCADE
);

CREATE TABLE tbl_tour(
	id int primary key auto_increment,
	code nvarchar(255) not null,
	name nvarchar(255) not null,
	description nvarchar(255) not null,
	startDate nvarchar(255) not null,
	companyId int not null,
	teacherId int,
	presentator nvarchar(255) not null,
	avaliables int not null,
	Foreign key (companyId) references tbl_company(id) On DELETE CASCADE,
	Foreign key (teacherId) references tbl_teacher(id) On DELETE CASCADE
);

CREATE TABLE tbl_student_tour(
	studentId int not null,
	tourId int not null,
	rate float not null,
	Foreign key (studentId) references tbl_student(id) On DELETE CASCADE,
	Foreign key (tourId) references tbl_tour(id) On DELETE CASCADE
);

insert into tbl_account values(1,"admin","1","Toàn quyền hệ thống");



