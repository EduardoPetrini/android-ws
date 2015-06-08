# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table atividade_api (
  id                        integer not null,
  nome                      varchar(255),
  id_bpms                   varchar(255),
  constraint pk_atividade_api primary key (id))
;

create table grupo_usuario_api (
  id                        varchar(255) not null,
  id_bpms                   varchar(255),
  nome                      varchar(255),
  constraint pk_grupo_usuario_api primary key (id))
;

create table parametro_api (
  id                        integer not null,
  id_bpms                   varchar(255),
  nome                      varchar(255),
  valor                     varchar(255),
  constraint pk_parametro_api primary key (id))
;

create table usuario (
  id                        integer not null,
  id_aplicacao              integer,
  nome                      varchar(255),
  grupo_usuario_id          varchar(255),
  email                     varchar(255),
  senha                     varchar(255),
  constraint pk_usuario primary key (id))
;

create table usuario_api (
  id                        integer not null,
  id_aplicacao              integer,
  nome                      varchar(255),
  grupo_usuario_id          varchar(255),
  constraint pk_usuario_api primary key (id))
;

create table viagem (
  id                        integer not null,
  status                    varchar(255),
  titulo                    varchar(255),
  data_partida              timestamp,
  data_chegada              timestamp,
  cidade_origem             varchar(255),
  cidade_destino            varchar(255),
  qtde_pessoas              integer,
  custo_orcado              float,
  custo_real                float,
  constraint pk_viagem primary key (id))
;


create table viagem_usuario (
  viagem_id                      integer not null,
  usuario_id                     integer not null,
  constraint pk_viagem_usuario primary key (viagem_id, usuario_id))
;
create sequence atividade_api_seq;

create sequence grupo_usuario_api_seq;

create sequence parametro_api_seq;

create sequence usuario_seq;

create sequence usuario_api_seq;

create sequence viagem_seq;

alter table usuario add constraint fk_usuario_grupoUsuario_1 foreign key (grupo_usuario_id) references grupo_usuario_api (id);
create index ix_usuario_grupoUsuario_1 on usuario (grupo_usuario_id);
alter table usuario_api add constraint fk_usuario_api_grupoUsuario_2 foreign key (grupo_usuario_id) references grupo_usuario_api (id);
create index ix_usuario_api_grupoUsuario_2 on usuario_api (grupo_usuario_id);



alter table viagem_usuario add constraint fk_viagem_usuario_viagem_01 foreign key (viagem_id) references viagem (id);

alter table viagem_usuario add constraint fk_viagem_usuario_usuario_02 foreign key (usuario_id) references usuario (id);

# --- !Downs

drop table if exists atividade_api cascade;

drop table if exists grupo_usuario_api cascade;

drop table if exists parametro_api cascade;

drop table if exists usuario cascade;

drop table if exists usuario_api cascade;

drop table if exists viagem cascade;

drop table if exists viagem_usuario cascade;

drop sequence if exists atividade_api_seq;

drop sequence if exists grupo_usuario_api_seq;

drop sequence if exists parametro_api_seq;

drop sequence if exists usuario_seq;

drop sequence if exists usuario_api_seq;

drop sequence if exists viagem_seq;

