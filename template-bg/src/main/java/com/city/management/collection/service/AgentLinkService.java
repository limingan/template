package com.city.management.collection.service;

import com.city.management.collection.model.base.AgentLink;
import com.city.management.collection.model.query.AgentLinkQuery;

import java.util.List;

public interface AgentLinkService {

    List<AgentLink> pageQuery(AgentLinkQuery query);
}
