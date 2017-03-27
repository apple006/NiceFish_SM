package com.sl.nicefish.dao;

import com.sl.nicefish.pojo.Upload;

public interface UploadMapper {
    int deleteByPrimaryKey(String upId);

    int insert(Upload record);

    int insertSelective(Upload record);

    Upload selectByPrimaryKey(String upId);

    int updateByPrimaryKeySelective(Upload record);

    int updateByPrimaryKey(Upload record);
}