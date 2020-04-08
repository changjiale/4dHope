package leer.hope4d.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import leer.hope4d.entity.SysArticle;

import java.util.List;

/**
 * @author leer
 * @date 2018/10/16
 */
public interface ArticleMapper extends BaseMapper<SysArticle> {

    List<String> findArchivesDates();

    List<SysArticle> findArchivesByDate(String date);
}
