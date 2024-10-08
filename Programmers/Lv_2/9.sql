SELECT 
    D.ID, 
    D.EMAIL, 
    D.FIRST_NAME, 
    D.LAST_NAME
FROM 
    DEVELOPERS D
JOIN 
    SKILLCODES S_PYTHON ON S_PYTHON.NAME = 'Python'
JOIN 
    SKILLCODES S_CSHARP ON S_CSHARP.NAME = 'C#'
WHERE 
    (D.SKILL_CODE & S_PYTHON.CODE > 0) 
    OR (D.SKILL_CODE & S_CSHARP.CODE > 0)
ORDER BY 
    D.ID ASC;