/*
题目描述
film表
字段	说明
film_id	电影id
title	电影名称
description	电影描述信息

CREATE TABLE IF NOT EXISTS film (
film_id smallint(5)  NOT NULL DEFAULT '0',
title varchar(255) NOT NULL,
description text,
PRIMARY KEY (film_id));
category表
字段	说明
category_id	电影分类id
name	电影分类名称
last_update	电影分类最后更新时间

CREATE TABLE category  (
category_id  tinyint(3)  NOT NULL ,
name  varchar(25) NOT NULL, `last_update` timestamp,
PRIMARY KEY ( category_id ));
film_category表
字段	说明
film_id	电影id
category_id	电影分类id
last_update	电影id和分类id对应关系的最后更新时间

CREATE TABLE film_category  (
film_id  smallint(5)  NOT NULL,
category_id  tinyint(3)  NOT NULL, `last_update` timestamp);

使用join查询方式找出没有分类的电影id以及名称
 */
select f.film_id,f.title
from film as f
WHERE f.film_id not in (select film_id from film_category)
