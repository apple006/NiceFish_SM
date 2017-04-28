package com.sl.nicefish.dao;

import com.sl.nicefish.pojo.Classify;

public interface ClassifyMapper {
    int deleteByPrimaryKey(String classifyid);

    int insert(Classify record);

    int insertSelective(Classify record);

    Classify selectByPrimaryKey(String classifyid);

    int updateByPrimaryKeySelective(Classify record);

    int updateByPrimaryKey(Classify record);
}