/*
题目描述
查找所有员工自入职以来的薪水涨幅情况，给出员工编号emp_no以及其对应的薪水涨幅growth，并按照growth进行升序
CREATE TABLE `employees` (
`emp_no` int(11) NOT NULL,
`birth_date` date NOT NULL,
`first_name` varchar(14) NOT NULL,
`last_name` varchar(16) NOT NULL,
`gender` char(1) NOT NULL,
`hire_date` date NOT NULL,
PRIMARY KEY (`emp_no`));

CREATE TABLE `salaries` (
`emp_no` int(11) NOT NULL,
`salary` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`from_date`));
 */
select s1.emp_no,(s1.salary-s2.salary) as growth
from salaries s1
INNER JOIN salaries s2
on s1.emp_no =s2.emp_no
where
s1.from_date=(select max(from_date) from salaries where emp_no = s1.emp_no)
and s2.from_date = (select min(from_date) from salaries where emp_no = s1.emp_no)
and s1.to_date='9999-01-01'
order by growth asc