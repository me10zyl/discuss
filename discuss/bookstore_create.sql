/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2015/5/27 15:41:00                           */
/*==============================================================*/


drop table if exists feedback;

drop table if exists goods;

drop table if exists user;

/*==============================================================*/
/* Table: feedback                                              */
/*==============================================================*/
create table feedback
(
   feedid               bigint not null auto_increment,
   name                 varchar(100),
   subject              varchar(100),
   msg                  varchar(200),
   email                varchar(100),
   ip                   varchar(50),
   primary key (feedid)
);

/*==============================================================*/
/* Table: goods                                                 */
/*==============================================================*/
create table goods
(
   goodsid              bigint not null auto_increment,
   goodsname            varchar(100),
   breifintroduction    varchar(200),
   detailintroduction   varchar(500),
   goodsprice           float,
   photo                varchar(100),
   category             varchar(100),
   primary key (goodsid)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   userid               bigint not null auto_increment,
   username             varchar(100),
   password_            varchar(100),
   grade                int,
   truename             varchar(100),
   email                varchar(100),
   phone                varchar(100),
   address_             varchar(100),
   primary key (userid)
);

