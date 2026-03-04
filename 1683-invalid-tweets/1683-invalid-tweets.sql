# Write your MySQL query statement below
SELECT tweet_id FROM Tweets WHERE LENGTH(content)>15;
# CHAR_LENGTH()  can be used instead of LENGTH()