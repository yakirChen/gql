create SCHEMA if not EXISTS `gql` default character set utf8mb4 COLLATE utf8mb4_bin;

use `gql`;

create TABLE if not EXISTS `book` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `name` VARCHAR(128) default NULL COMMENT "Name",
    `date` datetime default NULL COMMENT "Create Date",
    `author_id` BIGINT(20) default NULL COMMENT "Author ID",
    PRIMARY KEY (`id`)
);

create TABLE if not EXISTS `author` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `name` VARCHAR(128) default NULL COMMENT "Name",
    `date` datetime default NULL COMMENT "Create Date",
    PRIMARY KEY (`id`)
);