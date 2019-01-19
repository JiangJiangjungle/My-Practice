/*
题目描述
从titles表获取按照title进行分组，每组个数大于等于2，给出title以及对应的数目t。
注意对于重复的emp_no进行忽略。
CREATE TABLE IF NOT EXISTS "titles" (
`emp_no` int(11) NOT NULL,
`title` varchar(50) NOT NULL,
`from_date` date NOT NULL,
`to_date` date DEFAULT NULL);
 */
select s.title,count(s.title) as t
from(
select title,emp_no
from titles
group by title,emp_no
) as s
group by title
having t>=2