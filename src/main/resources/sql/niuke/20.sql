/*
题目描述
查找员工编号emp_no为10001其自入职以来的薪水salary涨幅值growth
CREATE TABLE `salaries` (
`emp_no` int(11) NOT NULL,
`salary` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`from_date`));
 */
select (s1.salary-s2.salary) as growth
from salaries s1
INNER JOIN salaries s2
on s1.emp_no =s2.emp_no
where s1.emp_no='10001'
and s1.from_date=(select max(from_date) from salaries where emp_no = s1.emp_no)
and s2.from_date = (select min(from_date) from salaries where emp_no = s1.emp_no)