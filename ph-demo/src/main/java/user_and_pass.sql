CREATE USER 'jelastic'@'localhost' IDENTIFIED BY 'temporal';
GRANT ALL PRIVILEGES ON * . * TO 'jelastic'@'localhost';
FLUSH PRIVILEGES;