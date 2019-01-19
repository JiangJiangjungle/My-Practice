/*
题目描述
查找各个部门当前(to_date='9999-01-01')领导当前薪水详情以及其对应部门编号dept_no
CREATE TABLE `dept_manager` (
`dept_no` char(4) NOT NULL,
`emp_no` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`dept_no`));

CREATE TABLE `salaries` (
`emp_no` int(11) NOT NULL,
`salary` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`from_date`));
 */
select s.* ,d.dept_no
from salaries as s
join dept_manager as d
on s.emp_no=d.emp_no
where s.to_date = '9999-01-01'
    and    d.to_date='9999-01-01';
/*

 */
select s.* ,d.dept_no
from salaries as s
join dept_manager as d
on s.emp_no=d.emp_no
where s.from_date = (select max(from_date) from salaries as ss where ss.emp_no = s.emp_no) and d.to_date='9999-01-01';