/*
编写一个 SQL 查询，查找所有至少连续出现三次的数字。

+----+-----+
| Id | Num |
+----+-----+
| 1  |  1  |
| 2  |  1  |
| 3  |  1  |
| 4  |  2  |
| 5  |  1  |
| 6  |  2  |
| 7  |  2  |
+----+-----+
例如，给定上面的 Logs 表， 1 是唯一连续出现至少三次的数字。

+-----------------+
| ConsecutiveNums |
+-----------------+
| 1               |
+-----------------+
 */
SELECT DISTINCT(t1.Num) as ConsecutiveNums FROM Logs t1
JOIN Logs t2
ON t1.Id=t2.Id-1
JOIN Logs t3
ON t1.Id=t3.Id-2
WHERE t1.Num=t2.Num AND t2.Num=t3.Num