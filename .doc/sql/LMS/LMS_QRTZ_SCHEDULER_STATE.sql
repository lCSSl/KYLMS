create table QRTZ_SCHEDULER_STATE
(
    sched_name        varchar(120) not null,
    instance_name     varchar(200) not null,
    last_checkin_time bigint       not null,
    checkin_interval  bigint       not null,
    primary key (sched_name, instance_name)
);

INSERT INTO LMS.QRTZ_SCHEDULER_STATE (sched_name, instance_name, last_checkin_time, checkin_interval) VALUES ('RuoyiScheduler', 'DESKTOP-9MRC11F1613917476918', 1613968299317, 15000);