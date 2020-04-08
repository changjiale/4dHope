package leer.hope4d.mapper;

import leer.hope4d.entity.ArticleTag;
import leer.hope4d.entity.SysArticle;
import leer.hope4d.entity.SysTag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author leer
 * @date 2018/10/22
 */
public interface ArticleTagMapper extends BaseMapper<ArticleTag> {

    List<SysTag> findByArticleId(long articleId);

    List<SysArticle> findByTagName(String name);
}
