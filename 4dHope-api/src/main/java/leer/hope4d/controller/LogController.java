package leer.hope4d.controller;

import leer.hope4d.common.controller.BaseController;
import leer.hope4d.common.exception.GlobalException;
import leer.hope4d.common.utils.QueryPage;
import leer.hope4d.common.utils.R;
import leer.hope4d.entity.SysLog;
import leer.hope4d.service.LogService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author leer
 * @date 2019-03-13
 */
@RestController
@RequestMapping("/api/log")
@Api(value = "LogController", tags = {"日志管理接口"})
public class LogController extends BaseController {

    @Autowired
    private LogService logService;

    @PostMapping("/list")
    public R findByPage(@RequestBody SysLog log, QueryPage queryPage) {
        return new R<>(super.getData(logService.list(log, queryPage)));
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable Long id) {
        try {
            logService.delete(id);
            return new R();
        } catch (Exception e) {
            throw new GlobalException(e.getMessage());
        }
    }
}
