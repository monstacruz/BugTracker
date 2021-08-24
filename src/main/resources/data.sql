INSERT INTO project (name, description, start_date) VALUES ('Bug Tracker', 'A web application used to track bugs and assign them to members', '2021-01-01');
INSERT INTO project (name, description, start_date) VALUES ('Discord sound bot', 'A bot that can play different sound files into a discord server', '2021-02-02');

INSERT INTO member(first_name, last_name, email, project_id) VALUES ('Mon Clarence', 'Santa Cruz', 'monsantacruz@gmail.com', 1);
INSERT INTO member(first_name, last_name, email, project_id) VALUES ('Sam', 'Green', 'sam@verdejo.com', 2);

UPDATE project SET project_lead_id = 1 WHERE id = 1;
UPDATE project SET project_lead_id = 2 WHERE id = 2;

INSERT INTO bug(description, severity, severity_string, project_id, member_id) VALUES ('No Sound', 3, 'High', 2, 2);