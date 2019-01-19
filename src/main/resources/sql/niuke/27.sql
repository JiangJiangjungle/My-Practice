/*
题目描述
给出每个员工每年薪水涨幅超过5000的员工编号emp_no、薪水变更开始日期from_date以及薪水涨幅值salary_growth，并按照salary_growth逆序排列。
提示：在sqlite中获取datetime时间对应的年份函数为strftime('%Y', to_date)


CREATE TABLE `salaries` (
`emp_no` int(11) NOT NULL,
`salary` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`from_date`));
 */
select s1.emp_no,s2.from_date,(s2.salary-s1.salary) as salary_growth
from salaries as s1,
salaries as s2
where
s1.emp_no = s2.emp_no
and DAYOFYEAR(s2.from_date) = DAYOFYEAR(s1.from_date)+1
and s2.salary-s1.salary>5000
order by salary_growth desc