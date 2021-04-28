#Target
-[ ] 到站确认
-[ ] 定位检查
-[X] 经纬度确认
-[ ] 到货确认
-[ ] 短信通知
-[ ] 司机端简单unit-app应用
#待优化内容
-[ ] 分单配载做到分单
-[ ] 运单数据更新填充
-[ ] 所有实体类的公共字段更新

## 系统模块

~~~
${basePackage}     
├── kylms-ui              // 前端框架 [80]
├── kylms-gateway         // 网关模块 [8080]
├── kylms-auth            // 认证中心 [9200]
├── kylms-api             // 接口模块
│       └── kylms-api-system                          // 系统接口
├── kylms-common          // 通用模块
│       └── kylms-common-core                         // 核心模块
│       └── kylms-common-datascope                    // 权限范围
│       └── kylms-common-datasource                   // 多数据源
│       └── kylms-common-log                          // 日志记录
│       └── kylms-common-redis                        // 缓存服务
│       └── kylms-common-security                     // 安全模块
│       └── kylms-common-swagger                      // 系统接口
├── kylms-modules         // 业务模块
│       └── kylms-system                              // 系统模块 [9201]
│       └── kylms-gen                                 // 代码生成 [9202]
│       └── kylms-job                                 // 定时任务 [9203]
│       └── kylms-file                                // 文件服务 [9300]
├── kylms-visual          // 图形化管理模块
│       └── kylms-visual-monitor                      // 监控中心 [9100]
├──pom.xml                // 公共依赖
~~~
## 架构图

<img src="https://oscimg.oschina.net/oscnet/up-82e9722ecb846786405a904bafcf19f73f3.png"/>
