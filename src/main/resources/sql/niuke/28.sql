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
----------------------------------------
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

查找描述信息中包括robot的电影对应的分类名称以及电影数目，而且还需要该分类对应电影数量>=5部
 */
select c.name,count(f.film_id)as f_count from film as f

    inner join film_category as fc

    on f.film_id=fc.film_id

    inner join category as c

    on fc.category_id=c.category_id

    where f.description like '%robot%'

    group by c.category_id

    having f_count>=2;
