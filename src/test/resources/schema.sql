drop table if exists character_species;
drop table if exists character_class;
drop table if exists deities;
drop table if exists skills;

CREATE TABLE character_species
(
    id BIGINT,
    description TEXT NOT NULL,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE character_class
(
    id BIGINT,
    description TEXT NOT NULL,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE deities
(
    id          BIGINT,
    description TEXT    null,
    name        VARCHAR(255) NOT NULL,
    proficiency TEXT  null
);

create table skills
(
    id          bigint ,
    description text  not null,
    name        varchar(50) not null
);
