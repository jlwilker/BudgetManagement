-- Step 1
/* Edit "SELECT" statement below to reflect desired range, where 'A' equals the beginning date and 'B' equals the ending date, in datediff('A', 'B')*/
-- SELECT datediff('2020-12-31','2013-01-01');

-- Step 2 
-- Edit "USE" statement below to reflect desired database in which to create calendar table
USE test;

-- Step 3 
-- Create new table with desired calendar fields
CREATE TABLE calendar_table (
	date DATE NOT NULL PRIMARY KEY,
	year SMALLINT NULL,
	month tinyint NULL,
	day tinyint NULL,
	dayOfWeek tinyint NULL,
	monthName VARCHAR(9) NULL,
	dayName VARCHAR(9) NULL,
	week tinyint NULL,
	isWeekday BINARY(1) NULL,
	isHoliday BINARY(1) NULL,
	holidayDescrip VARCHAR(32) NULL,
	isActivity BINARY(1) NULL,
	ActivityId tinyint NULL
);

-- Step 4
-- Populate new table with one record for each date
CREATE TABLE ints ( i tinyint );
 
INSERT INTO ints VALUES (0),(1),(2),(3),(4),(5),(6),(7),(8),(9);
 
INSERT INTO calendar_table (date)
SELECT DATE('2013-01-01') + INTERVAL a.i*1000 + b.i*100 + c.i*10 + d.i DAY
FROM ints a JOIN ints b JOIN ints c JOIN ints d 
WHERE (a.i*1000 + b.i*100 + c.i*10 + d.i) <= 1094
ORDER BY 1;

-- Step 5
/*Mark weekends and fill in year, month, day, day of the week, month name, day name and week number fields.*/
UPDATE calendar_table
SET isWeekday = CASE WHEN dayOfWeek(date) IN (1,7) THEN 0 ELSE 1 END,
	isHoliday = 0,
	isActivity = 0,
	year = YEAR(date),
	month = MONTH(date),
	day = dayOfMonth(date),
	dayOfWeek = dayOfWeek(date),
	monthName = monthName(date),
	dayName = dayName(date),
	week = week(date),
	holidayDescrip = '',
	ActivityId = 0;

-- Step 6 - ?
/*The following steps mark specific dates as Holidays, Paydays, bills, etc. These will need to be edited/added to/updated to reflect implementer needs*/

-- New Year's Day (also marks business holiday if falls on Monday or Thursday)
UPDATE calendar_table SET isHoliday = 1, holidayDescrip = 'New Year''s Day' WHERE month = 1 AND day = 1;
 
UPDATE calendar_table c1
LEFT JOIN calendar_table c2 ON c2.date = c1.date + INTERVAL 1 DAY
SET c1.isHoliday = 1, c1.holidayDescrip = 'Holiday for New Year''s Day'
WHERE c1.dayOfWeek = 6 AND c2.month = 1 AND c2.dayOfWeek = 7 AND c2.isHoliday = 1;
 
UPDATE calendar_table c1
LEFT JOIN calendar_table c2 ON c2.date = c1.date - INTERVAL 1 DAY
SET c1.isHoliday = 1, c1.holidayDescrip = 'Holiday for New Year''s Day'
WHERE c1.dayOfWeek = 2 AND c2.month = 1 AND c2.dayOfWeek = 1 AND c2.isHoliday = 1;

-- Martin Luther King's Day
UPDATE calendar_table
SET isHoliday = 1, holidayDescrip = 'Martin Luther King Day'
WHERE month = 1 AND dayOfWeek = 2 AND day BETWEEN 15 AND 21;

-- President's Day
UPDATE calendar_table
SET isHoliday = 1, holidayDescrip = 'President''s Day'
WHERE month = 2 AND dayOfWeek = 2 AND day BETWEEN 15 AND 21;

-- Memorial Day
UPDATE calendar_table
SET isHoliday = 1, holidayDescrip = 'Memorial Day'
WHERE month = 5 AND dayOfWeek = 2 AND day BETWEEN 25 AND 31;

-- Independence Day (also marks business holiday if falls on Monday or Thursday)
UPDATE calendar_table
SET isHoliday = 1, holidayDescrip = 'Independence Day'
WHERE month = 7 AND day = 4;
 
UPDATE calendar_table c1
LEFT JOIN calendar_table c2 ON c2.date = c1.date + INTERVAL 1 DAY
SET c1.isHoliday = 1, c1.holidayDescrip = 'Holiday for Independence Day'
WHERE c1.dayOfWeek = 6 AND c2.month = 7 AND c2.day = 4 AND c2.dayOfWeek = 7 AND c2.isHoliday = 1;
 
UPDATE calendar_table c1
LEFT JOIN calendar_table c2 ON c2.date = c1.date - INTERVAL 1 DAY
SET c1.isHoliday = 1, c1.holidayDescrip = 'Holiday for Independence Day'
WHERE c1.dayOfWeek = 2 AND c2.month = 7 AND c2.day = 4 AND c2.dayOfWeek = 1 AND c2.isHoliday = 1;

-- Labor Day
UPDATE calendar_table
SET isHoliday = 1, holidayDescrip = 'Labor Day'
WHERE month = 9 AND dayOfWeek = 2 AND day BETWEEN 1 AND 7;

-- Veteren's Day (also marks business holiday if falls on Monday or Thursday)
UPDATE calendar_table
SET isHoliday = 1, holidayDescrip = 'Veteran''s Day'
WHERE month = 11 AND day = 11;
 
UPDATE calendar_table c1
LEFT JOIN calendar_table c2 ON c2.date = c1.date + INTERVAL 1 DAY
SET c1.isHoliday = 1, c1.holidayDescrip = 'Holiday for Veteran''s Day'
WHERE c1.dayOfWeek = 6 AND c2.month = 11 AND c2.day = 11 AND c2.dayOfWeek = 7 AND c2.isHoliday = 1;
 
UPDATE calendar_table c1
LEFT JOIN calendar_table c2 ON c2.date = c1.date - INTERVAL 1 DAY
SET c1.isHoliday = 1, c1.holidayDescrip = 'Holiday for Veteran''s Day'
WHERE c1.dayOfWeek = 2 AND c2.month = 11 AND c2.day = 11 AND c2.dayOfWeek = 1 AND c2.isHoliday = 1;

-- Thanksgiving Day
UPDATE calendar_table
SET isHoliday = 1, holidayDescrip = 'Thanksgiving Day'
WHERE month = 11 AND dayOfWeek = 5 AND day BETWEEN 22 AND 28;

-- Christmas
UPDATE calendar_table
SET isHoliday = 1, holidayDescrip = 'Christmas Day'
WHERE month = 12 AND day = 25;
 
UPDATE calendar_table c1
LEFT JOIN calendar_table c2 ON c2.date = c1.date + INTERVAL 1 DAY
SET c1.isHoliday = 1, c1.holidayDescrip = 'Holiday for Christmas Day'
WHERE c1.dayOfWeek = 6 AND c2.month = 12 AND c2.day = 25 AND c2.dayOfWeek = 7 AND c2.isHoliday = 1;
 
UPDATE calendar_table c1
LEFT JOIN calendar_table c2 ON c2.date = c1.date - INTERVAL 1 DAY
SET c1.isHoliday = 1, c1.holidayDescrip = 'Holiday for Christmas Day'
WHERE c1.dayOfWeek = 2 AND c2.month = 12 AND c2.day = 25 AND c2.dayOfWeek = 1 AND c2.isHoliday = 1;

-- Recurring (Activity) Calculations
/*These will need to be updated to reflect needs, but this is the command for recurring events*/
UPDATE calendar_table
SET ActivityId = 9
WHERE date IN (
		SELECT DATE('2013-09-02') - INTERVAL (a.i*100 + b.i*10 + c.i) * 1 month FROM ints a JOIN ints b JOIN ints c WHERE DATE('2013-09-02') - INTERVAL (a.i*100 + b.i*10 + c.i) * 2 week >= DATE('2013-01-01'));

UPDATE calendar_table
SET isActivity = 1
WHERE date IN (
		SELECT DATE('2013-09-02') - INTERVAL (a.i*100 + b.i*10 + c.i) * 1 month FROM ints a JOIN ints b JOIN ints c WHERE DATE('2013-09-02') - INTERVAL (a.i*100 + b.i*10 + c.i) * 2 week >= DATE('2013-01-01'));

UPDATE calendar_table
SET ActivityId = 9
WHERE date IN (
		SELECT DATE('2013-09-02') + INTERVAL (a.i*100 + b.i*10 + c.i) * 1 month FROM ints a JOIN ints b JOIN ints c WHERE DATE('2013-09-02') + INTERVAL (a.i*100 + b.i*10 + c.i) * 2 week <= DATE('2015-12-31')
);

UPDATE calendar_table
SET isActivity = 1
WHERE date IN (
		SELECT DATE('2013-09-02') + INTERVAL (a.i*100 + b.i*10 + c.i) * 1 month FROM ints a JOIN ints b JOIN ints c WHERE DATE('2013-09-02') + INTERVAL (a.i*100 + b.i*10 + c.i) * 2 week <= DATE('2015-12-31')
);

/*Include this command to account for times when paydays or bills fall on weekends and need to be charged/received on a weekday*/
/*
UPDATE calendar_table
SET isPayday = 1
WHERE dt IN (
	SELECT newDate FROM (
		SELECT date - INTERVAL 1 DAY AS newDate
		FROM calendar_table
		WHERE isPayday = 1 AND isHoliday = 1 AND date > '2014-01-01'
	) AS x
);
 
UPDATE calendar_table
SET isPayday = 0
WHERE isPayday = 1 AND isHoliday = 1;*/