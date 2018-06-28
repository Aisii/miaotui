/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/6/25 23:18:11                            */
/*==============================================================*/


drop table if exists t_advertisement;

drop table if exists t_article;

drop table if exists t_back_message;

drop table if exists t_member;

drop table if exists t_reward;

drop table if exists t_sys_param;

/*==============================================================*/
/* Table: t_advertisement                                       */
/*==============================================================*/
create table t_advertisement
(
   id                   integer not null auto_increment,
   member_id            integer comment '会员ID',
   type                 int comment '类型: 1-顶部, 2-文中, 3-文尾',
   url                  varchar(200),
   create_date          datetime,
   status               int comment '0-用户删除, 1-平台删除, 2-有效',
   primary key (id)
);

alter table t_advertisement comment '广告表';

/*==============================================================*/
/* Table: t_article                                             */
/*==============================================================*/
create table t_article
(
   id                   integer not null auto_increment,
   member_id            integer comment '会员ID',
   title                varchar(50) comment '标题',
   content              text comment '内容',
   zan                  int comment '点赞数',
   create_date          datetime,
   status               int comment '状态:0-岗位, 1-有效',
   primary key (id)
);

alter table t_article comment '文章表';

/*==============================================================*/
/* Table: t_back_message                                        */
/*==============================================================*/
create table t_back_message
(
   id                   integer not null auto_increment,
   article_id           integer comment '文章ID',
   message              varchar(1000) comment '留言',
   reply                varchar(1000) comment '作者回复',
   create_date          datetime comment '留言时间',
   status               int comment '状态:0-删除, 1-有效',
   primary key (id)
);

alter table t_back_message comment '文章留言表';

/*==============================================================*/
/* Table: t_member                                              */
/*==============================================================*/
create table t_member
(
   id                   integer not null auto_increment,
   login_name           varchar(20) comment '登录名',
   login_pwd            varchar(128) comment '登录密码',
   parent_id            integer comment '上级ID',
   balance              double comment '余额',
   freez                double comment '冻结金额(提现中)',
   openid               varchar(128) comment '微信openid',
   type                 int comment '类型:1-月度用户, 2-季度用户,3-月度用户',
   create_date          datetime,
   status               char(2) comment '状态:0-无效, 1-有效',
   primary key (id)
);

alter table t_member comment '会员表';

/*==============================================================*/
/* Table: t_reward                                              */
/*==============================================================*/
create table t_reward
(
   id                   integer not null auto_increment,
   meber_id             integer,
   type                 int,
   amount               double,
   create_date          datetime,
   primary key (id)
);

alter table t_reward comment '推荐用户购买奖励表';

/*==============================================================*/
/* Table: t_sys_param                                           */
/*==============================================================*/
create table t_sys_param
(
   id                   integer not null auto_increment,
   key                  varchar(20),
   value                varchar(20),
   primary key (id)
);

alter table t_sys_param comment '系统参数';

