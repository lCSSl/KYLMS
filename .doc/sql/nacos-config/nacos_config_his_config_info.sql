create table his_config_info
(
    id           bigint unsigned                        not null,
    nid          bigint unsigned auto_increment
        primary key,
    data_id      varchar(255)                           not null,
    group_id     varchar(128)                           not null,
    app_name     varchar(128)                           null comment 'app_name',
    content      longtext                               not null,
    md5          varchar(32)                            null,
    gmt_create   datetime     default CURRENT_TIMESTAMP not null,
    gmt_modified datetime     default CURRENT_TIMESTAMP not null,
    src_user     text                                   null,
    src_ip       varchar(20)                            null,
    op_type      char(10)                               null,
    tenant_id    varchar(128) default ''                null comment '租户字段'
)
    comment '多租户改造' collate = utf8_bin;

create index idx_did
    on his_config_info (data_id);

create index idx_gmt_create
    on his_config_info (gmt_create);

create index idx_gmt_modified
    on his_config_info (gmt_modified);

INSERT INTO `nacos-config`.his_config_info (id, nid, data_id, group_id, app_name, content, md5, gmt_create, gmt_modified, src_user, src_ip, op_type, tenant_id) VALUES (8, 1, 'kylms-file-dev.yml', 'DEFAULT_GROUP', '', '# 本地文件上传    
file:
    domain: http://127.0.0.1:9300
    path: D:/ruoyi/uploadPath
    prefix: /statics

# FastDFS配置
fdfs:
  domain: http://8.129.231.12
  soTimeout: 3000
  connectTimeout: 2000
  trackerList: 8.129.231.12:22122

# Minio配置
minio:
  url: http://8.129.231.12:9000
  accessKey: minioadmin
  secretKey: minioadmin
  bucketName: test', '5382b93f3d8059d6068c0501fdd41195', '2021-02-21 09:00:52', '2021-02-21 09:00:52', null, '172.17.0.1', 'U', '');
INSERT INTO `nacos-config`.his_config_info (id, nid, data_id, group_id, app_name, content, md5, gmt_create, gmt_modified, src_user, src_ip, op_type, tenant_id) VALUES (2, 2, 'kylms-gateway-dev.yml', 'DEFAULT_GROUP', '', 'spring:
  redis:
    host: localhost
    port: 6379
    password: 
  cloud:
    gateway:
      discovery:
        locator:
          lowerCaseServiceId: true
          enabled: true
      routes:
        # 认证中心
        - id: kylms-auth
          uri: lb://kylms-auth
          predicates:
            - Path=/auth/**
          filters:
            # 验证码处理
            - CacheRequestFilter
            - ValidateCodeFilter
            - StripPrefix=1
        # 代码生成
        - id: kylms-gen
          uri: lb://kylms-gen
          predicates:
            - Path=/code/**
          filters:
            - StripPrefix=1
        # 定时任务
        - id: kylms-job
          uri: lb://kylms-job
          predicates:
            - Path=/schedule/**
          filters:
            - StripPrefix=1
        # 系统模块
        - id: kylms-system
          uri: lb://kylms-system
          predicates:
            - Path=/system/**
          filters:
            - StripPrefix=1
        # 文件服务
        - id: kylms-file
          uri: lb://kylms-file
          predicates:
            - Path=/file/**
          filters:
            - StripPrefix=1

# 不校验白名单
ignore:
  whites:
    - /auth/logout
    - /auth/login
    - /*/v2/api-docs
    - /csrf
', '4f5aff3bee6054f1309db0fd0042be14', '2021-02-21 09:11:17', '2021-02-21 09:11:18', null, '172.17.0.1', 'U', '');
INSERT INTO `nacos-config`.his_config_info (id, nid, data_id, group_id, app_name, content, md5, gmt_create, gmt_modified, src_user, src_ip, op_type, tenant_id) VALUES (1, 3, 'application-dev.yml', 'DEFAULT_GROUP', '', 'spring:
  main:
    allow-bean-definition-overriding: true
  autoconfigure:
    exclude: com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure

#请求处理的超时时间
ribbon:
  ReadTimeout: 10000
  ConnectTimeout: 10000

# feign 配置
feign:
  sentinel:
    enabled: true
  okhttp:
    enabled: true
  httpclient:
    enabled: false
  client:
    config:
      default:
        connectTimeout: 10000
        readTimeout: 10000
  compression:
    request:
      enabled: true
    response:
      enabled: true

# 暴露监控端点
management:
  endpoints:
    web:
      exposure:
        include: ''*''
', 'c07e6f7321493f6d5390d0a08bffb75a', '2021-02-21 09:27:13', '2021-02-21 09:27:14', null, '172.17.0.1', 'U', '');
INSERT INTO `nacos-config`.his_config_info (id, nid, data_id, group_id, app_name, content, md5, gmt_create, gmt_modified, src_user, src_ip, op_type, tenant_id) VALUES (2, 4, 'kylms-gateway-dev.yml', 'DEFAULT_GROUP', '', 'spring:
  redis:
    host: localhost
    port: 6379
    password: 
  cloud:
    gateway:
      discovery:
        locator:
          lowerCaseServiceId: true
          enabled: true
      routes:
        # 认证中心
        - id: kylms-auth
          uri: lb://kylms-auth
          predicates:
            - Path=/auth/**
          filters:
            # 验证码处理
            - CacheRequestFilter
            - ValidateCodeFilter
            - StripPrefix=1
        # 代码生成
        - id: kylms-gen
          uri: lb://kylms-gen
          predicates:
            - Path=/code/**
          filters:
            - StripPrefix=1
        # 定时任务
        - id: kylms-job
          uri: lb://kylms-job
          predicates:
            - Path=/schedule/**
          filters:
            - StripPrefix=1
        # 系统模块
        - id: kylms-system
          uri: lb://kylms-system
          predicates:
            - Path=/system/**
          filters:
            - StripPrefix=1
        # 文件服务
        - id: kylms-file
          uri: lb://kylms-file
          predicates:
            - Path=/file/**
          filters:
            - StripPrefix=1

# 不校验白名单
ignore:
  whites:
    - /auth/logout
    - /auth/login
    - /*/v2/api-docs
    - /csrf', '34c6821f098a405f80c1c72d112482e4', '2021-02-21 09:27:37', '2021-02-21 09:27:37', null, '172.17.0.1', 'U', '');
INSERT INTO `nacos-config`.his_config_info (id, nid, data_id, group_id, app_name, content, md5, gmt_create, gmt_modified, src_user, src_ip, op_type, tenant_id) VALUES (3, 5, 'kylms-auth-dev.yml', 'DEFAULT_GROUP', '', 'spring: 
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/LMS?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8
    username: root
    password: password
  redis:
    host: localhost
    port: 6379
    password: 
', '0636e66b0c3578d38c8ccc34ea1be5f0', '2021-02-21 09:27:45', '2021-02-21 09:27:45', null, '172.17.0.1', 'U', '');
INSERT INTO `nacos-config`.his_config_info (id, nid, data_id, group_id, app_name, content, md5, gmt_create, gmt_modified, src_user, src_ip, op_type, tenant_id) VALUES (4, 6, 'kylms-monitor-dev.yml', 'DEFAULT_GROUP', '', '# spring
spring: 
  security:
    user:
      name: ruoyi
      password: 123456
  boot:
    admin:
      ui:
        title: 若依服务状态监控
', 'd8997d0707a2fd5d9fc4e8409da38129', '2021-02-21 09:27:58', '2021-02-21 09:27:58', null, '172.17.0.1', 'U', '');
INSERT INTO `nacos-config`.his_config_info (id, nid, data_id, group_id, app_name, content, md5, gmt_create, gmt_modified, src_user, src_ip, op_type, tenant_id) VALUES (5, 7, 'kylms-system-dev.yml', 'DEFAULT_GROUP', '', '# spring配置
spring: 
  redis:
    host: localhost
    port: 6379
    password: 
  datasource:
    druid:
      stat-view-servlet:
        enabled: true
        loginUsername: admin
        loginPassword: 123456
    dynamic:
      druid:
        initial-size: 5
        min-idle: 5
        maxActive: 20
        maxWait: 60000
        timeBetweenEvictionRunsMillis: 60000
        minEvictableIdleTimeMillis: 300000
        validationQuery: SELECT 1 FROM DUAL
        testWhileIdle: true
        testOnBorrow: false
        testOnReturn: false
        poolPreparedStatements: true
        maxPoolPreparedStatementPerConnectionSize: 20
        filters: stat,wall,slf4j
        connectionProperties: druid.stat.mergeSql\\=true;druid.stat.slowSqlMillis\\=5000
      datasource:
          # 主库数据源
          master:
            driver-class-name: com.mysql.cj.jdbc.Driver
            url: jdbc:mysql://localhost:3306/LMS?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8
            username: root
            password: password
          # 从库数据源
          # slave:
            # username: 
            # password: 
            # url: 
            # driver-class-name: 
      # seata: true    # 开启seata代理，开启后默认每个数据源都代理，如果某个不需要代理可单独关闭

# seata配置
seata:
  # 默认关闭，如需启用spring.datasource.dynami.seata需要同时开启
  enabled: false
  # Seata 应用编号，默认为 ${spring.application.name}
  application-id: ${spring.application.name}
  # Seata 事务组编号，用于 TC 集群名
  tx-service-group: ${spring.application.name}-group
  # 关闭自动代理
  enable-auto-data-source-proxy: false
  # 服务配置项
  service:
    # 虚拟组和分组的映射
    vgroup-mapping:
      kylms-system-group: default
  config:
    type: nacos
    nacos:
      serverAddr: 127.0.0.1:8848
      group: SEATA_GROUP
      namespace:
  registry:
    type: nacos
    nacos:
      application: seata-server
      server-addr: 127.0.0.1:8848
      namespace:

# mybatis配置
mybatis:
    # 搜索指定包别名
    typeAliasesPackage: com.kaiyu56.system
    # 配置mapper的扫描，找到所有的mapper.xml映射文件
    mapperLocations: classpath:mapper/**/*.xml

# swagger配置
swagger:
  title: 系统模块接口文档
  license: Powered By ruoyi
  licenseUrl: https://ruoyi.vip', '977a4d9c5c141040961a4f5cb0c0ef48', '2021-02-21 09:28:09', '2021-02-21 09:28:09', null, '172.17.0.1', 'U', '');
INSERT INTO `nacos-config`.his_config_info (id, nid, data_id, group_id, app_name, content, md5, gmt_create, gmt_modified, src_user, src_ip, op_type, tenant_id) VALUES (6, 8, 'kylms-gen-dev.yml', 'DEFAULT_GROUP', '', '# spring配置
spring: 
  redis:
    host: localhost
    port: 6379
    password: 
  datasource: 
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/LMS?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8
    username: root
    password: password

# mybatis配置
mybatis:
    # 搜索指定包别名
    typeAliasesPackage: com.kaiyu56.gen.domain
    # 配置mapper的扫描，找到所有的mapper.xml映射文件
    mapperLocations: classpath:mapper/**/*.xml

# swagger配置
swagger:
  title: 代码生成接口文档
  license: Powered By ruoyi
  licenseUrl: https://ruoyi.vip

# 代码生成
gen: 
  # 作者
  author: ruoyi
  # 默认生成包路径 system 需改成自己的模块名称 如 system monitor tool
  packageName: com.kaiyu56.system
  # 自动去除表前缀，默认是false
  autoRemovePre: false
  # 表前缀（生成类名不会包含表前缀，多个用逗号分隔）
  tablePrefix: sys_
', 'a2754d2561a9f8aed7280581a7ef120c', '2021-02-21 09:28:19', '2021-02-21 09:28:19', null, '172.17.0.1', 'U', '');
INSERT INTO `nacos-config`.his_config_info (id, nid, data_id, group_id, app_name, content, md5, gmt_create, gmt_modified, src_user, src_ip, op_type, tenant_id) VALUES (7, 9, 'kylms-job-dev.yml', 'DEFAULT_GROUP', '', '# spring配置
spring: 
  redis:
    host: localhost
    port: 6379
    password: 
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/LMS?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8
    username: root
    password: password

# mybatis配置
mybatis:
    # 搜索指定包别名
    typeAliasesPackage: com.kaiyu56.job.domain
    # 配置mapper的扫描，找到所有的mapper.xml映射文件
    mapperLocations: classpath:mapper/**/*.xml

# swagger配置
swagger:
  title: 定时任务接口文档
  license: Powered By ruoyi
  licenseUrl: https://ruoyi.vip
', '4a89b3c57ef2481a27fd6a72e706d0b2', '2021-02-21 09:28:26', '2021-02-21 09:28:26', null, '172.17.0.1', 'U', '');
INSERT INTO `nacos-config`.his_config_info (id, nid, data_id, group_id, app_name, content, md5, gmt_create, gmt_modified, src_user, src_ip, op_type, tenant_id) VALUES (9, 10, 'sentinel-kylms-gateway', 'DEFAULT_GROUP', '', '[
    {
        "resource": "kylms-auth",
        "count": 500,
        "grade": 1,
        "limitApp": "default",
        "strategy": 0,
        "controlBehavior": 0
    },
	{
        "resource": "kylms-system",
        "count": 1000,
        "grade": 1,
        "limitApp": "default",
        "strategy": 0,
        "controlBehavior": 0
    },
	{
        "resource": "kylms-gen",
        "count": 200,
        "grade": 1,
        "limitApp": "default",
        "strategy": 0,
        "controlBehavior": 0
    },
	{
        "resource": "kylms-job",
        "count": 300,
        "grade": 1,
        "limitApp": "default",
        "strategy": 0,
        "controlBehavior": 0
    }
]', '25929f31c6766d251b3160b6d3ae71d5', '2021-02-21 09:28:35', '2021-02-21 09:28:36', null, '172.17.0.1', 'U', '');
INSERT INTO `nacos-config`.his_config_info (id, nid, data_id, group_id, app_name, content, md5, gmt_create, gmt_modified, src_user, src_ip, op_type, tenant_id) VALUES (8, 11, 'kylms-file-dev.yml', 'DEFAULT_GROUP', '', '# 本地文件上传    
file:
    domain: http://127.0.0.1:9300
    path: E:/resources/ruoyi/uploadPath
    prefix: /statics

# FastDFS配置
fdfs:
  domain: http://8.129.231.12
  soTimeout: 3000
  connectTimeout: 2000
  trackerList: 8.129.231.12:22122

# Minio配置
minio:
  url: http://8.129.231.12:9000
  accessKey: minioadmin
  secretKey: minioadmin
  bucketName: test', 'eef7fa5473278cc7cf25c825563dbacf', '2021-02-21 09:28:43', '2021-02-21 09:28:44', null, '172.17.0.1', 'U', '');
INSERT INTO `nacos-config`.his_config_info (id, nid, data_id, group_id, app_name, content, md5, gmt_create, gmt_modified, src_user, src_ip, op_type, tenant_id) VALUES (0, 12, 'kylms-test-dev.yml', 'DEFAULT_GROUP', '', '# spring配置
spring: 
  redis:
    host: localhost
    port: 6379
    password: 
  datasource:
    druid:
      stat-view-servlet:
        enabled: true
        loginUsername: admin
        loginPassword: 123456
    dynamic:
      druid:
        initial-size: 5
        min-idle: 5
        maxActive: 20
        maxWait: 60000
        timeBetweenEvictionRunsMillis: 60000
        minEvictableIdleTimeMillis: 300000
        validationQuery: SELECT 1 FROM DUAL
        testWhileIdle: true
        testOnBorrow: false
        testOnReturn: false
        poolPreparedStatements: true
        maxPoolPreparedStatementPerConnectionSize: 20
        filters: stat,wall,slf4j
        connectionProperties: druid.stat.mergeSql\\=true;druid.stat.slowSqlMillis\\=5000
      datasource:
          # 主库数据源
          master:
            driver-class-name: com.mysql.cj.jdbc.Driver
            url: jdbc:mysql://localhost:3306/LMS?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8
            username: root
            password: password
          # 从库数据源
          # slave:
            # username: 
            # password: 
            # url: 
            # driver-class-name: 
      # seata: true    # 开启seata代理，开启后默认每个数据源都代理，如果某个不需要代理可单独关闭

# seata配置
seata:
  # 默认关闭，如需启用spring.datasource.dynami.seata需要同时开启
  enabled: false
  # Seata 应用编号，默认为 ${spring.application.name}
  application-id: ${spring.application.name}
  # Seata 事务组编号，用于 TC 集群名
  tx-service-group: ${spring.application.name}-group
  # 关闭自动代理
  enable-auto-data-source-proxy: false
  # 服务配置项
  service:
    # 虚拟组和分组的映射
    vgroup-mapping:
      kylms-system-group: default
  config:
    type: nacos
    nacos:
      serverAddr: 127.0.0.1:8848
      group: SEATA_GROUP
      namespace:
  registry:
    type: nacos
    nacos:
      application: seata-server
      server-addr: 127.0.0.1:8848
      namespace:

# mybatis配置
mybatis:
    # 搜索指定包别名
    typeAliasesPackage: com.kaiyu56.system
    # 配置mapper的扫描，找到所有的mapper.xml映射文件
    mapperLocations: classpath:mapper/**/*.xml

# swagger配置
swagger:
  title: 系统模块接口文档
  license: Powered By ruoyi
  licenseUrl: https://ruoyi.vip', '977a4d9c5c141040961a4f5cb0c0ef48', '2021-02-22 02:45:06', '2021-02-22 02:45:06', null, '172.17.0.1', 'I', '');
INSERT INTO `nacos-config`.his_config_info (id, nid, data_id, group_id, app_name, content, md5, gmt_create, gmt_modified, src_user, src_ip, op_type, tenant_id) VALUES (21, 13, 'kylms-test-dev.yml', 'DEFAULT_GROUP', '', '# spring配置
spring: 
  redis:
    host: localhost
    port: 6379
    password: 
  datasource:
    druid:
      stat-view-servlet:
        enabled: true
        loginUsername: admin
        loginPassword: 123456
    dynamic:
      druid:
        initial-size: 5
        min-idle: 5
        maxActive: 20
        maxWait: 60000
        timeBetweenEvictionRunsMillis: 60000
        minEvictableIdleTimeMillis: 300000
        validationQuery: SELECT 1 FROM DUAL
        testWhileIdle: true
        testOnBorrow: false
        testOnReturn: false
        poolPreparedStatements: true
        maxPoolPreparedStatementPerConnectionSize: 20
        filters: stat,wall,slf4j
        connectionProperties: druid.stat.mergeSql\\=true;druid.stat.slowSqlMillis\\=5000
      datasource:
          # 主库数据源
          master:
            driver-class-name: com.mysql.cj.jdbc.Driver
            url: jdbc:mysql://localhost:3306/LMS?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8
            username: root
            password: password
          # 从库数据源
          # slave:
            # username: 
            # password: 
            # url: 
            # driver-class-name: 
      # seata: true    # 开启seata代理，开启后默认每个数据源都代理，如果某个不需要代理可单独关闭

# seata配置
seata:
  # 默认关闭，如需启用spring.datasource.dynami.seata需要同时开启
  enabled: false
  # Seata 应用编号，默认为 ${spring.application.name}
  application-id: ${spring.application.name}
  # Seata 事务组编号，用于 TC 集群名
  tx-service-group: ${spring.application.name}-group
  # 关闭自动代理
  enable-auto-data-source-proxy: false
  # 服务配置项
  service:
    # 虚拟组和分组的映射
    vgroup-mapping:
      kylms-system-group: default
  config:
    type: nacos
    nacos:
      serverAddr: 127.0.0.1:8848
      group: SEATA_GROUP
      namespace:
  registry:
    type: nacos
    nacos:
      application: seata-server
      server-addr: 127.0.0.1:8848
      namespace:

# mybatis配置
mybatis:
    # 搜索指定包别名
    typeAliasesPackage: com.kaiyu56.system
    # 配置mapper的扫描，找到所有的mapper.xml映射文件
    mapperLocations: classpath:mapper/**/*.xml

# swagger配置
swagger:
  title: 系统模块接口文档
  license: Powered By ruoyi
  licenseUrl: https://ruoyi.vip', '977a4d9c5c141040961a4f5cb0c0ef48', '2021-02-22 02:45:34', '2021-02-22 02:45:35', null, '172.17.0.1', 'U', '');
INSERT INTO `nacos-config`.his_config_info (id, nid, data_id, group_id, app_name, content, md5, gmt_create, gmt_modified, src_user, src_ip, op_type, tenant_id) VALUES (2, 14, 'kylms-gateway-dev.yml', 'DEFAULT_GROUP', '', 'spring:
  redis:
    host: localhost
    port: 6379
    password: 
  cloud:
    gateway:
      discovery:
        locator:
          lowerCaseServiceId: true
          enabled: true
      routes:
        # 认证中心
        - id: kylms-auth
          uri: lb://kylms-auth
          predicates:
            - Path=/auth/**
          filters:
            # 验证码处理
            - CacheRequestFilter
            - ValidateCodeFilter
            - StripPrefix=1
        # 代码生成
        - id: kylms-gen
          uri: lb://kylms-gen
          predicates:
            - Path=/code/**
          filters:
            - StripPrefix=1
        # 定时任务
        - id: kylms-job
          uri: lb://kylms-job
          predicates:
            - Path=/schedule/**
          filters:
            - StripPrefix=1
        # 系统模块
        - id: kylms-system
          uri: lb://kylms-system
          predicates:
            - Path=/system/**
          filters:
            - StripPrefix=1
        # 文件服务
        - id: kylms-file
          uri: lb://kylms-file
          predicates:
            - Path=/file/**
          filters:
            - StripPrefix=1
# 不校验白名单
ignore:
  whites:
    - /auth/logout
    - /auth/login
    - /*/v2/api-docs
    - /csrf', '64a267d72967c4f4e6f6eacb7e55eaf2', '2021-02-22 02:51:44', '2021-02-22 02:51:44', null, '172.17.0.1', 'U', '');
INSERT INTO `nacos-config`.his_config_info (id, nid, data_id, group_id, app_name, content, md5, gmt_create, gmt_modified, src_user, src_ip, op_type, tenant_id) VALUES (1, 15, 'application-dev.yml', 'DEFAULT_GROUP', '', 'spring:
  main:
    allow-bean-definition-overriding: true
  autoconfigure:
    exclude: com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure

#请求处理的超时时间
ribbon:
  ReadTimeout: 10000
  ConnectTimeout: 10000

# feign 配置
feign:
  sentinel:
    enabled: true
  okhttp:
    enabled: true
  httpclient:
    enabled: false
  client:
    config:
      default:
        connectTimeout: 10000
        readTimeout: 10000
  compression:
    request:
      enabled: true
    response:
      enabled: true

# 暴露监控端点
management:
  endpoints:
    web:
      exposure:
        include: ''*''', '4bf70b7725e0da6e79ff21312ad847c6', '2021-02-22 04:35:27', '2021-02-22 04:35:28', null, '172.17.0.1', 'U', '');
INSERT INTO `nacos-config`.his_config_info (id, nid, data_id, group_id, app_name, content, md5, gmt_create, gmt_modified, src_user, src_ip, op_type, tenant_id) VALUES (1, 16, 'application-dev.yml', 'DEFAULT_GROUP', '', 'spring:
  main:
    allow-bean-definition-overriding: true
  autoconfigure:
    exclude: com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure

#请求处理的超时时间
ribbon:
  ReadTimeout: 10000
  ConnectTimeout: 10000

# feign 配置
feign:
  sentinel:
    enabled: true
  okhttp:
    enabled: true
  httpclient:
    enabled: false
  client:
    config:
      default:
        connectTimeout: 10000
        readTimeout: 10000
  compression:
    request:
      enabled: true
    response:
      enabled: true

# 暴露监控端点
management:
  endpoints:
    web:
      exposure:
        include: ''*''
# mybatis配置
mybatis-plus:
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
    map-underscore-to-camel-case: true  # 开启驼峰命名法
  global-config:
    db-config:
    logic-delete-value: 1 # 逻辑已删除值
    logic-not-delete-value: 0 # 逻辑未删除值
  type-aliases-package: com.kaiyu56.**.domain', 'c18d548898277153793118120329af6f', '2021-02-22 04:38:32', '2021-02-22 04:38:33', null, '172.17.0.1', 'U', '');