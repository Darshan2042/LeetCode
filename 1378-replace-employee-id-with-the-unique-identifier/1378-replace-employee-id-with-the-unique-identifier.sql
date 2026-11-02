# Write your MySQL query statement below
select en.unique_id, e.name
from employees e
LEFT JOIN  EmployeeUNI en
ON en.id = e.id;