drop database if exists pruDB;

create database pruDB;

use pruDB;

create table productLines
(
    id          int auto_increment primary key,
    description varchar(400) not null unique
);

create table products
(
    productCode int not null primary key,
    name        varchar(50)  default null,
    productLine int,
    description varchar(400) default null,
    price       double,
    quantity    int,
    foreign key (productLine) references productLines (id)
        on update cascade on delete set null
);

create table officesa
(
    officeCode int primary key,
    city       varchar(50),
    country    varchar(50),
    phone      varchar(50),
    address    varchar(200),
    postCode   varchar(10)
);

create table employees
(
    id         int auto_increment primary key,
    firstName  varchar(50),
    lastName   varchar(50),
    email      varchar(50),
    phone      varchar(50),
    officeCode int,
    reportsTo  int default null,
    jobTitle   varchar(20),
    foreign key (reportsTo) references employees (id)
        on update cascade on delete set null,
    foreign key (officeCode) references officesa (officeCode)
        on update cascade on delete set null
);

create table customers
(
    id               int auto_increment primary key,
    firstName        varchar(50),
    lastName         varchar(50),
    email            varchar(50),
    phone            varchar(50),
    address          varchar(200),
    city             varchar(50),
    country          varchar(50),
    postCode         varchar(10),
    salesRepEmployee int,
    foreign key (salesRepEmployee) references employees (id)
        on update cascade on delete set null
);

create table payments
(
    customerId int,
    paymentId  int,
    date       date,
    amount     double,
    foreign key (customerId) references customers (id),
    primary key (customerId, paymentId)
);

create table orders
(
    ordernumber int auto_increment primary key,
    date        date,
    shippedDate date,
    status      varchar(50),
    comments    varchar(200),
    customerId  int,
    foreign key (customerId) references customers (id)
        on update cascade on delete set null
);

create table orderDetails
(
    orderNumber int,
    productCode int,
    quantity    int,
    foreign key (orderNumber) references orders (ordernumber)
        on update cascade on delete cascade,
    foreign key (productCode) references products (productCode)
        on update cascade on delete cascade
);



insert productLines (description)
    value ('shoes'),
    ('jackets'),
    ('underwears'),
    ('hats');

insert officesa (officeCode, city, country, phone, address, postCode)
    value (1, 'Kiev', 'Ukraine', '+3 044 111-11-11', 'Hrushevskogo 99', '03077'),
    (2, 'Kiev', 'Ukraine', '+3 044 222-22-22', 'Kudryashova 14', '03088'),
    (3, 'Kiev', 'Ukraine', '+3 044 333-33-33', 'Prahovih 54', '03099');

insert employees (firstName, lastName, email, phone, officeCode, reportsTo, jobTitle)
    value ('Maxim', 'Grubiy', 'grub@gmail.com', '+3 050 111-11-11', 1, null, 'manager'),
    ('Oleg', 'Beliy', 'beliy@gmail.com', '+3 050 222-22-22', 2, null, 'manager'),
    ('Saveliy', 'Siniy', 'siniysaveliy@gmail.com', '+3 050 333-33-33', 3, 1, 'sales representative'),
    ('Dmitriy', 'Bush', 'bushy@gmail.com', '+3 050 444-44-44', 2, 2, 'sales representative'),
    ('David', 'Sonat', 'sonat@gmail.com', '+3 050 555-55-55', 1, 1, 'sales representative'),
    ('Sergey', 'Kush', 'kush@gmail.com', '+3 050 666-66-66', 1, 2, 'sales representative'),
    ('Vasil', 'Mit', 'mit@gmail.com', '+3 050 777-77-77', 2, 2, 'sales representative'),
    ('Nazar', 'Curbas', 'curbas@gmail.com', '+3 050 888-88-88', 1, 2, 'sales representative'),
    ('Taras', 'Shevchenko', 'shevchenko@gmail.com', '+3 050 999-99-99', 3, 2, 'sales representative');


insert customers (firstName, lastName, email, phone, address, city, country, postCode, salesRepEmployee)
    value ('MaximCustomer', 'GrubiyCustomer', 'grubCustomer@gmail.com', '+3 098 111-11-11', 'Pobedy1', 'Kiev',
           'Ukraine', '03111', 3),
    ('OlegCustomer', 'BeliyCustomer', 'beliyCustomer@gmail.com', '+3 098 222-22-22', 'Pobedy2', 'Kiev', 'Ukraine',
     '03222', 3),
    ('SaveliyCustomer', 'SiniyCustomer', 'siniysaveliyCustomer@gmail.com', '+3 098 333-33-33', 'Pobedy3', 'Kiev',
     'Ukraine', '03333', 3),
    ('DmitriyCustomer', 'BushCustomer', 'bushyCustomer@gmail.com', '+3 098 444-44-44', 'Pobedy4', 'Kiev', 'Ukraine',
     '03444', 6),
    ('DavidCustomer', 'SonatCustomer', 'sonatCustomer@gmail.com', '+3 098 555-55-55', 'Pobedy5', 'Kiev', 'Ukraine',
     '03555', 5),
    ('SergeyCustomer', 'KushCustomer', 'kushCustomer@gmail.com', '+3 098 666-66-66', 'Pobedy6', 'Kiev', 'Ukraine',
     '03666', 5),
    ('VasilCustomer', 'MitCustomer', 'mitCustomer@gmail.com', '+3 098 777-77-77', 'Pobedy7', 'Kiev', 'Ukraine', '03777',
     4),
    ('NazarCustomer', 'CurbasCustomer', 'curbasCustomer@gmail.com', '+3 098 888-88-88', 'Pobedy8', 'Kiev', 'Ukraine',
     '03888', 4),
    ('TarasCustomer', 'ShevchenkoCustomer', 'shevchenkoCustomer@gmail.com', '+3 098 999-99-99', 'Pobedy9', 'Kiev',
     'Ukraine', '03999', 3);


insert payments (customerId, paymentId, date, amount)
    value (1, '1', '2020-11-11', 37.86),
    (1, '2', '2020-11-11', 45.8),
    (2, '1', '2020-10-11', 87.67),
    (3, '1', '2020-10-11', 87.67),
    (3, '2', '2020-10-11', 87.67),
    (5, '1', '2020-10-11', 87.67),
    (4, '1', '2020-10-11', 87.67),
    (4, '2', '2020-10-11', 87.67),
    (3, '3', '2020-10-11', 87.67),
    (6, '1', '2020-10-11', 87.67);