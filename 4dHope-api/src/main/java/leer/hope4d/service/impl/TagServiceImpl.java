package leer.hope4d.service.impl;

import leer.hope4d.entity.SysTag;
import leer.hope4d.service.TagService;
import leer.hope4d.common.utils.QueryPage;
import leer.hope4d.mapper.TagMapper;
import leer.hope4d.service.ArticleTagService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @auther leer
 * @date 2018/10/18
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, SysTag> implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private ArticleTagService articleTagService;

    @Override
    public List<SysTag> findAll() {
        return tagMapper.selectList(new QueryWrapper<>());
    }

    @Override
    public IPage<SysTag> list(SysTag tag, QueryPage queryPage) {
        IPage<SysTag> page = new Page<>(queryPage.getPage(), queryPage.getLimit());
        LambdaQueryWrapper<SysTag> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(tag.getName()), SysTag::getName, tag.getName());
        queryWrapper.orderByDesc(SysTag::getId);
        return tagMapper.selectPage(page, queryWrapper);
    }

    @Override
    @Transactional
    public void add(SysTag tag) {
        if (!exists(tag)) {
            tagMapper.insert(tag);
        }
    }

    private boolean exists(SysTag tag) {
        LambdaQueryWrapper<SysTag> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysTag::getName, tag.getName());
        return tagMapper.selectList(queryWrapper).size() > 0 ? true : false;
    }

    @Override
    @Transactional
    public void update(SysTag tag) {
        tagMapper.updateById(tag);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        tagMapper.deleteById(id);

        //删除该标签与文章有关联的关联信息
        articleTagService.deleteByTagsId(id);
    }

    @Override
    public List<SysTag> findByArticleId(Long id) {
        return tagMapper.findByArticleId(id);
    }
}
