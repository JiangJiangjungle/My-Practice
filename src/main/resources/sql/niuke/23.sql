/*
题目描述
对所有员工的当前(to_date='9999-01-01')薪水按照salary进行按照1-N的排名，相同salary并列且按照emp_no升序排列
CREATE TABLE `salaries` (
`emp_no` int(11) NOT NULL,
`salary` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`from_date`));
 */
select s.emp_no,s.salary,r.rank
from salaries as s,
(
select s1.emp_no,count(distinct s2.salary) as rank
from salaries s1,
salaries s2
where s1.to_date=s2.to_date and s1.to_date = '9999-01-01' and s1.salary<=s2.salary
group by emp_no
) as r
where s.emp_no = r.emp_no and s.to_date = '9999-01-01'
ORDER BY s.salary DESC, s.emp_no ASC

/*
解法2，MySQL5.7版本sql_mode=only_full_group_by下无效
 */
SELECT s1.emp_no, s1.salary,COUNT(DISTINCT s2.salary) AS rank
FROM salaries AS s1, salaries AS s2
WHERE s1.to_date = '9999-01-01'  AND s2.to_date = '9999-01-01' AND s1.salary <= s2.salary
GROUP BY s1.emp_no
ORDER BY s1.salary DESC, s1.emp_no ASC