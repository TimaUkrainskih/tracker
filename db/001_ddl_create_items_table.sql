create table item(
    id serial primary key,
    name varchar(50) not null,
    create_dttm timestamp default now()
);