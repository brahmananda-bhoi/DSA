# Write your MySQL query statement below
SELECT E1.name
FROM Employee AS E1
JOIN (
    SELECT managerId
    FROM Employee
    GROUP BY managerId
    HAVING COUNT(*) >= 5
) AS E2
ON E1.id = E2.managerId;


-- SELECT e1.name
-- FROM Employee e1
-- JOIN Employee e2
-- ON e1.id = e2.managerId
-- GROUP BY e1.id, e1.name
-- HAVING COUNT(e2.id) >= 5;