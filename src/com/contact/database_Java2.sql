CREATE TABLE contacts (
  id INT PRIMARY KEY identity(1,1),
  name VARCHAR(50) NOT NULL,
  company VARCHAR(50),
  email VARCHAR(50),
  phone VARCHAR(20)
);

select * from contacts

insert into contacts(name, company, email, phone)
  values('phuc','fpt','phuctv@gmail.com','0385225687');

