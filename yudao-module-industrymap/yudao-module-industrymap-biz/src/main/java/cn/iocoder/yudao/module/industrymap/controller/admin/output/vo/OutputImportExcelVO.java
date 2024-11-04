package cn.iocoder.yudao.module.industrymap.controller.admin.output.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;

/**
 *  Excel 导入 VO
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = false) // 设
public class OutputImportExcelVO {

    @ExcelProperty("矿种")
    private String mineralType;

    @ExcelProperty("年份")
    private String yearDesc;

    @ExcelProperty("单位")
    private String unit;

    @ExcelProperty("数据类型")
    private Integer dataType;

    @ExcelProperty("工艺环节")
    private String procedureDesc;

    @ExcelProperty("国家/地区")
    private String countryState;

    @ExcelProperty("产量")
    private Double outputVal;

    @ExcelProperty("重点企业")
    private String company;

    @ExcelProperty("重点企业产量")
    private Double outputValCompany;

    @ExcelProperty("产量总量")
    private Double outputValTotal;

}
