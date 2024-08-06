create table if not exists category
(
    id integer not null primary key,
    name varchar(255),
    description varchar(255)
);

create table if not exists product
(
    id integer not null primary key,
    name varchar(255),
    description varchar(255),
    quantity integer not null,
    price numeric(38,2),
    category_id integer
            constraint abcd references category
);

create sequence if not exists category_sec increment by 50;
create sequence if not exists product_sec increment by 50;