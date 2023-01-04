## Database Configuration

```
create database inheridb;

create user 'inheridb'@'localhost' identified by 'inheridb';

grant all privileges on inheridb.* to 'inheridb'@'localhost';
```