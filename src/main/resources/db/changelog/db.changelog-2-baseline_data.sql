--liquibase formatted sql

--changeset bbudano:insert_teams
insert into team(id, base_allowance, name) values (1, 20, 'Junior 1');
insert into team(id, base_allowance, name) values (2, 20, 'Junior 2');
insert into team(id, base_allowance, name) values (3, 20, 'Junior 3');
insert into team(id, base_allowance, name) values (4, 21, 'Mid 1');
insert into team(id, base_allowance, name) values (5, 21, 'Mid 2');
insert into team(id, base_allowance, name) values (6, 21, 'Mid 3');
insert into team(id, base_allowance, name) values (7, 22, 'Senior 1');
insert into team(id, base_allowance, name) values (8, 22, 'Senior 2');
insert into team(id, base_allowance, name) values (9, 22, 'Senior 3');

--changeset bbudano:insert_employees
insert into employee(id, date_of_birth, email, employment_date, first_name, last_name, role, team_id)
values (1, '1996-04-08', 'bbudano@gmail.com', '2022-11-01', 'Bernard', 'Budano', 'ROLE_ADMIN', 1);
