--liquibase formatted sql

--changeset generated:baseline_schema
create sequence dev.employee_id_seq start with 10 increment by 10;
create sequence dev.leave_id_seq start with 10 increment by 10;
create sequence dev.leave_type_id_seq start with 10 increment by 10;
create sequence dev.team_id_seq start with 10 increment by 10;

    create table dev.employee (
       id bigint not null,
        date_of_birth date,
        email varchar(255) not null,
        employment_date date,
        first_name varchar(255),
        last_name varchar(255),
        team_id bigint not null,
        primary key (id)
    );

    create table dev.leave (
       id bigint not null,
        comment text,
        end_date date not null,
        start_date date not null,
        leave_type_id bigint not null,
        primary key (id)
    );

    create table dev.leave_type (
       id bigint not null,
        deducts_allowance boolean not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table dev.team (
       id bigint not null,
        base_allowance integer not null,
        name varchar(255) not null,
        primary key (id)
    );

    alter table if exists dev.employee
       add constraint employee_email_unique unique (email);

    alter table if exists dev.leave_type
       add constraint leave_type_unique unique (name);

    alter table if exists dev.team
       add constraint team_name_unique unique (name);

    alter table if exists dev.employee
       add constraint FK8d7lrsr6kwirr93rx0tafnoqa
       foreign key (team_id)
       references dev.team;

    alter table if exists dev.leave
       add constraint FKiudna9eykfomtmpb11fpx7k5l
       foreign key (leave_type_id)
       references dev.leave_type;
