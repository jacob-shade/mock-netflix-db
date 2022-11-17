/* Entities */

drop table Members cascade constraint;
drop table Credit_Card cascade constraint;
drop table Profiles cascade constraint;
drop table Genre cascade constraint;
drop table Movie cascade constraint;
drop table Actor_Actress cascade constraint;

/* Relations */

drop table Has_Movie_Genre cascade constraint;
drop table Has_Favorite cascade constraint;
drop table Viewing_History cascade constraint;
drop table Movie_Cast cascade constraint;

/********** Entities **********/

create table Members(
    Member_ID   varchar2(10),
	first_name  varchar2(20) NOT NULL,
    last_name   varchar2(20)NOT NULL,
    primary key(Member_ID)
);

insert into Members values ('dsmith', 'David', 'Smith');
insert into Members values ('ktran', 'Kevin', 'Tran');
insert into Members values ('awayne', 'Alex', 'Wayne');
insert into Members values ('jlynn', 'Joanne', 'Lynn');
insert into Members values ('cwang', 'Christine', 'Wang');
insert into Members values ('bnelson', 'Bob', 'Nelson');

create table Credit_Card(
    Member_ID       varchar2(10),
    Card_Number     varchar2(16),
    Card_Month      varchar(2)NOT NULL,
    Card_Year       varchar(4) NOT NULL,
    CCV             varchar2(3)NOT NULL,
    Card_Type       varchar2(16)NOT NULL,
    primary key(Member_ID, Card_Number),
    foreign key(Member_ID) references Members
    ON DELETE CASCADE
);

insert into Credit_Card values ('dsmith', '1234567890123456', '08', '2021', '123', 'Visa');
insert into Credit_Card values ('ktran', '0328362748193725', '09', '2022', '487', 'Master Card');
insert into Credit_Card values ('awayne', '3859264735274937', '04', '2023', '225', 'Visa');
insert into Credit_Card values ('jlynn', '8361092833749572', '01', '2022', '019', 'American Express');
insert into Credit_Card values ('cwang', '9563882104628530', '07', '2023', '378', 'Visa');
insert into Credit_Card values ('bnelson', '1188362037455782', '10', '2024', '243', 'Visa');

create table Profiles(
    Member_ID       varchar2(10) NOT NULL,
    Profile_Name    varchar2(10) NOT NULL,
    primary key(Member_ID, Profile_Name),
    foreign key(Member_ID) references Members
    ON DELETE CASCADE
);

insert into Profiles values ('dsmith', 'Dave');
insert into Profiles values ('dsmith', 'Devin');
insert into Profiles values ('ktran', 'Kev');
insert into Profiles values ('ktran', 'Kaylee');
insert into Profiles values ('awayne', 'Alexis');
insert into Profiles values ('awayne', 'Ariana');
insert into Profiles values ('jlynn', 'Jo');
insert into Profiles values ('jlynn', 'John');
insert into Profiles values ('cwang', 'Christy');
insert into Profiles values ('cwang', 'Christian');
insert into Profiles values ('bnelson', 'Bobby');
insert into Profiles values ('bnelson', 'Bransford');

create table Genre(
    Genre_ID    varchar2(10),
    Genre_Name  varchar2(10) NOT NULL,
    primary key(Genre_ID)
);

insert into Genre values ('0000000001', 'Drama');
insert into Genre values ('0000000002', 'Crime');
insert into Genre values ('0000000003', 'Action');
insert into Genre values ('0000000004', 'Thriller');
insert into Genre values ('0000000005', 'Biography');
insert into Genre values ('0000000006', 'History');
insert into Genre values ('0000000007', 'Adventure');
insert into Genre values ('0000000008', 'Fantasy');
insert into Genre values ('0000000009', 'Western');

create table Movie(
    Movie_ID        varchar2(10),
    Title           varchar2(50) NOT NULL,
    Year_Produced   varchar2(4) NOT NULL,
    Producer        varchar2(40) NOT NULL,
    Average_rating  varchar2(4) NOT NULL,
    primary key(Movie_ID) 
);

insert into Movie values ('0000000001', 'The Shawshank Redemption', '1994', 'Castle Rock Entertainment', '4.2');
insert into Movie values ('0000000002', 'The Godfather', '1972', 'Paramount Pictures', '4.1');
insert into Movie values ('0000000003', 'The Godfather: Part II', '1974', 'Paramount Pictures', '4.0');
insert into Movie values ('0000000004', 'The Dark Knight', '2008', 'Warner Bros.', '4.0');
insert into Movie values ('0000000005', '12 Angry Men', '1957', 'Orion-Nova Productions', '3.9');
insert into Movie values ('0000000006', 'Schindler"s List', '1993', 'Universal Pictures', '3.9');
insert into Movie values ('0000000007', 'The Lord of the Rings: The Return of the King', '2003', 'New Line Cinema', '3.9');
insert into Movie values ('0000000008', 'Pulp Fiction', '1994', 'Miramax', '3.8');
insert into Movie values ('0000000009', 'The Good, the Bad and the Ugly', '1966', 'Produzioni Europee Associate', '3.8');
insert into Movie values ('0000000010', 'The Lord of the Rings: The Fellowship of the Ring', '2001', 'New Line Cinema', '3.8');

create table Actor_Actress(
    Actor_Actress_ID    varchar2(10),
	first_name	        varchar2(20) NOT NULL,
    last_name           varchar2(20) NOT NULL,
    primary key(Actor_Actress_ID)
);

insert into Actor_Actress values ('0000000001', 'Tim', 'Robbins');
insert into Actor_Actress values ('0000000002', 'Morgan', 'Freeman');
insert into Actor_Actress values ('0000000003','Marlon', 'Brando');
insert into Actor_Actress values ('0000000004', 'Al', 'Pacino');
insert into Actor_Actress values ('0000000005','Robert', 'Duvall');
insert into Actor_Actress values ('0000000006','Diane', 'Keaton');
insert into Actor_Actress values ('0000000007','Christian','Bale');
insert into Actor_Actress values ('0000000008','Heath','Ledger');
insert into Actor_Actress values ('0000000009', 'Martin','Balsam');
insert into Actor_Actress values ('0000000010','John', 'Fielder');
insert into Actor_Actress values ('0000000011','Liam', 'Neeson');
insert into Actor_Actress values ('0000000012','Ben', 'Kingsley');
insert into Actor_Actress values ('0000000013', 'Noel', 'Appleby');
insert into Actor_Actress values ('0000000014', 'Ali', 'Astin');
insert into Actor_Actress values ('0000000015','John', 'Travolta');
insert into Actor_Actress values ('0000000016','Samuel','Jackson');
insert into Actor_Actress values ('0000000017','Clint','Eastwood');
insert into Actor_Actress values ('0000000018','Eli', 'Wallach');
insert into Actor_Actress values ('0000000019','Sean', 'Astin');
insert into Actor_Actress values ('0000000020', 'Cate', 'Banchett');

/********** Relations **********/

create table Has_Movie_Genre(
    Movie_ID    varchar2(10) NOT NULL,
    Genre_ID    varchar2(10) NOT NULL, 
    primary key(Movie_ID, Genre_ID),
    foreign key(Movie_ID) references Movie ON DELETE CASCADE,
    foreign key(Genre_ID) references Genre ON DELETE CASCADE
);
insert into Has_Movie_Genre values ('0000000001','0000000001');
insert into Has_Movie_Genre values ('0000000002','0000000001');
insert into Has_Movie_Genre values ('0000000002','0000000002');
insert into Has_Movie_Genre values ('0000000003','0000000001');
insert into Has_Movie_Genre values ('0000000003','0000000002');
insert into Has_Movie_Genre values ('0000000004','0000000001');
insert into Has_Movie_Genre values ('0000000004','0000000002');
insert into Has_Movie_Genre values ('0000000004','0000000003');
insert into Has_Movie_Genre values ('0000000004','0000000004');
insert into Has_Movie_Genre values ('0000000005','0000000001');
insert into Has_Movie_Genre values ('0000000005','0000000002');
insert into Has_Movie_Genre values ('0000000006','0000000001');
insert into Has_Movie_Genre values ('0000000006','0000000005');
insert into Has_Movie_Genre values ('0000000006','0000000006');
insert into Has_Movie_Genre values ('0000000007','0000000001');
insert into Has_Movie_Genre values ('0000000007','0000000003');
insert into Has_Movie_Genre values ('0000000007','0000000007');
insert into Has_Movie_Genre values ('0000000007','0000000008');
insert into Has_Movie_Genre values ('0000000008','0000000001');
insert into Has_Movie_Genre values ('0000000008','0000000002');
insert into Has_Movie_Genre values ('0000000009','0000000009');
insert into Has_Movie_Genre values ('0000000010','0000000001');
insert into Has_Movie_Genre values ('0000000010','0000000003');
insert into Has_Movie_Genre values ('0000000010','0000000007');
insert into Has_Movie_Genre values ('0000000010','0000000008');


create table Has_Favorite(
    Member_ID       varchar2(10) NOT NULL,
    Profile_Name    varchar2(10)NOT NULL,
    Genre_ID        varchar2(10)NOT NULL, 
    primary key(Member_ID, Profile_Name, Genre_ID),
    --foreign key(Member_ID) references Members ON DELETE CASCADE,
    foreign key(Member_ID, Profile_Name) references Profiles ON DELETE CASCADE,
    foreign key(Genre_ID) references Genre ON DELETE CASCADE
);

insert into Has_Favorite values ('dsmith', 'Dave','0000000008');
insert into Has_Favorite values ('dsmith', 'Devin','0000000003');
insert into Has_Favorite values ('ktran', 'Kev','0000000001');
insert into Has_Favorite values ('ktran', 'Kaylee','0000000002');
insert into Has_Favorite values ('awayne', 'Alexis','0000000009');
insert into Has_Favorite values ('awayne', 'Ariana','0000000009');
insert into Has_Favorite values ('jlynn', 'Jo','0000000005');
insert into Has_Favorite values ('jlynn', 'John','0000000006');
insert into Has_Favorite values ('cwang', 'Christy','0000000002');
insert into Has_Favorite values ('cwang', 'Christian','0000000003');
insert into Has_Favorite values ('bnelson', 'Bobby','0000000008');
insert into Has_Favorite values ('bnelson', 'Bransford','0000000004');

create table Viewing_History(
    Member_ID       varchar2(10)NOT NULL,
    Movie_ID        varchar2(10)NOT NULL,
    Profile_Name    varchar2(10)NOT NULL,
    Rating          varchar2(4)NOT NULL,
    primary key(Member_ID,Profile_Name,Movie_ID),
   -- foreign key(Member_ID) references Members ON DELETE CASCADE,
    foreign key (Member_ID, Profile_Name) references Profiles ON DELETE CASCADE,
    foreign key (Movie_ID) references Movie ON DELETE CASCADE
);
insert into Viewing_History values ('dsmith','0000000001','Dave','3.0');         
insert into Viewing_History values ('dsmith','0000000001','Devin','5.0');       
insert into Viewing_History values ('ktran', '0000000002','Kev','4.0');          
insert into Viewing_History values ('ktran', '0000000001','Kaylee','1.0');       
insert into Viewing_History values ('awayne','0000000002','Alexis','4.2');       
insert into Viewing_History values ('awayne','0000000001','Ariana','3.5');       
insert into Viewing_History values ('jlynn', '0000000002','Jo','2.5');           
insert into Viewing_History values ('jlynn', '0000000003','John','1.0');         
insert into Viewing_History values ('cwang', '0000000004','Christy','4.8');      
insert into Viewing_History values ('cwang', '0000000001','Christian','4.0');    
insert into Viewing_History values ('bnelson','0000000002','Bobby','2.0');       
insert into Viewing_History values ('bnelson','0000000001','Bransford','5.0');  

create table Movie_Cast(
    Movie_ID            varchar2(10)NOT NULL,    
    Actor_Actress_ID    varchar2(10)NOT NULL,
    primary key(Movie_ID, Actor_Actress_ID),
    foreign key(Movie_ID) references Movie ON DELETE CASCADE,
    foreign key (Actor_Actress_ID) references Actor_Actress ON DELETE CASCADE
);
insert into Movie_Cast values ('0000000001','0000000001');
insert into Movie_Cast values ('0000000001','0000000002');
insert into Movie_Cast values ('0000000002','0000000003');
insert into Movie_Cast values ('0000000002','0000000004');
insert into Movie_Cast values ('0000000003','0000000005');
insert into Movie_Cast values ('0000000003','0000000006');
insert into Movie_Cast values ('0000000004','0000000007');
insert into Movie_Cast values ('0000000004','0000000008');
insert into Movie_Cast values ('0000000005','0000000009');
insert into Movie_Cast values ('0000000005','0000000010');
insert into Movie_Cast values ('0000000006','0000000011');
insert into Movie_Cast values ('0000000006','0000000012');
insert into Movie_Cast values ('0000000007','0000000013');
insert into Movie_Cast values ('0000000007','0000000014');
insert into Movie_Cast values ('0000000008','0000000015');
insert into Movie_Cast values ('0000000008','0000000016');
insert into Movie_Cast values ('0000000009','0000000017');
insert into Movie_Cast values ('0000000009','0000000018');
insert into Movie_Cast values ('0000000010','0000000019');
insert into Movie_Cast values ('0000000010','0000000020');
