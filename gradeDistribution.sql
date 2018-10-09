-- arcade/db/always-leave-table-in-order/ #9
CREATE PROCEDURE gradeDistribution()
BEGIN
	
 select Grades.Name, Grades.ID
    from Grades
    where greatest(
        /* Option 1 */
        ((Midterm1 / 100.0 * 0.25) + (Midterm2 / 100.0 * 0.25) + (Final / 100.0 * 0.50)),
        -- Option 2
        ((Midterm1 / 100.0 * 0.50) + (Midterm2 / 100.0 * 0.50)), 
        -- Option 3
        (Final / 100.0) 
    ) = (Final / 100.0 * 1.0) 
    and (Midterm1 + Midterm2) <> (Final * 2)
    order by Substring(Name,1,3), ID asc
;
END
