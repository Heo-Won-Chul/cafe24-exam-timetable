-- 학과
INSERT INTO DEPARTMENT VALUES ('COM', '컴퓨터공학과');


-- 과목
INSERT INTO SUBJECT VALUES ('COM_A', 'C', 1);
INSERT INTO SUBJECT VALUES ('COM_B', 'C++', 2);
INSERT INTO SUBJECT VALUES ('COM_C', 'C#', 3);
INSERT INTO SUBJECT VALUES ('COM_D', 'Java', 3);
INSERT INTO SUBJECT VALUES ('COM_E', 'Scala', 2);
INSERT INTO SUBJECT VALUES ('COM_F', 'Kotlin', 1);
INSERT INTO SUBJECT VALUES ('COM_G', 'go', 2);
INSERT INTO SUBJECT VALUES ('COM_H', 'python', 3);
INSERT INTO SUBJECT VALUES ('COM_I', 'swift', 2);
INSERT INTO SUBJECT VALUES ('COM_J', 'Object-C', 1);
INSERT INTO SUBJECT VALUES ('COM_K', 'javaScript', 3);
INSERT INTO SUBJECT VALUES ('COM_L', 'typeScript', 2);
INSERT INTO SUBJECT VALUES ('COM_M', 'PHP', 1);
INSERT INTO SUBJECT VALUES ('COM_N', 'Oracle', 2);
INSERT INTO SUBJECT VALUES ('COM_O', 'MySQL', 3);
INSERT INTO SUBJECT VALUES ('COM_P', 'MS-SQL', 2);
INSERT INTO SUBJECT VALUES ('COM_Q', 'CUBRID', 1);
INSERT INTO SUBJECT VALUES ('COM_R', 'CLOUD', 2);


-- 과목 시간
INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_A', 1, '09:00:00', '11:00:00');
INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_A', 3, '15:00:00', '17:00:00');
INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_A', 5, '11:00:00', '13:00:00');

INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_B', 2, '13:00:00', '15:00:00');
INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_B', 4, '09:00:00', '11:00:00');
INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_B', 1, '15:00:00', '17:00:00');

INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_C', 3, '11:00:00', '13:00:00');
INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_C', 5, '13:00:00', '15:00:00');
INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_C', 2, '09:00:00', '11:00:00');

INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_D', 4, '15:00:00', '17:00:00');
INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_D', 1, '11:00:00', '13:00:00');
INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_D', 3, '13:00:00', '15:00:00');

INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_E', 5, '09:00:00', '11:00:00');
INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_E', 2, '15:00:00', '17:00:00');
INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_E', 4, '11:00:00', '13:00:00');

INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_F', 1, '13:00:00', '15:00:00');
INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_F', 3, '09:00:00', '11:00:00');
INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_F', 5, '15:00:00', '17:00:00');

INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_G', 2, '11:00:00', '13:00:00');
INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_G', 4, '13:00:00', '15:00:00');
INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_G', 1, '09:00:00', '11:00:00');

INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_H', 3, '09:00:00', '11:00:00');
INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_H', 5, '11:00:00', '13:00:00');
INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_H', 2, '15:00:00', '17:00:00');

INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_I', 4, '09:00:00', '11:00:00');
INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_I', 1, '15:00:00', '17:00:00');
INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_I', 3, '11:00:00', '13:00:00');

INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_J', 5, '13:00:00', '15:00:00');
INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_J', 2, '09:00:00', '11:00:00');
INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_J', 4, '15:00:00', '17:00:00');

INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_K', 1, '11:00:00', '13:00:00');
INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_K', 3, '13:00:00', '15:00:00');
INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_K', 5, '09:00:00', '11:00:00');

INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_L', 2, '15:00:00', '17:00:00');
INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_L', 4, '11:00:00', '13:00:00');
INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_L', 1, '13:00:00', '15:00:00');

INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_M', 3, '09:00:00', '11:00:00');
INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_M', 5, '15:00:00', '17:00:00');
INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_M', 2, '11:00:00', '13:00:00');

INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_N', 4, '13:00:00', '15:00:00');
INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_N', 1, '09:00:00', '11:00:00');
INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_N', 3, '15:00:00', '17:00:00');

INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_O', 5, '11:00:00', '13:00:00');
INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_O', 2, '13:00:00', '15:00:00');
INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_O', 4, '09:00:00', '11:00:00');

INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_P', 1, '15:00:00', '17:00:00');
INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_P', 3, '11:00:00', '13:00:00');
INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_P', 5, '13:00:00', '15:00:00');

INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_Q', 2, '09:00:00', '11:00:00');
INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_Q', 4, '15:00:00', '17:00:00');
INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_Q', 1, '11:00:00', '13:00:00');

INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_R', 3, '13:00:00', '15:00:00');
INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_R', 5, '09:00:00', '11:00:00');
INSERT INTO SUBJECT_TIME(SUBJECT_CODE, DAY_OF_WEEK, START_TIME, END_TIME) VALUES ('COM_R', 2, '15:00:00', '17:00:00');