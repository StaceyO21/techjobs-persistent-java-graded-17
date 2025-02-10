--Part 1
create table job (
	int id auto_increment primary key;
    varchar(255) name,
    varchar(255) employer,
    varchar(255) skills,
    );
--Part 2
select name
from employer
where location = "St. Louis City";

--Part 3
Drop Table job;

--Part 4
select *
from skill
inner join job_skills on job_skills.skills_id = skill.id
where job_skills.jobs_id is not null
order by name asc;