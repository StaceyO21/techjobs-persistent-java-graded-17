--Part 1
create table job (
	int id auto_increment primary key;
    varchar(255) name,
    varchar(255) employer,
    varchar(255) skills,
    );
--Part 2
select employer.name
from employer
where location = "St. Louis, MO.";

--Part 3
Drop Table job;

--Part 4
