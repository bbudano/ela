CREATE ROLE ela_admin LOGIN
    PASSWORD 'ela_admin'
    SUPERUSER INHERIT CREATEDB CREATEROLE REPLICATION;

CREATE DATABASE ela
    WITH OWNER = ela_admin
    ENCODING = 'UTF-8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

\connect ela ela_admin;
CREATE SCHEMA dev;

ALTER ROLE ela_admin IN DATABASE ela SET search_path = dev, public;
