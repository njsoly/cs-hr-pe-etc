/*Please add ; after each select statement*/
CREATE PROCEDURE gradeDistribution()
BEGIN
	
/*    select *, 
		(Midterm1 / 100.0 * 0.25 + 
		Midterm2 / 100.0 * 0.25 + 
		Final / 200.0 * 0.5) g1,
    (Grades.Midterm1/100.0 * 0.5 + Grades.Midterm2/100.0 * 0.5) g2, 
    (( Grades.Final/100.0 * 1.0)) g3
*/
 select Grades.Name, Grades.ID
    from Grades
    where greatest(
        ((Midterm1 / 100.0 * 0.25) + (Midterm2 / 100.0 * 0.25) + (Final / 100.0 * 0.50)), 
        ((Midterm1 / 100.0 * 0.50) + (Midterm2 / 100.0 * 0.50)),
        (Final / 100.0)
    ) = (Final / 100.0 * 1.0) and (Midterm1 + Midterm2) <> (Final * 2)
    order by Substring(Name,1,3), ID asc
;
END
