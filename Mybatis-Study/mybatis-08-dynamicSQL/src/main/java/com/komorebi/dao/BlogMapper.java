package com.komorebi.dao;

import com.komorebi.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    // 插入数据
    int addBlog(Blog blog);

    // 查询博客 if
    List<Blog> queryBlogIF(Map map);

    // 查询博客 choose
    List<Blog> queryBlogChoose(Map map);

    // 更新博客 update
    int updateBlog(Map map);

    // 查询指定ID记录列表的博客
    List<Blog> queryBlogForEach(Map map);
}
