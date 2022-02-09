create table tbl_profiles(
	idProfile int primary key auto_increment,
	profile varchar(20) not null
);

create table tbl_users(
	idUser int primary key auto_increment,
	userName varchar(20) not null,
	password varchar(30) not null,
	status enum('up', 'down') not null,
	createdDate date not null,
	updateDate date not null,
	login enum('yes', 'no') not null,
	idProfile int not null,
	foreign key(idProfile) references tbl_profiles(idProfile) on delete CASCADE
);

insert into tbl_profiles values(1, "user");
insert into tbl_profiles values(2, "admin");

insert into tbl_users values(1, "andre123", "pass123", "up", "2022-02-08", "2022-02-09", "no", 1);
insert into tbl_users values(2, "admin", "admin123", "up", "2022-02-08", "2022-02-09", "yes", 2);