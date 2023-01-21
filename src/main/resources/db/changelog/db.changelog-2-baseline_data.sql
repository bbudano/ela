--liquibase formatted sql

--changeset bbudano:insert_teams
insert into team(id, base_allowance, name)
values (1, 20, 'Senior Technician');

--changeset bbudano:insert_employees
insert into employee(id, date_of_birth, email, employment_date, first_name, last_name, role, team_id)
values (1, '1996-04-08', 'bbudano@gmail.com', '2022-11-01', 'Bernard', 'Budano', 'ROLE_ADMIN', 1);
