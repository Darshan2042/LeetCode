# Write your MySQL query statement below

select e.name, b.bonus
from Employee e
LEFT JOIN Bonus b
ON e.empId = b.empId
    where b.bonus is NULL
        OR bonus < 1000;