--Write your MySQL query statement below

-- Subquery
-- select e.name as Employee from employee as e where e.managerId is not null && e.salary > 
-- (select emp.salary from employee as emp where e.managerId = emp.id);


-- Using inner join
select e.name as Employee from employee as e 
JOIN employee as m on e.managerId = m.id
where e.salary > m.salary;