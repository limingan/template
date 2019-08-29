package com.city.management.collection.controller;


import com.city.management.collection.model.base.AgentLink;
import com.city.management.collection.model.query.AgentLinkQuery;
import com.city.management.collection.model.query.PageQuery;
import com.city.management.collection.service.AgentLinkService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AgentLinkController {

    @Autowired
    AgentLinkService agentLinkService;

    @ApiOperation(value="获取链接列表", notes="分页查询链接列表")
    @ApiResponses({@ApiResponse(code = 200, message = "请求成功", response = AgentLink.class)})
    @RequestMapping(value = "/agentlink/list.do", method = RequestMethod.GET)
    public List<AgentLink> list(PageQuery query) {
        List<AgentLink> permissionList = agentLinkService.pageQuery(query);
        return permissionList;
    }
}
