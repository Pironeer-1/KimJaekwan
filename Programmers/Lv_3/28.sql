WITH COUNT_CHILD AS (
    SELECT
        PARENT_ID,
        COUNT(ID) AS CHILD_COUNT
    FROM
        ECOLI_DATA
    GROUP BY
        PARENT_ID
)

SELECT
    e.ID,
    COALESCE(c.CHILD_COUNT, 0) AS CHILD_COUNT   <- null이면 0으로
FROM
    ECOLI_DATA e LEFT JOIN COUNT_CHILD c ON e.ID = c.PARENT_ID
