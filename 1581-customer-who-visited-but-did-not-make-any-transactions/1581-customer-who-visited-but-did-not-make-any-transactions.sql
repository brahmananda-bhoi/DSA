# Write your MySQL query statement below
SELECT v.customer_id, COUNT(*) AS count_no_trans
FROM Visits v
LEFT JOIN Transactions t
ON v.visit_id = t.visit_id
WHERE t.visit_id IS NULL
GROUP BY v.customer_id;





-- SELECT
--   customer_id,
--   COUNT(*) AS count_no_trans
-- FROM Visits AS v
-- WHERE NOT EXISTS (
--   SELECT 1
--   FROM Transactions AS t
--   WHERE t.visit_id = v.visit_id
-- )
-- GROUP BY customer_id;
