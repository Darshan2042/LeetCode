# Write your MySQL query statement below

select p.product_name, s.year, s.price
from sales s
INNER JOIN product p
ON p.product_id = s.product_id;