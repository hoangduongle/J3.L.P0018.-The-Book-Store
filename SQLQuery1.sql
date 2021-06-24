create database BookStore
go

use BookStore
go

create table tblRoles(
	RoleID varchar(50) primary key,
	RoleName varchar(50)
)
go

create table tblUsers(
	UserID		int IDENTITY(1,1) primary key,
	UserName	varchar(50) not null,
	PassWord	varchar(50) not null,
	RoleID		varchar(50) foreign key references tblRoles(RoleID)
)

create table tblOrder(
	OrderID		int IDENTITY(1,1) primary key,
	DateOrder	date,
	total		float,
	UserID		int foreign key references tblUsers(UserID)
)

create table tblCategory(
	CategoryID		int IDENTITY(1,1) primary key,
	CategoryName	varchar(50)
)

create table tblBook(
	BookID		int IDENTITY(1,1) primary key,
	BookName		varchar(50),
	image			varchar(100),
	Price			float,
	quantity		int,
	Author			varchar(50),
	CurrentDate		date,
	Status			bit,
	CategoryID		int foreign key references tblCategory(CategoryID)
)

create table tblDetail(
	DetailID	int IDENTITY(1,1) primary key,
	Price		float,
	quantity	int,
	OrderID		int foreign key references tblOrder(OrderID),
	BookID	int foreign key references tblBook(BookID)
)

create table tblDiscount(
	DiscountID int IDENTITY(1,1) primary key,
	DiscountName varchar(20),
	Percent int,
	CodeName varchar(20),
	Begindate	date,
	Enddate date
)

insert into tblRoles values('1','Admin')
insert into tblRoles values('2','Member')

insert into tblUsers values('admin','1','1')
insert into tblUsers values('duong','1','2')
insert into tblUsers values('hoang','1','2')

insert into tblCategory values('NXB Tre')
insert into tblCategory values('NXB Kim Dong')
insert into tblCategory values('MCBOOKS')

insert into tblBook values('Tren Đuong Bang','https://i.ibb.co/SxZF8M3/Tren-uong-Bang.jpg','51000','1','tacgia','05-10-2021','1','1')
insert into tblBook values('De Men Phieu Luu Ky','https://i.ibb.co/WFNzrQz/De-Men-Phieu-Luu-Ky.jpg','115300','1','tacgia','05-10-2021','1','2')
insert into tblBook values('Tu Hoc 2000 Tu Vung Tieng Anh','https://i.ibb.co/RpBVjdj/Tu-Hoc-2000-Tu-Vung-Tieng-Anh.jpg','45500','1','tacgia','05-10-2021','1','3')

select BookID,BookName,image,Price,quantity,Author,CurrentDate,Status,CategoryID
from tblBook
where BookID ='1'

select *
from tblOrder o inner join tblDetail d on o.OrderID=d.OrderID
where o.UserID = 'duong'


update tblBook
set BookName = 'Tren Duong Bang',image = 'https://i.ibb.co/SxZF8M3/Tren-uong-Bang.jpg',Price='51000',quantity='2',Author='tacgia',CurrentDate='2021-05-10',Status='1',CategoryID='1'
where BookID = '1'

select BookID,BookName,image,Price,quantity,Author,CurrentDate,Status,CategoryID
from tblBook
where BookName like '%xam%'

select quantity
from tblBook
where BookID = '1'

select DiscountID, DName,DPercent,CodeName,Begindate,Enddate
from tblDiscount
where DiscountID = ''

delete tblDiscount
where DiscountID = '3'

insert into tblDiscount values('name','percent','code','begin','end');



alter table tblBook ALTER COLUMN image varchar(100)

select * 
from tblDetail

insert into tblDetail values('price','quantity','orderID','BookID')

select *
from tblOrder

insert into tblOrder values('DateOrder','total','UserID')

select top 1 OrderID
from tblOrder
order by OrderID desc

update tblBook
set quantity = ''
where BookID = ''

select o.OrderID,o.DateOrder,o.total
from tblOrder o, tblDetail d
where d.OrderID = o.OrderID and o.UserID = 2

select OrderID, DateOrder, total
from tblOrder
where UserID = 2

select Price, quantity,OrderID,BookID
from tblDetail
where OrderID = 5

select BookName,image,Price
from tblBook b, tblDetail d
where b.BookID = 1 and d.OrderID = 2


select image, BookName
from tblBook

select image, b.BookName, d.Price, d.quantity
from tblDetail d, tblBook b, tblOrder o
where o.OrderID in (select OrderID
from tblOrder
where UserID = 3)


select o.DateOrder, d.Price, d.quantity, b.image , b.BookName
from tblOrder o inner join tblDetail d on o.OrderID = d.OrderID, tblBook b
where b.BookID = d.BookID and UserID = 3

select *
from tblDetail

select *
from tblUsers
where UserName = '' and PassWord = ''

insert into tblUsers values('name','pass','');

delete tblUsers
where UserID = 6
