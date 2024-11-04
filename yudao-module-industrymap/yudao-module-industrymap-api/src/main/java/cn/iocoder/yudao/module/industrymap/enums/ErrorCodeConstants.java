package cn.iocoder.yudao.module.industrymap.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

public interface ErrorCodeConstants {
// ========== 产量分布 2-002-000-000 ==========
    ErrorCode OUTPUT_NOT_EXISTS = new ErrorCode(2_002_000_000, "产量分布不存在");
    ErrorCode EXCEL_IMPORT_LIST_IS_EMPTY = new ErrorCode(2_002_000_001, "导入用户数据不能为空！");
}