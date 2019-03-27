package com.city.management.collection.mapper.base;

import com.city.management.collection.model.base.AgentLink;
import com.city.management.collection.model.base.AgentLinkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AgentLinkMapper {
    long countByExample(AgentLinkExample example);

    int deleteByExample(AgentLinkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AgentLink record);

    int insertSelective(AgentLink record);

    List<AgentLink> selectByExample(AgentLinkExample example);

    AgentLink selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AgentLink record, @Param("example") AgentLinkExample example);

    int updateByExample(@Param("record") AgentLink record, @Param("example") AgentLinkExample example);

    int updateByPrimaryKeySelective(AgentLink record);

    int updateByPrimaryKey(AgentLink record);
}