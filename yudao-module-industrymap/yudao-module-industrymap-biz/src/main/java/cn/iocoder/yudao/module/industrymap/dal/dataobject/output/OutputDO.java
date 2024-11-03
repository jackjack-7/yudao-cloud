package cn.iocoder.yudao.module.industrymap.dal.dataobject.output;

import cn.iocoder.yudao.framework.tenant.core.db.TenantBaseDO;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 产量分布 DO
 *
 * @author liang
 */
@TableName("industrymap_output")
@KeySequence("industrymap_output_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OutputDO extends TenantBaseDO {

    /**
     * 产量分布ID
     */
    @TableId
    private Long id;
    /**
     * 矿种
     */
    private String mineralType;
    /**
     * 年份
     */
    private String year;
    /**
     * 单位
     */
    private String unit;
    /**
     * 数据类型
     */
    private Integer dataType;
    /**
     * 工艺环节
     */
    private String procedure;
    /**
     * 国家/地区
     */
    private String countryState;
    /**
     * 产量
     */
    private Double outputVal;
    /**
     * 重点企业
     */
    private String company;
    /**
     * 重点企业产量
     */
    private Double outputValCompany;
    /**
     * 产量总量
     */
    private Double outputValTotal;

}