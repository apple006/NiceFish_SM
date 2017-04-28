package com.sl.nicefish.dao;

import com.sl.nicefish.pojo.Upload;

public interface UploadMapper {
    int deleteByPrimaryKey(String upid);

    int insert(Upload record);

    int insertSelective(Upload record);

    Upload selectByPrimaryKey(String upid);

    int updateByPrimaryKeySelective(Upload record);

    int updateByPrimaryKey(Upload record);
}