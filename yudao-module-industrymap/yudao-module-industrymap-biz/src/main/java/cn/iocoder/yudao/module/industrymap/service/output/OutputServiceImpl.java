package cn.iocoder.yudao.module.industrymap.service.output;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.iocoder.yudao.framework.common.exception.ServiceException;
import cn.iocoder.yudao.framework.common.util.validation.ValidationUtils;
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
import javax.validation.ConstraintViolationException;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.industrymap.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;

/**
 * 产量分布 Service 实现类
 *
 * @author yudao
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

    @Override
    @Transactional(rollbackFor = Exception.class) // 添加事务，异常则回滚所有导入
    public ExcelImportRespVO importExcelList(List<OutputImportExcelVO> importDOs, boolean isUpdateSupport) {
        // 1.1 参数校验
        if (CollUtil.isEmpty(importDOs)) {
            throw exception(EXCEL_IMPORT_LIST_IS_EMPTY);
        }

        // 2. 遍历，逐个创建 or 更新
        ExcelImportRespVO respVO = ExcelImportRespVO.builder().createLines(new ArrayList<>())
                .updateLines(new ArrayList<>()).failures(new LinkedHashMap<>()).build();
        for (int i = 0; i < importDOs.size(); i++) {
            OutputImportExcelVO importDO = importDOs.get(i);
            String lineDesc=(i+2)+"";
            // 2.1.1 校验字段是否符合要求
            try {
                ValidationUtils.validate(BeanUtils.toBean(importDO, OutputSaveReqVO.class));
            } catch (ConstraintViolationException ex){
                respVO.getFailures().put(lineDesc, ex.getMessage());
                continue;
            }
            outputMapper.insert(BeanUtils.toBean(importDO, OutputDO.class));
            respVO.getCreateLines().add(lineDesc);
        }
        return respVO;
    }

}