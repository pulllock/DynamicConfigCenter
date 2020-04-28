CREATE DATABASE IF NOT EXISTS dcc DEFAULT CHARSET utf8mb4;

CREATE TABLE dcc_group (
    id            bigint(20) unsigned AUTO_INCREMENT NOT NULL COMMENT '主键id',
    created_time  datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    modified_time datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    version       smallint(6)                        NOT NULL DEFAULT 1 COMMENT '版本号',
    name          varchar(255)                       NOT NULL COMMENT '组名',
    `desc`        varchar(255)                       NOT NULL COMMENT '描述',
    PRIMARY KEY pk_id(id),
    INDEX idx_name(name)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT = '配置组，可以以应用作为组';

CREATE TABLE dcc_env (
    id            bigint(20) unsigned AUTO_INCREMENT NOT NULL COMMENT '主键id',
    created_time  datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    modified_time datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    version       smallint(6)                        NOT NULL DEFAULT 1 COMMENT '版本号',
    name          varchar(255)                       NOT NULL COMMENT 'env名',
    `desc`        varchar(255)                       NOT NULL COMMENT '描述',
    PRIMARY KEY pk_id(id),
    INDEX idx_name(name)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT = '环境，区分开发、测试等环境';

CREATE TABLE dcc_config (
    id            bigint(20) unsigned AUTO_INCREMENT NOT NULL COMMENT '主键id',
    created_time  datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    modified_time datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    version       smallint(6)                        NOT NULL DEFAULT 1 COMMENT '版本号',
    `key`         varchar(255)                       NOT NULL COMMENT '配置key',
    type          smallint(6)                        NOT NULL COMMENT '类型 1-String 2-Number 3-Json',
    `desc`        varchar(255)                       NOT NULL COMMENT '描述',
    group_id      bigint(20)                         NOT NULL COMMENT '所属组id',
    PRIMARY KEY pk_id(id),
    INDEX idx_key(`key`),
    INDEX idx_group_id(group_id)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT = '配置';

CREATE TABLE dcc_config_inst (
    id            bigint(20) unsigned AUTO_INCREMENT NOT NULL COMMENT '主键id',
    created_time  datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    modified_time datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    version       smallint(6)                        NOT NULL DEFAULT 1 COMMENT '版本号',
    config_id     bigint(20)                         NOT NULL COMMENT '配置id',
    env_id        bigint(20)                         NOT NULL COMMENT '环境id',
    value          varchar(255)                      NOT NULL COMMENT '配置值',
    PRIMARY KEY pk_id(id),
    INDEX idx_config_env_id(config_id, env_id)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT = '配置实例，不同环境的配置值';