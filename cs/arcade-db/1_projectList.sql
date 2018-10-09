/* THIS IS MYSQL */
CREATE PROCEDURE projectList()
BEGIN
	select project_name, team_lead, income from Projects;
END
