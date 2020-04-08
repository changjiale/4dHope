package leer.hope4d.service;

import leer.hope4d.entity.SysLink;
import leer.hope4d.common.utils.QueryPage;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author leer
 * @date 2018/10/19
 */
public interface LinkService extends IService<SysLink> {

    IPage<SysLink> list(SysLink link, QueryPage queryPage);

    void add(SysLink link);

    void update(SysLink link);

    void delete(Long id);
}
