# Write your MySQL query statement below
SELECT EU.unique_id, E.name FROM Employees AS E LEFT JOIN EmployeeUNI AS EU ON E.id = EU.id;

-- SELECT unique_id,name FROM EmployeeUNI RIGHT JOIN Employees ON EmployeeUNI.id=Employees.id;