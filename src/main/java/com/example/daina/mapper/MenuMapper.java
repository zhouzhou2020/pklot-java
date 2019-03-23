package com.example.daina.mapper;

import com.example.daina.entity.Menu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Daina
 * @description:
 * @date: Created in 14:08 2019/3/14
 */
@Repository
public interface MenuMapper {
    List<Menu> getMenuParentBySiteId(@Param("siteId") String siteId);
    List<Menu> getMenuByParentId(String parentId);
}