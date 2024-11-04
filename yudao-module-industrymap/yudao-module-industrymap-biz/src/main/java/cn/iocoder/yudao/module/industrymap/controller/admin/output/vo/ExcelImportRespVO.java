package cn.iocoder.yudao.module.industrymap.controller.admin.output.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Schema(description = "管理后台 - Excel 导入 Response VO")
@Data
@Builder
public class ExcelImportRespVO {


    @Schema(description = "创建成功的数组(第几行)", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<String> createLines;

    @Schema(description = "更新成功的数组(第几行)", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<String> updateLines;

    @Schema(description = "导入失败的集合，key 为第几行，value 为失败原因", requiredMode = Schema.RequiredMode.REQUIRED)
    private Map<String, String> failures;
}
