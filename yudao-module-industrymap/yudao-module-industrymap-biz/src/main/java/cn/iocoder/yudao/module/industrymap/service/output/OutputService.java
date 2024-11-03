package cn.iocoder.yudao.module.industrymap.service.output;

import cn.iocoder.yudao.module.industrymap.controller.admin.output.vo.*;
import cn.iocoder.yudao.module.industrymap.dal.dataobject.output.OutputDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

import javax.validation.Valid;

/**
 * 产量分布 Service 接口
 *
 * @author liang
 */
public interface OutputService {

    /**
     * 创建产量分布
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createOutput(@Valid OutputSaveReqVO createReqVO);

    /**
     * 更新产量分布
     *
     * @param updateReqVO 更新信息
     */
    void updateOutput(@Valid OutputSaveReqVO updateReqVO);

    /**
     * 删除产量分布
     *
     * @param id 编号
     */
    void deleteOutput(Long id);

    /**
     * 获得产量分布
     *
     * @param id 编号
     * @return 产量分布
     */
    OutputDO getOutput(Long id);

    /**
     * 获得产量分布分页
     *
     * @param pageReqVO 分页查询
     * @return 产量分布分页
     */
    PageResult<OutputDO> getOutputPage(OutputPageReqVO pageReqVO);

}