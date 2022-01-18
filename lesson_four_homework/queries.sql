-- Сделать запрос, считающий и выводящий в понятном виде ошибки в расписании 
    -- (фильмы накладываются друг на друга), отсортированные по возрастанию времени.
    -- Выводить надо колонки «фильм 1», «время начала», «длительность», «фильм 2», «время начала», «длительность».
    
    SELECT 
    f1.title AS 'фильм1',
    f1.start AS 'время начала',
    f1.duration AS 'длительность',
    f2.title AS 'фильм2',
    f2.start AS 'время начала',
    f2.duration AS 'длительность'
FROM
    (SELECT 
        f.title, fs1.start, f.duration
    FROM
        film_shows fs1
    JOIN (SELECT 
        f.id, f.title, fd.duration
    FROM
        films f
    JOIN film_durations fd ON f.duration_id = fd.id) f ON fs1.film_id = f.id) f1
        JOIN
    (SELECT 
        f.title, fs1.start, f.duration
    FROM
        film_shows fs1
    JOIN (SELECT 
        f.id, f.title, fd.duration
    FROM
        films f
    JOIN film_durations fd ON f.duration_id = fd.id) f ON fs1.film_id = f.id) f2 
    ON f1.start+f1.duration>(SELECT MIN(f2.start) WHERE f2.start > f1.start)
    ORDER BY f1.start+f1.duration-f2.start;
    
    -- Сделать запрос, считающий и выводящий в понятном виде перерывы 30 минут и более между фильмами —
    -- выводить по уменьшению длительности перерыва. Колонки «фильм 1», «время начала», «длительность», 
    -- «время начала второго фильма», «длительность перерыва».

WITH
film_pairs AS (
SELECT 
    f1.title AS film1,
    f1.start AS start_time,
    f1.duration AS duration,
    MIN(f2.start) AS start_time_two,
    timediff(MIN(f2.start), addtime(f1.start, f1.duration)) AS break_length
FROM
    (SELECT 
        fs1.id, f.title, fs1.start, f.duration
    FROM
        film_shows fs1
    JOIN (SELECT 
        f.id, f.title, fd.duration
    FROM
        films f
    JOIN film_durations fd ON f.duration_id = fd.id) f ON fs1.film_id = f.id) f1
        JOIN
    (SELECT 
        f.title, fs1.start, f.duration
    FROM
        film_shows fs1
    JOIN (SELECT 
        f.id, f.title, fd.duration
    FROM
        films f
    JOIN film_durations fd ON f.duration_id = fd.id) f ON fs1.film_id = f.id) f2 ON f1.start < f2.start
GROUP BY f1.id)
SELECT
fp.film1 AS 'фильм 1',
fp.start_time AS 'время начала',
fp.duration AS 'длительность',
fp.start_time_two AS 'время начала второго фильма',
fp.break_length AS 'длительность перерыва'
FROM film_pairs fp
WHERE fp.break_length>'00:30:00'
ORDER BY break_length DESC;

-- Сделать запрос, выводящий список фильмов, для каждого — с указанием общего числа посетителей за все время,
-- среднего числа зрителей за сеанс и общей суммы сборов по каждому фильму (отсортировать по убыванию прибыли).
-- Внизу таблицы должна быть строчка «итого», содержащая данные по всем фильмам сразу;

(WITH
film_show_stats AS (
SELECT 
    fs.id AS film_show_id,
    f.id AS film_id,
    f.title AS film_title,
    COUNT(t.id) AS no_of_spectators,
    SUM(fs.fee) AS revenue
FROM
    film_shows fs
        RIGHT JOIN
    tickets t ON fs.id = t.film_show_id
        JOIN
    films f ON fs.film_id = f.id
GROUP BY fs.id
) SELECT 
    fss.film_title AS 'название фильма',
    sum(fss.no_of_spectators) AS 'общее число зрителей',
    avg(fss.no_of_spectators) AS 'среднее число зрителей',
    sum(fss.revenue) AS 'сумма сборов'
FROM
    film_show_stats fss
GROUP BY fss.film_id
ORDER BY sum(fss.revenue) DESC)
UNION ALL
SELECT
    'Итого:',
    sum(fss.no_of_spectators),
    sum(fss.no_of_spectators),
    sum(fss.revenue)
FROM
    film_show_stats fss;
    
    -- Сделать запрос, выводящий число посетителей и кассовые сборы, сгруппированные по времени начала фильма:
    -- с 9 до 15, с 15 до 18, с 18 до 21, с 21 до 00:00 (сколько посетителей пришло с 9 до 15 часов и т.д.)
    
    SELECT 
    tr.range_label AS 'период',
    COUNT(t.id) AS 'число посетителей',
    SUM(fs.fee) AS 'кассовые сборы'
FROM
    time_ranges tr
        JOIN
    film_shows fs ON TIME(fs.start) BETWEEN tr.beginning AND tr.end
        JOIN
    tickets t ON fs.id = t.film_show_id
GROUP BY tr.id;