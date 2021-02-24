create table sys_logininfor
(
    info_id     bigint auto_increment comment '访问ID'
        primary key,
    user_name   varchar(50)  default ''  null comment '用户账号',
    ipaddr      varchar(128) default ''  null comment '登录IP地址',
    status      char         default '0' null comment '登录状态（0成功 1失败）',
    msg         varchar(255) default ''  null comment '提示信息',
    access_time datetime                 null comment '访问时间'
)
    comment '系统访问记录';

INSERT INTO LMS.sys_logininfor (info_id, user_name, ipaddr, status, msg, access_time) VALUES (100, 'admin', '192.168.50.27', '0', '登录成功', '2021-02-21 09:13:18');
INSERT INTO LMS.sys_logininfor (info_id, user_name, ipaddr, status, msg, access_time) VALUES (101, 'admin', '192.168.50.27', '0', '登录成功', '2021-02-21 09:15:05');
INSERT INTO LMS.sys_logininfor (info_id, user_name, ipaddr, status, msg, access_time) VALUES (102, 'admin', '192.168.50.27', '0', '登录成功', '2021-02-21 09:35:24');
INSERT INTO LMS.sys_logininfor (info_id, user_name, ipaddr, status, msg, access_time) VALUES (103, 'admin', '192.168.50.27', '0', '登录成功', '2021-02-21 09:37:02');
INSERT INTO LMS.sys_logininfor (info_id, user_name, ipaddr, status, msg, access_time) VALUES (104, 'admin', '192.168.50.27', '0', '退出成功', '2021-02-21 09:38:13');
INSERT INTO LMS.sys_logininfor (info_id, user_name, ipaddr, status, msg, access_time) VALUES (105, 'admin', '192.168.50.27', '0', '登录成功', '2021-02-21 09:38:17');
INSERT INTO LMS.sys_logininfor (info_id, user_name, ipaddr, status, msg, access_time) VALUES (106, 'admin', '192.168.50.27', '1', '用户密码错误', '2021-02-21 09:45:44');
INSERT INTO LMS.sys_logininfor (info_id, user_name, ipaddr, status, msg, access_time) VALUES (107, 'admin', '192.168.50.27', '1', '用户密码错误', '2021-02-21 09:45:50');
INSERT INTO LMS.sys_logininfor (info_id, user_name, ipaddr, status, msg, access_time) VALUES (108, 'admin', '192.168.50.27', '0', '登录成功', '2021-02-21 09:46:04');
INSERT INTO LMS.sys_logininfor (info_id, user_name, ipaddr, status, msg, access_time) VALUES (109, 'admin', '192.168.50.27', '0', '登录成功', '2021-02-21 09:53:00');
INSERT INTO LMS.sys_logininfor (info_id, user_name, ipaddr, status, msg, access_time) VALUES (110, 'admin', '192.168.50.27', '1', '用户密码错误', '2021-02-21 14:11:35');
INSERT INTO LMS.sys_logininfor (info_id, user_name, ipaddr, status, msg, access_time) VALUES (111, 'admin', '192.168.50.27', '1', '用户密码错误', '2021-02-21 14:11:38');
INSERT INTO LMS.sys_logininfor (info_id, user_name, ipaddr, status, msg, access_time) VALUES (112, 'admin', '192.168.50.27', '0', '登录成功', '2021-02-21 14:11:59');
INSERT INTO LMS.sys_logininfor (info_id, user_name, ipaddr, status, msg, access_time) VALUES (113, 'admin', '192.168.50.27', '0', '退出成功', '2021-02-21 14:12:24');
INSERT INTO LMS.sys_logininfor (info_id, user_name, ipaddr, status, msg, access_time) VALUES (114, 'admin', '192.168.50.27', '0', '登录成功', '2021-02-21 14:12:26');
INSERT INTO LMS.sys_logininfor (info_id, user_name, ipaddr, status, msg, access_time) VALUES (115, 'admin', '192.168.50.27', '0', '登录成功', '2021-02-21 14:12:38');
INSERT INTO LMS.sys_logininfor (info_id, user_name, ipaddr, status, msg, access_time) VALUES (116, 'admin', '192.168.50.27', '0', '登录成功', '2021-02-21 14:12:42');
INSERT INTO LMS.sys_logininfor (info_id, user_name, ipaddr, status, msg, access_time) VALUES (117, 'admin', '192.168.50.27', '0', '登录成功', '2021-02-21 14:12:43');
INSERT INTO LMS.sys_logininfor (info_id, user_name, ipaddr, status, msg, access_time) VALUES (118, 'admin', '192.168.50.27', '0', '登录成功', '2021-02-21 14:12:44');
INSERT INTO LMS.sys_logininfor (info_id, user_name, ipaddr, status, msg, access_time) VALUES (119, 'admin', '192.168.50.27', '0', '登录成功', '2021-02-21 14:12:44');
INSERT INTO LMS.sys_logininfor (info_id, user_name, ipaddr, status, msg, access_time) VALUES (120, 'admin', '192.168.50.27', '1', '用户密码错误', '2021-02-21 14:13:42');
INSERT INTO LMS.sys_logininfor (info_id, user_name, ipaddr, status, msg, access_time) VALUES (121, 'admin', '192.168.50.27', '1', '用户密码错误', '2021-02-21 14:14:29');
INSERT INTO LMS.sys_logininfor (info_id, user_name, ipaddr, status, msg, access_time) VALUES (122, 'admin', '192.168.50.27', '1', '用户密码错误', '2021-02-21 14:15:44');
INSERT INTO LMS.sys_logininfor (info_id, user_name, ipaddr, status, msg, access_time) VALUES (123, 'admin', '192.168.50.27', '1', '用户密码错误', '2021-02-21 14:19:29');
INSERT INTO LMS.sys_logininfor (info_id, user_name, ipaddr, status, msg, access_time) VALUES (124, 'admin', '192.168.50.27', '1', '用户密码错误', '2021-02-21 14:20:43');
INSERT INTO LMS.sys_logininfor (info_id, user_name, ipaddr, status, msg, access_time) VALUES (125, 'admin', '192.168.50.27', '1', '用户密码错误', '2021-02-21 14:23:19');
INSERT INTO LMS.sys_logininfor (info_id, user_name, ipaddr, status, msg, access_time) VALUES (126, 'admin', '192.168.50.27', '1', '用户密码错误', '2021-02-21 14:23:25');
INSERT INTO LMS.sys_logininfor (info_id, user_name, ipaddr, status, msg, access_time) VALUES (127, 'admin', '192.168.50.27', '1', '用户密码错误', '2021-02-21 14:24:59');
INSERT INTO LMS.sys_logininfor (info_id, user_name, ipaddr, status, msg, access_time) VALUES (128, 'admin', '192.168.50.27', '0', '登录成功', '2021-02-21 14:25:16');
INSERT INTO LMS.sys_logininfor (info_id, user_name, ipaddr, status, msg, access_time) VALUES (129, 'admin', '192.168.50.27', '0', '登录成功', '2021-02-21 14:26:05');
INSERT INTO LMS.sys_logininfor (info_id, user_name, ipaddr, status, msg, access_time) VALUES (130, 'admin', '192.168.50.27', '0', '登录成功', '2021-02-21 14:28:57');
INSERT INTO LMS.sys_logininfor (info_id, user_name, ipaddr, status, msg, access_time) VALUES (131, 'admin', '192.168.50.27', '0', '登录成功', '2021-02-21 14:30:12');
INSERT INTO LMS.sys_logininfor (info_id, user_name, ipaddr, status, msg, access_time) VALUES (132, 'admin', '192.168.50.27', '0', '退出成功', '2021-02-21 14:47:57');
INSERT INTO LMS.sys_logininfor (info_id, user_name, ipaddr, status, msg, access_time) VALUES (133, 'admin', '192.168.50.27', '0', '登录成功', '2021-02-21 14:48:25');
INSERT INTO LMS.sys_logininfor (info_id, user_name, ipaddr, status, msg, access_time) VALUES (134, 'admin', '192.168.50.27', '1', '用户密码错误', '2021-02-21 14:57:24');
INSERT INTO LMS.sys_logininfor (info_id, user_name, ipaddr, status, msg, access_time) VALUES (135, 'admin', '192.168.50.27', '0', '登录成功', '2021-02-21 14:57:31');
INSERT INTO LMS.sys_logininfor (info_id, user_name, ipaddr, status, msg, access_time) VALUES (136, 'admin', '192.168.50.27', '0', '登录成功', '2021-02-21 15:00:08');
INSERT INTO LMS.sys_logininfor (info_id, user_name, ipaddr, status, msg, access_time) VALUES (137, 'admin', '192.168.50.27', '0', '登录成功', '2021-02-21 15:00:21');
INSERT INTO LMS.sys_logininfor (info_id, user_name, ipaddr, status, msg, access_time) VALUES (138, 'admin', '192.168.50.27', '1', '用户密码错误', '2021-02-22 01:45:57');
INSERT INTO LMS.sys_logininfor (info_id, user_name, ipaddr, status, msg, access_time) VALUES (139, 'admin', '192.168.50.27', '0', '登录成功', '2021-02-22 01:46:08');
INSERT INTO LMS.sys_logininfor (info_id, user_name, ipaddr, status, msg, access_time) VALUES (140, 'admin', '192.168.50.27', '0', '登录成功', '2021-02-22 01:48:32');
INSERT INTO LMS.sys_logininfor (info_id, user_name, ipaddr, status, msg, access_time) VALUES (141, 'admin', '192.168.50.27', '0', '登录成功', '2021-02-24 07:50:53');