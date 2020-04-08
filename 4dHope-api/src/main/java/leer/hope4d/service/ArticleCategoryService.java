package leer.hope4d.service;

import leer.hope4d.entity.ArticleCategory;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author leer
 * @date 2018/10/22
 */
public interface ArticleCategoryService extends IService<ArticleCategory> {

    /**
     * 新增
     *
     * @param articleCategory
     */
    void add(ArticleCategory articleCategory);

    /**
     * 根据文章ID删除
     *
     * @param id
     */
    void deleteByArticleId(Long id);

    /**
     * 根据分类ID删除
     *
     * @param id
     */
    void deleteByCategoryId(Long id);
}
