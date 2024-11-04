package cn.iocoder.yudao.module.industrymap.controller.admin.output.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.*;

@Schema(description = "管理后台 - 产量分布新增/修改 Request VO")
@Data
public class OutputSaveReqVO {

    @Schema(description = "产量分布ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "28786")
    private Long id;

    @Schema(description = "矿种", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotEmpty(message = "矿种不能为空")
    private String mineralType;

    @Schema(description = "年份", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "年份不能为空")
    private String yearDesc;

    @Schema(description = "单位", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "单位不能为空")
    private String unit;

    @Schema(description = "数据类型", example = "2")
    private Integer dataType;

    @Schema(description = "工艺环节")
    private String procedureDesc;

    @Schema(description = "国家/地区", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "国家/地区不能为空")
    private String countryState;

    @Schema(description = "产量")
    private Double outputVal;

    @Schema(description = "重点企业")
    private String company;

    @Schema(description = "重点企业产量")
    private Double outputValCompany;

    @Schema(description = "产量总量")
    private Double outputValTotal;

}