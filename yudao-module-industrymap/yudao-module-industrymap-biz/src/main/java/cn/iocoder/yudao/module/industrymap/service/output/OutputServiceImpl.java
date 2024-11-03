package cn.iocoder.yudao.module.industrymap.service.output;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.industrymap.controller.admin.output.vo.*;
import cn.iocoder.yudao.module.industrymap.dal.dataobject.output.OutputDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.industrymap.dal.mysql.output.OutputMapper;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.industrymap.enums.ErrorCodeConstants.*;

/**
 * 产量分布 Service 实现类
 *
 * @author liang
 */
@Service
@Validated
public class OutputServiceImpl implements OutputService {

    @Resource
    private OutputMapper outputMapper;

    @Override
    public Long createOutput(OutputSaveReqVO createReqVO) {
        // 插入
        OutputDO output = BeanUtils.toBean(createReqVO, OutputDO.class);
        outputMapper.insert(output);
        // 返回
        return output.getId();
    }

    @Override
    public void updateOutput(OutputSaveReqVO updateReqVO) {
        // 校验存在
        validateOutputExists(updateReqVO.getId());
        // 更新
        OutputDO updateObj = BeanUtils.toBean(updateReqVO, OutputDO.class);
        outputMapper.updateById(updateObj);
    }

    @Override
    public void deleteOutput(Long id) {
        // 校验存在
        validateOutputExists(id);
        // 删除
        outputMapper.deleteById(id);
    }

    private void validateOutputExists(Long id) {
        if (outputMapper.selectById(id) == null) {
            throw exception(OUTPUT_NOT_EXISTS);
        }
    }

    @Override
    public OutputDO getOutput(Long id) {
        return outputMapper.selectById(id);
    }

    @Override
    public PageResult<OutputDO> getOutputPage(OutputPageReqVO pageReqVO) {
        return outputMapper.selectPage(pageReqVO);
    }

}