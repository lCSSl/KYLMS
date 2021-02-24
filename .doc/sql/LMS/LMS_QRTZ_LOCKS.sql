create table QRTZ_LOCKS
(
    sched_name varchar(120) not null,
    lock_name  varchar(40)  not null,
    primary key (sched_name, lock_name)
);

INSERT INTO LMS.QRTZ_LOCKS (sched_name, lock_name) VALUES ('RuoyiScheduler', 'STATE_ACCESS');
INSERT INTO LMS.QRTZ_LOCKS (sched_name, lock_name) VALUES ('RuoyiScheduler', 'TRIGGER_ACCESS');