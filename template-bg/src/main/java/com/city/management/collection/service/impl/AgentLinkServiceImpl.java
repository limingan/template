package com.city.management.collection.service.impl;

import com.city.management.collection.mapper.base.AgentLinkMapper;
import com.city.management.collection.model.base.AgentLink;
import com.city.management.collection.model.base.AgentLinkExample;
import com.city.management.collection.model.query.PageQuery;
import com.city.management.collection.service.AgentLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentLinkServiceImpl implements AgentLinkService {

    @Autowired
    AgentLinkMapper agentLinkMapper;

    @Override
    public List<AgentLink> pageQuery(PageQuery query) {
        if(null == query.getPageNo()) {
            query.setPageNo(1);
        }
        if(null == query.getPageSize()) {
            query.setPageSize(10);
        }

        AgentLinkExample example = new AgentLinkExample();
        example.setLimit(query.getPageSize());
        example.setOffset(query.getOffset());
        return agentLinkMapper.selectByExample(example);
    }
}
