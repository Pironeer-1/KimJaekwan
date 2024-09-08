SELECT 
    count(*) as FISH_COUNT
FROM 
    FISH_INFO
WHERE
    EXTRACT(year from TIME) = '2021'