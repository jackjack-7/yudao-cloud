package cn.iocoder.yudao.module.industrymap.dal.mysql.output;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.industrymap.dal.dataobject.output.OutputDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.industrymap.controller.admin.output.vo.*;

/**
 * 产量分布 Mapper
 *
 * @author liang
 */
@Mapper
public interface OutputMapper extends BaseMapperX<OutputDO> {

    default PageResult<OutputDO> selectPage(OutputPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<OutputDO>()
                .eqIfPresent(OutputDO::getMineralType, reqVO.getMineralType())
                .eqIfPresent(OutputDO::getYear, reqVO.getYear())
                .eqIfPresent(OutputDO::getDataType, reqVO.getDataType())
                .eqIfPresent(OutputDO::getProcedure, reqVO.getProcedure())
                .eqIfPresent(OutputDO::getCountryState, reqVO.getCountryState())
                .eqIfPresent(OutputDO::getCompany, reqVO.getCompany())
                .betweenIfPresent(OutputDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(OutputDO::getId));
    }

}