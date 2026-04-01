# Write your MySQL query statement below
-- SELECT 
-- Products.product_name,
-- SUM(Orders.unit) AS unit
-- FROM Products
-- INNER JOIN Orders
-- ON Products.product_id=Orders.product_id
-- WHERE MONTH(order_date)=02 AND YEAR(order_date)=2020
-- GROUP BY Products.product_name
-- HAVING unit>=100

SELECT 
    p.product_name,
    SUM(o.unit) AS unit
FROM Products p
JOIN Orders o
    ON p.product_id = o.product_id
WHERE EXTRACT(MONTH FROM o.order_date) = 2
  AND EXTRACT(YEAR FROM o.order_date) = 2020
GROUP BY p.product_name
HAVING SUM(o.unit) >= 100;