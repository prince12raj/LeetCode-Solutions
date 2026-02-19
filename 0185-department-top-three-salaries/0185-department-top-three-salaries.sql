# Write your MySQL query statement below
SELECT 
    (SELECT d.name 
     FROM Department d 
     WHERE d.id = e1.DepartmentId) AS Department,
     
    e1.name AS Employee,
    e1.salary AS Salary

FROM Employee e1

WHERE 3 > (
        SELECT COUNT(DISTINCT e2.salary)
        FROM Employee e2
        WHERE e2.salary > e1.salary
          AND e2.DepartmentId = e1.DepartmentId
);
