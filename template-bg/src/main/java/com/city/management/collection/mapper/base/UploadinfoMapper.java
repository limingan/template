package com.city.management.collection.mapper.base;

import com.city.management.collection.model.base.Uploadinfo;
import com.city.management.collection.model.base.UploadinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UploadinfoMapper {
    long countByExample(UploadinfoExample example);

    int deleteByExample(UploadinfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Uploadinfo record);

    int insertSelective(Uploadinfo record);

    List<Uploadinfo> selectByExample(UploadinfoExample example);

    Uploadinfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Uploadinfo record, @Param("example") UploadinfoExample example);

    int updateByExample(@Param("record") Uploadinfo record, @Param("example") UploadinfoExample example);

    int updateByPrimaryKeySelective(Uploadinfo record);

    int updateByPrimaryKey(Uploadinfo record);
}