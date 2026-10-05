# Write your MySQL query statement below

select today.id from Weather today 
JOIN Weather yesterday
ON yesterday.recordDate = DATE_SUB(today.recordDate ,interval 1 day)
where today.temperature > yesterday.temperature;
