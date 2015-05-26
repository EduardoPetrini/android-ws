# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table person (
  id                        varchar(255) not null,
  name                      varchar(255),
  constraint pk_person primary key (id))
;

create table usuario (
  id                        varchar(255) not null,
  nome                      varchar(255),
  email                     varchar(255),
  senha                     varchar(255),
  cargo                     varchar(255),
  constraint pk_usuario primary key (id))
;

create table viagem (
  id                        varchar(255) not null,
  titulo                    varchar(255),
  data_partida              timestamp,
  data_chegada              timestamp,
  cidade_origem             varchar(255),
  cidade_destino            varchar(255),
  qtde_pessoas              integer,
  custo_orçado              float,
  custo_real                float,
  constraint pk_viagem primary key (id))
;

create sequence person_seq;

create sequence usuario_seq;

create sequence viagem_seq;




# --- !Downs

drop table if exists person cascade;

drop table if exists usuario cascade;

drop table if exists viagem cascade;

drop sequence if exists person_seq;

drop sequence if exists usuario_seq;

drop sequence if exists viagem_seq;

