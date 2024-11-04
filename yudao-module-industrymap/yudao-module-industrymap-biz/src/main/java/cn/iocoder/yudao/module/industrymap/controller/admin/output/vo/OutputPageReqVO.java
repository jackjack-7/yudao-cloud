package cn.iocoder.yudao.module.industrymap.controller.admin.output.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 产量分布分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class OutputPageReqVO extends PageParam {

    @Schema(description = "矿种", example = "2")
    private String mineralType;

    @Schema(description = "年份")
    private String yearDesc;

    @Schema(description = "数据类型", example = "2")
    private Integer dataType;

    @Schema(description = "工艺环节")
    private String procedureDesc;

    @Schema(description = "国家/地区")
    private String countryState;

    @Schema(description = "重点企业")
    private String company;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}