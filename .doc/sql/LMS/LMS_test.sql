create table test
(
    id          bigint auto_increment
        primary key,
    title       varchar(64)             not null comment '标题',
    parent_id   bigint      default 0   not null,
    del_flag    char        default '0' null comment '删除标志（0代表存在 2代表删除）',
    create_by   varchar(64) default ''  null comment '创建者',
    create_time datetime                null comment '创建时间',
    update_by   varchar(64) default ''  null comment '更新者',
    update_time datetime                null comment '更新时间',
    remark      varchar(500)            null comment '备注'
)
    comment '测试表';

INSERT INTO LMS.test (id, title, parent_id, del_flag, create_by, create_time, update_by, update_time, remark) VALUES (1, 'agaasdas', 0, '0', '', null, '', null, 'asdasdasd');
INSERT INTO LMS.test (id, title, parent_id, del_flag, create_by, create_time, update_by, update_time, remark) VALUES (2, 'hahaha', 0, '1', '', null, '', null, 'asdasdas');
INSERT INTO LMS.test (id, title, parent_id, del_flag, create_by, create_time, update_by, update_time, remark) VALUES (123, 'hahaha', 0, '1', '', null, '', null, 'asdasdas');
INSERT INTO LMS.test (id, title, parent_id, del_flag, create_by, create_time, update_by, update_time, remark) VALUES (1363717709576167432, '奥术大师大所', 0, '1', '', null, '', null, '大叔大婶多asdas');