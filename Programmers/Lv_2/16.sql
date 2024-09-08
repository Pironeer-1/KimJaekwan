SELECT
    B.BOOK_ID,
    A.AUTHOR_NAME,
    DATE_FORMAT(B.PUBLISHED_DATE, '%Y-%m-%d') AS FORMATTED_DATE 
FROM
    BOOK B join AUTHOR A on B.AUTHOR_ID = A.AUTHOR_ID
WHERE
    B.CATEGORY = '경제'
ORDER BY
    B.PUBLISHED_DATE