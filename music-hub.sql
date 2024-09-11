USE db0;
DROP TABLE IF EXISTS `user`;
CREATE TABLE user (
    `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '用户id',
    `name` varchar(128) NOT NULL COMMENT '用户名',
    `create_time` datetime NOT NULL COMMENT '创建时间',
    `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

DROP TABLE IF EXISTS `song`;
CREATE TABLE song (
    `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '歌曲id',
    `user_id` bigint unsigned NOT NULL COMMENT '创作者id',
    `song_name` varchar(128) NOT NULL COMMENT '歌名',
    `cover` varchar(512) NOT NULL DEFAULT '' COMMENT '歌曲封面',
    `duration` varchar(32) NOT NULL COMMENT '歌曲时长',
    `download_link` varchar(512) NOT NULL COMMENT '歌曲下载链接',
    `create_time` datetime NOT NULL COMMENT '创建时间',
    `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

DROP TABLE IF EXISTS `playlist`;
CREATE TABLE playlist (
    `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '歌单id',
    `name` varchar(128) NOT NULL COMMENT '歌单名称',
    `song_id_list` JSON NOT NULL COMMENT '歌曲id列表',
    `create_time` datetime NOT NULL COMMENT '创建时间',
    `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE idx (
      `a` bigint,
      `b` bigint,
      `c` bigint,
      `d` tinyint,
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
