-- Set ActivityId and isActivity for a given Bill. Must split the interval into two (should pry just change it so no interval)
UPDATE calendar_table
SET ActivityId = 3
WHERE date IN (
		SELECT DATE('2013-01-12') - INTERVAL (a.i*100 + b.i*10 + c.i) * 1 month FROM ints a JOIN ints b JOIN ints c WHERE DATE('2013-01-12') - INTERVAL (a.i*100 + b.i*10 + c.i) * 2 week >= DATE('2013-01-01'));

UPDATE calendar_table
SET isActivity = 1
WHERE date IN (
		SELECT DATE('2013-01-12') - INTERVAL (a.i*100 + b.i*10 + c.i) * 1 month FROM ints a JOIN ints b JOIN ints c WHERE DATE('2013-01-12') - INTERVAL (a.i*100 + b.i*10 + c.i) * 2 week >= DATE('2013-01-01'));

UPDATE calendar_table
SET ActivityId = 3
WHERE date IN (
		SELECT DATE('2013-01-12') + INTERVAL (a.i*100 + b.i*10 + c.i) * 1 month FROM ints a JOIN ints b JOIN ints c WHERE DATE('2013-01-12') + INTERVAL (a.i*100 + b.i*10 + c.i) * 2 week <= DATE('2015-12-31')
);

UPDATE calendar_table
SET isActivity = 1
WHERE date IN (
		SELECT DATE('2013-09-02') + INTERVAL (a.i*100 + b.i*10 + c.i) * 1 month FROM ints a JOIN ints b JOIN ints c WHERE DATE('2013-09-02') + INTERVAL (a.i*100 + b.i*10 + c.i) * 2 week <= DATE('2015-12-31')
);