--테이블생성하기
create table book
(isbn number(20) not null,
book_name varchar(20),
writer varchar(20),
publisher varchar(20),
total_page number(10),
keyword varchar(20),
CONSTRAINT book_PK PRIMARY KEY (isbn)
);

create table members
(member_id varchar(20) not null,
member_pw varchar(20),
phone_number varchar(20),
email varchar(20),
name varchar(20),
grape number,
keyword_1 varchar(20),
keyword_2 varchar(20),
keyword_3 varchar(20),
CONSTRAINT members_PK PRIMARY KEY (member_id)

);

create table book_diary (
	diary_no number not null,
	isbn number(20) not null,
	start_date date default sysdate,
	recent_date date default sysdate, 
	finish_date varchar(20),
	rate number,
	review varchar(30),
	progress number,
	diary_like number,
	member_id varchar(20) not null,
	CONSTRAINT book_diary_fk_id FOREIGN KEY (member_id)
	REFERENCES members(member_id),
	CONSTRAINT book_diary_pk PRIMARY KEY(diary_no),
	CONSTRAINT book_diary_fk_isbn FOREIGN KEY (isbn)
	REFERENCES book(isbn)
);


CREATE SEQUENCE daily_book_diary_seq
     START WITH 1
     INCREMENT BY 1
     MAXVALUE 10000;

CREATE TABLE daily_book_diary(
daily_diary_no number not null,
diary_no number not null,
reporting_date date,
content varchar(40),
CONSTRAINT daily_book_diary_pk PRIMARY KEY(daily_diary_no),
CONSTRAINT daily_book_diary_fk FOREIGN KEY(diary_no)
REFERENCES book_diary(diary_no)
);


CREATE SEQUENCE friends_seq
START WITH 1
     INCREMENT BY 1
     MAXVALUE 10000;
     
CREATE TABLE friends(
freind_no number not null,
member_id varchar(20) not null,
freind_id varchar(20),
CONSTRAINT friends_member_fk FOREIGN KEY(member_id)
REFERENCES members(member_id),
CONSTRAINT friends_friend_fk FOREIGN KEY(freind_id)
REFERENCES members(member_id)
);

CREATE TABLE guest_board(
guest_board_no number not null,
member_id varchar(20) not null,
friend varchar(20) not null,
contents varchar(40) not null, 
b_date date not null,
CONSTRAINT guest_board_no_pk PRIMARY KEY(guest_board_no),
CONSTRAINT guest_board_member_fk FOREIGN KEY(member_id)
REFERENCES members(member_id)
);

CREATE TABLE wishlist(
wishlist_no number not null,
isbn number not null,
member_id not null,
add_date date not null,
CONSTRAINT wishlist_no_pk PRIMARY KEY(wishlist_no),
CONSTRAINT wishlist_member_fk FOREIGN KEY(member_id)
REFERENCES members(member_id),
CONSTRAINT wishlist_isbn_fk FOREIGN KEY(isbn)
REFERENCES book(isbn)
);

select * from DAILY_BOOK_DIARY;



select * from MEMBERS;

select * from book;

select * from book_diary;

select isbn from book where book_name = '어린왕자';

insert into daily_book_diary values(daily_book_diary_seq.nextval, 21, sysdate,'대박..');

select * from book_diary where member_id = 'test';

update BOOK_DIARY set recent_date = sysdate, rate = 8 where diary_no = 21;
select * from book_diary where isbn = 9791187192596 and review is not null

select * from book_diary where diary_no = 21;

insert into daily_book_diary values(daily_book_diary_seq.nextval, 21, sysdate,'극혐');

select * from book_diary where diary_no = 21;

select * from user_sequences;
update BOOK_DIARY set recent_date = sysdate, rate = 92 where diary_no = 21;

--insert into book_diary values(book_diary_seq.nextval,456789,)
select * from book_diary where member_id = 'test' and progress < 100
select * from members;

select f.friend_id, m.name from members m , friends f where f.friend_id = m.member_id and f.member_id = 'test'

select * from book_diary;
select * from friends;

delete from friends where member_id='jangjin'
commit
select * from book_diary where isbn = 1 and review is not null;

--friend name 을 가져오고 싶은ㄷㅔ friend name 은 회원테이블에 name 이 있음
select * from book_diary where isbn = 9791162205044 and review is not null;
CREATE SEQUENCE wishlist_SEQ
     START WITH 1
     INCREMENT BY 1
     MAXVALUE 10000;
     
     CREATE SEQUENCE BOOK_DIARY_SEQ
     START WITH 1
     INCREMENT BY 1
     MAXVALUE 10000;
     
 select * from book_diary where member_id = 'test' and progress < 100 order by diary_no desc    
     
Select b.book_name from book b, BOOK_DIARY d where d.isbn = b.isbn
AND d.diary_no = 21;
insert into book_diary (diary_no,isbn,start_date,member_id) values(book_diary_seq.nextval,1,sysdate,test);
select * from book_diary;
insert into book values(410,'나는 똑똑해','미친놈','민음사',243,'로맨스');
insert into book values(420,'나는 똑똑해','덜미친놈','바보',243,'로맨스');
commit

select * from book_diary

insert into book_diary (diary_no,isbn,start_date,finish_date,member_id) values(book_diary_seq.nextval,1,sysdate,'20210502','test')

select isbn from book ;