package cn.iocoder.yudao.module.industrymap.controller.admin.output.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 产量分布 Response VO")
@Data
@ExcelIgnoreUnannotated
public class OutputRespVO {

    @Schema(description = "产量分布ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "28786")
    @ExcelProperty("产量分布ID")
    private Long id;

    @Schema(description = "矿种", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty("矿种")
    private String mineralType;

    @Schema(description = "年份", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("年份")
    private String yearDesc;

    @Schema(description = "单位", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("单位")
    private String unit;

    @Schema(description = "数据类型", example = "2")
    @ExcelProperty("数据类型")
    private Integer dataType;

    @Schema(description = "工艺环节")
    @ExcelProperty("工艺环节")
    private String procedureDesc;

    @Schema(description = "国家/地区", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("国家/地区")
    private String countryState;

    @Schema(description = "产量")
    @ExcelProperty("产量")
    private Double outputVal;

    @Schema(description = "重点企业")
    @ExcelProperty("重点企业")
    private String company;

    @Schema(description = "重点企业产量")
    @ExcelProperty("重点企业产量")
    private Double outputValCompany;

    @Schema(description = "产量总量")
    @ExcelProperty("产量总量")
    private Double outputValTotal;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}