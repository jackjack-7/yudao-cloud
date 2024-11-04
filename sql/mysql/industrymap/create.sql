-- ----------------------------
-- Table structure for industrymap_output
-- ----------------------------
DROP TABLE IF EXISTS `industrymap_output`;
CREATE TABLE `industrymap_output`  (
     `id` bigint NOT NULL AUTO_INCREMENT COMMENT '产量分布ID',
     `mineral_type` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '矿种',
     `year_desc` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL  COMMENT '年份',
     `unit` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '单位',
     `data_type` tinyint NULL DEFAULT 0 COMMENT '数据类型',
     `procedure_desc` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '工艺环节',
     `country_state` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '国家/地区',
     `output_val` double NULL DEFAULT NULL COMMENT '产量',
     `company` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '重点企业',
     `output_val_company` double NULL DEFAULT NULL COMMENT '重点企业产量',
     `output_val_total` double NULL DEFAULT NULL COMMENT '产量总量',
     `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
     `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
     `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
     `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
     `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
     `tenant_id` bigint NOT NULL DEFAULT '0' COMMENT '租户编号',
     PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 140 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '产量分布';
