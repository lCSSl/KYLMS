create table gen_table_column
(
    column_id      bigint auto_increment comment '编号'
        primary key,
    table_id       varchar(64)               null comment '归属表编号',
    column_name    varchar(200)              null comment '列名称',
    column_comment varchar(500)              null comment '列描述',
    column_type    varchar(100)              null comment '列类型',
    java_type      varchar(500)              null comment 'JAVA类型',
    java_field     varchar(200)              null comment 'JAVA字段名',
    is_pk          char                      null comment '是否主键（1是）',
    is_increment   char                      null comment '是否自增（1是）',
    is_required    char                      null comment '是否必填（1是）',
    is_insert      char                      null comment '是否为插入字段（1是）',
    is_edit        char                      null comment '是否编辑字段（1是）',
    is_list        char                      null comment '是否列表字段（1是）',
    is_query       char                      null comment '是否查询字段（1是）',
    query_type     varchar(200) default 'EQ' null comment '查询方式（等于、不等于、大于、小于、范围）',
    html_type      varchar(200)              null comment '显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）',
    dict_type      varchar(200) default ''   null comment '字典类型',
    sort           int                       null comment '排序',
    create_by      varchar(64)  default ''   null comment '创建者',
    create_time    datetime                  null comment '创建时间',
    update_by      varchar(64)  default ''   null comment '更新者',
    update_time    datetime                  null comment '更新时间'
)
    comment '代码生成业务表字段';

INSERT INTO LMS.gen_table_column (column_id, table_id, column_name, column_comment, column_type, java_type, java_field, is_pk, is_increment, is_required, is_insert, is_edit, is_list, is_query, query_type, html_type, dict_type, sort, create_by, create_time, update_by, update_time) VALUES (1, '1', 'id', 'ID', 'bigint', 'Long', 'id', '1', '1', null, '1', null, null, null, 'EQ', 'input', '', 1, 'admin', '2021-02-22 02:05:28', '', '2021-02-22 08:50:44');
INSERT INTO LMS.gen_table_column (column_id, table_id, column_name, column_comment, column_type, java_type, java_field, is_pk, is_increment, is_required, is_insert, is_edit, is_list, is_query, query_type, html_type, dict_type, sort, create_by, create_time, update_by, update_time) VALUES (2, '1', 'title', '标题', 'varchar(64)', 'String', 'title', '0', '0', '1', '1', '1', '1', '1', 'LIKE', 'input', '', 2, 'admin', '2021-02-22 02:05:28', '', '2021-02-22 08:50:44');
INSERT INTO LMS.gen_table_column (column_id, table_id, column_name, column_comment, column_type, java_type, java_field, is_pk, is_increment, is_required, is_insert, is_edit, is_list, is_query, query_type, html_type, dict_type, sort, create_by, create_time, update_by, update_time) VALUES (3, '1', 'parent_id', '父级ID', 'bigint', 'Long', 'parentId', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 3, 'admin', '2021-02-22 02:05:28', '', '2021-02-22 08:50:44');
INSERT INTO LMS.gen_table_column (column_id, table_id, column_name, column_comment, column_type, java_type, java_field, is_pk, is_increment, is_required, is_insert, is_edit, is_list, is_query, query_type, html_type, dict_type, sort, create_by, create_time, update_by, update_time) VALUES (8, '1', 'del_flag', '删除标志（0代表存在 2代表删除）', 'char(1)', 'String', 'delFlag', '0', '0', null, null, '1', null, '1', 'EQ', 'input', '', 4, '', '2021-02-22 04:39:41', '', '2021-02-22 08:50:44');
INSERT INTO LMS.gen_table_column (column_id, table_id, column_name, column_comment, column_type, java_type, java_field, is_pk, is_increment, is_required, is_insert, is_edit, is_list, is_query, query_type, html_type, dict_type, sort, create_by, create_time, update_by, update_time) VALUES (11, '1', 'create_by', '创建者', 'varchar(64)', 'String', 'createBy', '0', '0', null, '1', null, null, '1', 'LIKE', 'input', '', 7, '', '2021-02-22 04:39:41', '', '2021-02-22 08:50:44');
INSERT INTO LMS.gen_table_column (column_id, table_id, column_name, column_comment, column_type, java_type, java_field, is_pk, is_increment, is_required, is_insert, is_edit, is_list, is_query, query_type, html_type, dict_type, sort, create_by, create_time, update_by, update_time) VALUES (12, '1', 'create_time', '创建时间', 'datetime', 'Date', 'createTime', '0', '0', null, '1', null, null, '1', 'BETWEEN', 'datetime', '', 8, '', '2021-02-22 04:39:41', '', '2021-02-22 08:50:44');
INSERT INTO LMS.gen_table_column (column_id, table_id, column_name, column_comment, column_type, java_type, java_field, is_pk, is_increment, is_required, is_insert, is_edit, is_list, is_query, query_type, html_type, dict_type, sort, create_by, create_time, update_by, update_time) VALUES (13, '1', 'update_by', '更新者', 'varchar(64)', 'String', 'updateBy', '0', '0', null, '1', '1', null, '1', 'EQ', 'input', '', 9, '', '2021-02-22 04:39:41', '', '2021-02-22 08:50:44');
INSERT INTO LMS.gen_table_column (column_id, table_id, column_name, column_comment, column_type, java_type, java_field, is_pk, is_increment, is_required, is_insert, is_edit, is_list, is_query, query_type, html_type, dict_type, sort, create_by, create_time, update_by, update_time) VALUES (14, '1', 'update_time', '更新时间', 'datetime', 'Date', 'updateTime', '0', '0', null, '1', '1', null, '1', 'BETWEEN', 'datetime', '', 10, '', '2021-02-22 04:39:41', '', '2021-02-22 08:50:44');
INSERT INTO LMS.gen_table_column (column_id, table_id, column_name, column_comment, column_type, java_type, java_field, is_pk, is_increment, is_required, is_insert, is_edit, is_list, is_query, query_type, html_type, dict_type, sort, create_by, create_time, update_by, update_time) VALUES (15, '1', 'remark', '备注', 'varchar(500)', 'String', 'remark', '0', '0', null, '1', '1', '1', null, 'EQ', 'textarea', '', 11, '', '2021-02-22 04:39:41', '', '2021-02-22 08:50:44');