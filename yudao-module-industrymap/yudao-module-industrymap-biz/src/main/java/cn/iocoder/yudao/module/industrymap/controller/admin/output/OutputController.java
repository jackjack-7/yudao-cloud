package cn.iocoder.yudao.module.industrymap.controller.admin.output;

import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

import java.util.*;
import java.io.IOException;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.*;

import cn.iocoder.yudao.module.industrymap.controller.admin.output.vo.*;
import cn.iocoder.yudao.module.industrymap.dal.dataobject.output.OutputDO;
import cn.iocoder.yudao.module.industrymap.service.output.OutputService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Tag(name = "管理后台 - 产量分布")
@RestController
@RequestMapping("/industrymap/output")
@Validated
public class OutputController {

    @Resource
    private OutputService outputService;

    @PostMapping("/create")
    @Operation(summary = "创建产量分布")
    @PreAuthorize("@ss.hasPermission('industrymap:output:create')")
    public CommonResult<Long> createOutput(@Valid @RequestBody OutputSaveReqVO createReqVO) {
        return success(outputService.createOutput(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新产量分布")
    @PreAuthorize("@ss.hasPermission('industrymap:output:update')")
    public CommonResult<Boolean> updateOutput(@Valid @RequestBody OutputSaveReqVO updateReqVO) {
        outputService.updateOutput(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除产量分布")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('industrymap:output:delete')")
    public CommonResult<Boolean> deleteOutput(@RequestParam("id") Long id) {
        outputService.deleteOutput(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得产量分布")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('industrymap:output:query')")
    public CommonResult<OutputRespVO> getOutput(@RequestParam("id") Long id) {
        OutputDO output = outputService.getOutput(id);
        return success(BeanUtils.toBean(output, OutputRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得产量分布分页")
    @PreAuthorize("@ss.hasPermission('industrymap:output:query')")
    public CommonResult<PageResult<OutputRespVO>> getOutputPage(@Valid OutputPageReqVO pageReqVO) {
        PageResult<OutputDO> pageResult = outputService.getOutputPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, OutputRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出产量分布 Excel")
    @PreAuthorize("@ss.hasPermission('industrymap:output:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportOutputExcel(@Valid OutputPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<OutputDO> list = outputService.getOutputPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "产量分布.xls", "数据", OutputRespVO.class,
                        BeanUtils.toBean(list, OutputRespVO.class));
    }

}