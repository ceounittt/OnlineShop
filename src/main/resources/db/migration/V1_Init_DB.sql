create sequence hibernate_sequence start 1 increment 1;

create table product (
                         id int8 not null,
                         name varchar(255) not null,
                         cost numeric(255) not null,
                         description varchar(2048) not null,
                         primary key (id)
);

create table user_role (
                           user_id int8 not null,
                           roles varchar(255)
);

create table usr (
                     id int8 not null,
                     activation_code varchar(255),
                     active boolean not null,
                     email varchar(255),
                     password varchar(255) not null,
                     firstname varchar(255) not null,
                     lastname varchar(255) not null,
                     primary key (id)
);
