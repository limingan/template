package com.city.management.collection.mapper.base;

import com.city.management.collection.model.base.DocumentInfo;
import com.city.management.collection.model.base.DocumentInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DocumentInfoMapper {
    long countByExample(DocumentInfoExample example);

    int deleteByExample(DocumentInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DocumentInfo record);

    int insertSelective(DocumentInfo record);

    List<DocumentInfo> selectByExample(DocumentInfoExample example);

    DocumentInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DocumentInfo record, @Param("example") DocumentInfoExample example);

    int updateByExample(@Param("record") DocumentInfo record, @Param("example") DocumentInfoExample example);

    int updateByPrimaryKeySelective(DocumentInfo record);

    int updateByPrimaryKey(DocumentInfo record);
}