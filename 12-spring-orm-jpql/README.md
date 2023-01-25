## Store Procedure

```
CREATE PROCEDURE `find_by_level`(IN level_in int)
BEGIN
select * from course where level = level_in;
END
```