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
	availables int not null,
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

insert into tbl_class values(1,"KTPM01","Kỹ thuật phần mềm 01");
insert into tbl_class values(2,"KTPM02","Kỹ thuật phần mềm 02");
insert into tbl_class values(3,"KTPM03","Kỹ thuật phần mềm 03");
insert into tbl_class values(4,"KTPM04","Kỹ thuật phần mềm 04");

insert into tbl_account values(2,"GV01","GV01","Tài khoản giáo viên");
insert into tbl_account values(3,"GV02","GV02","Tài khoản giáo viên");
insert into tbl_account values(4,"SV01","SV01","Tài khoản sinh viên");
insert into tbl_account values(5,"SV02","SV02","Tài khoản sinh viên");
insert into tbl_account values(6,"SV03","SV03","Tài khoản sinh viên");
insert into tbl_account values(7,"SV04","SV04","Tài khoản sinh viên");
insert into tbl_account values(8,"SV05","SV05","Tài khoản sinh viên");
insert into tbl_account values(9,"SV06","SV06","Tài khoản sinh viên");
insert into tbl_account values(10,"SV07","SV07","Tài khoản sinh viên");

insert into tbl_teacher values(2,"GV01","Lan","Nguyễn Thị","20/04/1999","Hà Nội","0123456789","src\\images\\user.png","lan@gmail.com",2);
insert into tbl_teacher values(3,"GV02","Lan","Trần Thị","15/04/1997","Hà Nội","0123456789","src\\images\\user.png","lantran@gmail.com",3);

insert into tbl_student values(4,"SV01","Tuệ","Nguyễn Tài","15/04/2003","Hà Nội","0383291503","nttue@gmail.com","src\\images\\user.png",4,3);
insert into tbl_student values(5,"SV02","Tuấn","Nguyễn Trọng","10/06/2003","Hà Tĩnh","0383291503","tuan@gmail.com","src\\images\\user.png",5,3);
insert into tbl_student values(6,"SV03","Tuấn","Nguyễn Văn","10/06/2003","Hà Nội","0383291503","tuanvan@gmail.com","src\\images\\user.png",6,3);
insert into tbl_student values(7,"SV04","Văn","Đào Ngọc","05/04/2003","Hưng Yên","0383291503","van@gmail.com","src\\images\\user.png",7,3);
insert into tbl_student values(8,"SV05","Anh","Lê Ngọc","05/05/2003","Hưng Yên","0383291503","anh@gmail.com","src\\images\\user.png",8,4);
insert into tbl_student values(9,"SV06","Liễu","Phạm Thị","10/04/2003","Hà Nam","0383291503","lieu@gmail.com","src\\images\\user.png",9,4);
insert into tbl_student values(10,"SV07","Hiệp","Đào Ngọc","10/10/2003","Hưng Yên","123456789","hiep@gmail.com","src\\images\\user.png",10,4);

insert into tbl_company values(1,"DN01","SamSung","Không có","samsung@gmail.com","123456789","Hàn Quốc");
insert into tbl_company values(2,"DN02","Viettel","Không có","viettel@gmail.com","123456789","Hà Nội");
insert into tbl_company values(3,"DN03","VinFast","Không có","vin@gmail.com","123456789","Hà Nội");

Insert into tbl_tour values(1,"TQ01","Tham quan SamSung","Không có","10/12/2024",1,2,"Nguyễn Văn A",60);
Insert into tbl_tour values(2,"TQ02","Tham quan Viettel","Không có","20/12/2024",2,2,"Nguyễn Văn B",80);
Insert into tbl_tour values(3,"TQ03","Tham quan VinFast","Không có","25/12/2024",3,3,"Nguyễn Văn C",60);

INSERT INTO tbl_student_tour VALUES (4,1,0);
INSERT INTO tbl_student_tour VALUES (4,2,0);
INSERT INTO tbl_student_tour VALUES (4,3,0);
INSERT INTO tbl_student_tour VALUES (5,1,0);
INSERT INTO tbl_student_tour VALUES (5,2,0);
INSERT INTO tbl_student_tour VALUES (6,1,0);
INSERT INTO tbl_student_tour VALUES (7,1,0);
