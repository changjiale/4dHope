package leer.hope4d.service;


import leer.hope4d.entity.SysLoginLog;
import leer.hope4d.common.utils.QueryPage;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author leer
 * @date 2019-03-13
 */
public interface LoginLogService extends IService<SysLoginLog> {

    IPage<SysLoginLog> list(SysLoginLog log, QueryPage queryPage);

    void delete(Long id);

    void saveLog(SysLoginLog log);
}
