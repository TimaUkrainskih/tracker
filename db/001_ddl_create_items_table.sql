create table item(
    id serial primary key,
    name varchar(50) not null,
    created_datetime timestamp default now()
);