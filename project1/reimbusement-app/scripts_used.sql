create table ERS_REIMBURSEMENT_STATUS(
	REIMB_STATUS_ID serial primary key, 
	REIMB_STATUS varchar(10) not null
);

create table public.ERS_REIMBURSEMENT_TYPE (
	REIMB_TYPE_ID serial primary key, 
	REIMB_TYPE varchar(10) not null
);

create table public.ERS_USER_ROLES (
	ERS_USER_ROLE_ID serial primary key, 
	USER_ROLE varchar(10) not null
);

create table public.ERS_USERS (
	ERS_USER_ID serial primary key,
	ERS_USERNAME varchar(50) not null unique, 
	ERS_PASSWORD varchar(50) not null, 
	USER_FIRST_NAME varchar(100) not null, 
	USER_LAST_NAME varchar(100) not null,
	USER_EMAIL varchar(150) not null unique,
	USER_ROLE_ID int not null, 
	foreign key (USER_ROLE_ID) references public.ERS_USER_ROLES(ERS_USER_ROLE_ID) on delete cascade 
);





create table public.ERS_REIMBURSEMENT (
	REIMB_ID serial primary key, 
	REIMB_AMOUNT numeric(6,2) not null,
	REIMB_SUBMITTED timestamp not null default now(), 
	REIMB_RESOLVED timestamp, 
	REIMB_DESCRIPTION varchar(250),
	REIMB_RECEIPT bytea, 
	REIMB_AUTHOR int not null, 
	REIMB_RESOLVER int not null, 
	REIMB_STATUS_ID int not null,
	REIMB_TYPE_ID int not null,
	foreign key (REIMB_AUTHOR) references public.ERS_USERS(ERS_USER_ID), 
	foreign key (REIMB_RESOLVER) references public.ERS_USERS(ERS_USER_ID), 
	foreign key (REIMB_STATUS_ID) references public.ERS_REIMBURSEMENT_STATUS(REIMB_STATUS_ID) on delete cascade,
	foreign key (REIMB_TYPE_ID) references public.ERS_REIMBURSEMENT_TYPE(REIMB_TYPE_ID) on delete cascade
);

-----------------inserts 
---todo; create query to insert into both users reimbursements 
---


----queries for user model
select * from public.ers_reimbursement 

select * from public.ers_users 


insert into public.ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id)
	values('ruben943', 'password123', 'Ruben', 'Garcia', 'rubengarcia0515@gmail.com', 1 );
	
insert into public.ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id)
	values('benEmployee', 'password', 'Ben', 'Garcia', 'garciarubenthe@gmail.com', 2 );

insert into public.ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id)
	values(?, ?, ?, ?, ?, ?);

select * from public.ers_users where ers_user_id = 2; 

select * from public.ers_users where ers_user_id = ?; 

update public.ers_users set ers_username = ? , ers_password = ? , user_first_name = ? , user_last_name = ?, user_email = ?, role_id = ? where ers_user_id = ? ; 

delete from public.ers_users where ers_user_id = ?; 

----queries for reimbursement models

delete from public.ers_reimbursement where reimb_id = ?; 

update public.ers_reimbursement  set reimb_amount = ?, reimb_submitted = ?,
reimb_resolved =?, reimb_description = ?, reimb_receipt = ?, reimb_author = ?, reimb_resolver=?, reimb_status_id = ?, reimb_type_id = ?
where reimb_id = ?; 

select * from public.ers_reimbursement 

insert into public.ers_reimbursement (reimb_amount, reimb_description, reimb_receipt, reimb_author, reimb_resolver, reimb_status_id,reimb_type_id )
values(?,?,?, ?,?,?,?);

select * from public.ers_reimbursement  where reimb_id = ?; 

select * from public.ers_reimbursement  where reimb_id = 2; 

insert into public.ers_reimbursement (reimb_amount, reimb_description, reimb_author, reimb_resolver, reimb_status_id,reimb_type_id )
values(200.23,'relocation to another state farther than 50 miles', 3,2,1,1);

insert into public.ers_reimbursement (reimb_amount, reimb_description, reimb_author, reimb_resolver, reimb_status_id,reimb_type_id )
values(3234.99,'food, living costs', 3,2,2,2);

select * from public.ers_users where ers_username ='tester'and ers_password = 'password'

select * from public.ers_users where ers_username = ? and ers_password = ? returning user_role_id ; 

select * from public.ers_users where ers_username = 'tester' and ers_password = 'password ' 

select public.ers_users.user_role_id from public.ers_users where ers_username='tester' 

select public.ers_users.user_role_id from public.ers_users where ers_username=?
































