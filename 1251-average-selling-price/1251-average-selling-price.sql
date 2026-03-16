# Write your MySQL query statement below
SELECT 
    p.product_id,
    ROUND(
        IFNULL(SUM(p.price * u.units) / SUM(u.units), 0),
        2
    ) AS average_price
FROM Prices p
LEFT JOIN UnitsSold u
ON p.product_id = u.product_id
AND u.purchase_date BETWEEN p.start_date AND p.end_date
GROUP BY p.product_id;


-- SELECT P.product_id, ROUND(IFNULL(SUM(P.price * U.units)/SUM(U.units),0), 2) AS average_price 
-- FROM Prices P LEFT JOIN UnitsSold U 
-- ON P.product_id = U.product_id AND U.purchase_date BETWEEN P.start_date AND P.end_date 
-- GROUP BY P.product_id;