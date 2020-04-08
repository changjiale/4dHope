package leer.hope4d.controller;

import leer.hope4d.common.annotation.Log;
import leer.hope4d.common.controller.BaseController;
import leer.hope4d.common.exception.GlobalException;
import leer.hope4d.common.utils.QueryPage;
import leer.hope4d.common.utils.R;
import leer.hope4d.entity.SysLink;
import leer.hope4d.service.LinkService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author leer
 * @date 2018/10/18
 */
@RestController
@RequestMapping("/api/link")
@Api(value = "LinkController", tags = {"友链管理接口"})
public class LinkController extends BaseController {

    @Autowired
    private LinkService linkService;

    @GetMapping("/findAll")
    public R findAll() {
        return new R<>(linkService.list(new QueryWrapper<>()));
    }

    @PostMapping("/list")
    public R list(@RequestBody SysLink link, QueryPage queryPage) {
        return new R<>(super.getData(linkService.list(link, queryPage)));
    }

    @GetMapping("/{id}")
    public R findById(@PathVariable Long id) {
        return new R<>(linkService.getById(id));
    }

    @PostMapping
    @Log("新增友链")
    public R save(@RequestBody SysLink link) {
        try {
            linkService.add(link);
            return new R();
        } catch (Exception e) {
            throw new GlobalException(e.getMessage());
        }
    }

    @PutMapping
    @Log("更新友链")
    public R update(@RequestBody SysLink link) {
        try {
            linkService.update(link);
            return new R();
        } catch (Exception e) {
            e.printStackTrace();
            throw new GlobalException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @Log("删除友链")
    public R delete(@PathVariable Long id) {
        try {
            linkService.delete(id);
            return new R();
        } catch (Exception e) {
            throw new GlobalException(e.getMessage());
        }
    }
}
