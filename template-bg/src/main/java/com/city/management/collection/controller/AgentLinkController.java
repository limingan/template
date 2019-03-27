package com.city.management.collection.controller;


import com.city.management.collection.model.base.AgentLink;
import com.city.management.collection.model.query.AgentLinkQuery;
import com.city.management.collection.service.AgentLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AgentLinkController {

    @Autowired
    AgentLinkService agentLinkService;

    @RequestMapping(value = "/agentlink/list.do", method = RequestMethod.GET)
    public List<AgentLink> list(AgentLinkQuery query) {
        List<AgentLink> permissionList = agentLinkService.pageQuery(query);
        return permissionList;
    }
}
