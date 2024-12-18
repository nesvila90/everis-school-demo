-- Insertar datos en la tabla SCHOOL
INSERT INTO SCHOOL (NAME) VALUES ('El colegio del Olimpo');

-- Insertar datos en la tabla COURSE
INSERT INTO COURSE (GRADE, SALOON, SCHOOL_ID) VALUES
                                                  ('10', 'A', 1),
                                                  ('10', 'B', 1),
                                                  ('11', 'A', 1),
                                                  ('11', 'B', 1);

-- Insertar datos en la tabla PROFESSOR
INSERT INTO PROFESSOR (NAME) VALUES
                                 ('Némesis'),
                                 ('Príapo'),
                                 ('Iris');

-- Insertar datos en la tabla SUBJECT (Asignaturas)
INSERT INTO SUBJECT (NAME, COURSE_ID, PROFESSOR_ID) VALUES
-- Curso 10A
('Matemáticas', 1, 1),
('Español', 1, 2),
('Inglés básico', 1, 3),
-- Curso 10B
('Matemáticas', 2, 1),
('Español', 2, 2),
('Inglés avanzado', 2, 3),
-- Curso 11A
('Matemáticas', 3, 1),
('Pre Icfes', 3, 1),
-- Curso 11B
('Matemáticas', 4, 1),
('Pre Icfes', 4, 1);

-- Insertar datos en la tabla STUDENT
INSERT INTO STUDENT (NAME) VALUES
                               ('Afrodita'), ('Apolo'), ('Ares'),
                               ('Artemisa'), ('Atenea'), ('Dionisio'),
                               ('Hefesto'), ('Hera'),
                               ('Hermes'), ('Hades'), ('Poseidón'), ('Zeus');

-- Insertar relaciones en la tabla SUBJECT_STUDENT
-- Curso 10A
INSERT INTO SUBJECT_STUDENT (SUBJECT_ID, STUDENT_ID) VALUES
                                                         (1, 1), (1, 2), (1, 3), -- Matemáticas 10A: Afrodita, Apolo, Ares
                                                         (2, 1), (2, 2), (2, 3), -- Español 10A: Afrodita, Apolo, Ares
                                                         (3, 1), (3, 2), (3, 3), -- Inglés básico 10A: Afrodita, Apolo, Ares

-- Curso 10B
                                                         (4, 4), (4, 5), (4, 6), -- Matemáticas 10B: Artemisa, Atenea, Dionisio
                                                         (5, 4), (5, 5), (5, 6), -- Español 10B: Artemisa, Atenea, Dionisio
                                                         (6, 4), (6, 5), (6, 6), -- Inglés avanzado 10B: Artemisa, Atenea, Dionisio

-- Curso 11A
                                                         (7, 7), (7, 8), -- Matemáticas 11A: Hefesto, Hera
                                                         (8, 7), (8, 8), -- Pre Icfes 11A: Hefesto, Hera

-- Curso 11B
                                                         (9, 9), (9, 10), (9, 11), (9, 12), -- Matemáticas 11B: Hermes, Hades, Poseidón, Zeus
                                                         (10, 9), (10, 10), (10, 11), (10, 12); -- Pre Icfes 11B: Hermes, Hades, Poseidón, Zeus
