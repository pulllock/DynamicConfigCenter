use dcc;
INSERT INTO dcc_env(id, created_time, modified_time, version, name, `desc`) VALUES (1, now(), now(), 1, 'dev', '开发环境');
INSERT INTO dcc_env(id, created_time, modified_time, version, name, `desc`) VALUES (2, now(), now(), 1, 'test', '测试环境');
INSERT INTO dcc_group(id, created_time, modified_time, version, name, `desc`) VALUES (1, now(), now(), 1, 'TestProject', '测试用项目');
INSERT INTO dcc_config(id, created_time, modified_time, version, `key`, type, `desc`, group_id) VALUES (1, now(), now(), 1, 'user.prefix', 1, '用户前缀', 1);
INSERT INTO dcc_config_inst(id, created_time, modified_time, version, config_id, env_id, value) VALUES (1, now(), now(), 1, 1, 1, 'OuterUserDev_');
INSERT INTO dcc_config_inst(id, created_time, modified_time, version, config_id, env_id, value) VALUES (2, now(), now(), 1, 1, 2, 'OuterUserTest_');
