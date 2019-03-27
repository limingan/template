package com.city.management.collection.model.base;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AgentLinkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AgentLinkExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTenantCodeIsNull() {
            addCriterion("TENANT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andTenantCodeIsNotNull() {
            addCriterion("TENANT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andTenantCodeEqualTo(String value) {
            addCriterion("TENANT_CODE =", value, "tenantCode");
            return (Criteria) this;
        }

        public Criteria andTenantCodeNotEqualTo(String value) {
            addCriterion("TENANT_CODE <>", value, "tenantCode");
            return (Criteria) this;
        }

        public Criteria andTenantCodeGreaterThan(String value) {
            addCriterion("TENANT_CODE >", value, "tenantCode");
            return (Criteria) this;
        }

        public Criteria andTenantCodeGreaterThanOrEqualTo(String value) {
            addCriterion("TENANT_CODE >=", value, "tenantCode");
            return (Criteria) this;
        }

        public Criteria andTenantCodeLessThan(String value) {
            addCriterion("TENANT_CODE <", value, "tenantCode");
            return (Criteria) this;
        }

        public Criteria andTenantCodeLessThanOrEqualTo(String value) {
            addCriterion("TENANT_CODE <=", value, "tenantCode");
            return (Criteria) this;
        }

        public Criteria andTenantCodeLike(String value) {
            addCriterion("TENANT_CODE like", value, "tenantCode");
            return (Criteria) this;
        }

        public Criteria andTenantCodeNotLike(String value) {
            addCriterion("TENANT_CODE not like", value, "tenantCode");
            return (Criteria) this;
        }

        public Criteria andTenantCodeIn(List<String> values) {
            addCriterion("TENANT_CODE in", values, "tenantCode");
            return (Criteria) this;
        }

        public Criteria andTenantCodeNotIn(List<String> values) {
            addCriterion("TENANT_CODE not in", values, "tenantCode");
            return (Criteria) this;
        }

        public Criteria andTenantCodeBetween(String value1, String value2) {
            addCriterion("TENANT_CODE between", value1, value2, "tenantCode");
            return (Criteria) this;
        }

        public Criteria andTenantCodeNotBetween(String value1, String value2) {
            addCriterion("TENANT_CODE not between", value1, value2, "tenantCode");
            return (Criteria) this;
        }

        public Criteria andLinkNameIsNull() {
            addCriterion("LINK_NAME is null");
            return (Criteria) this;
        }

        public Criteria andLinkNameIsNotNull() {
            addCriterion("LINK_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andLinkNameEqualTo(String value) {
            addCriterion("LINK_NAME =", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameNotEqualTo(String value) {
            addCriterion("LINK_NAME <>", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameGreaterThan(String value) {
            addCriterion("LINK_NAME >", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameGreaterThanOrEqualTo(String value) {
            addCriterion("LINK_NAME >=", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameLessThan(String value) {
            addCriterion("LINK_NAME <", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameLessThanOrEqualTo(String value) {
            addCriterion("LINK_NAME <=", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameLike(String value) {
            addCriterion("LINK_NAME like", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameNotLike(String value) {
            addCriterion("LINK_NAME not like", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameIn(List<String> values) {
            addCriterion("LINK_NAME in", values, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameNotIn(List<String> values) {
            addCriterion("LINK_NAME not in", values, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameBetween(String value1, String value2) {
            addCriterion("LINK_NAME between", value1, value2, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameNotBetween(String value1, String value2) {
            addCriterion("LINK_NAME not between", value1, value2, "linkName");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andLinkFlagIsNull() {
            addCriterion("LINK_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andLinkFlagIsNotNull() {
            addCriterion("LINK_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andLinkFlagEqualTo(String value) {
            addCriterion("LINK_FLAG =", value, "linkFlag");
            return (Criteria) this;
        }

        public Criteria andLinkFlagNotEqualTo(String value) {
            addCriterion("LINK_FLAG <>", value, "linkFlag");
            return (Criteria) this;
        }

        public Criteria andLinkFlagGreaterThan(String value) {
            addCriterion("LINK_FLAG >", value, "linkFlag");
            return (Criteria) this;
        }

        public Criteria andLinkFlagGreaterThanOrEqualTo(String value) {
            addCriterion("LINK_FLAG >=", value, "linkFlag");
            return (Criteria) this;
        }

        public Criteria andLinkFlagLessThan(String value) {
            addCriterion("LINK_FLAG <", value, "linkFlag");
            return (Criteria) this;
        }

        public Criteria andLinkFlagLessThanOrEqualTo(String value) {
            addCriterion("LINK_FLAG <=", value, "linkFlag");
            return (Criteria) this;
        }

        public Criteria andLinkFlagLike(String value) {
            addCriterion("LINK_FLAG like", value, "linkFlag");
            return (Criteria) this;
        }

        public Criteria andLinkFlagNotLike(String value) {
            addCriterion("LINK_FLAG not like", value, "linkFlag");
            return (Criteria) this;
        }

        public Criteria andLinkFlagIn(List<String> values) {
            addCriterion("LINK_FLAG in", values, "linkFlag");
            return (Criteria) this;
        }

        public Criteria andLinkFlagNotIn(List<String> values) {
            addCriterion("LINK_FLAG not in", values, "linkFlag");
            return (Criteria) this;
        }

        public Criteria andLinkFlagBetween(String value1, String value2) {
            addCriterion("LINK_FLAG between", value1, value2, "linkFlag");
            return (Criteria) this;
        }

        public Criteria andLinkFlagNotBetween(String value1, String value2) {
            addCriterion("LINK_FLAG not between", value1, value2, "linkFlag");
            return (Criteria) this;
        }

        public Criteria andShowTypeIsNull() {
            addCriterion("SHOW_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andShowTypeIsNotNull() {
            addCriterion("SHOW_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andShowTypeEqualTo(String value) {
            addCriterion("SHOW_TYPE =", value, "showType");
            return (Criteria) this;
        }

        public Criteria andShowTypeNotEqualTo(String value) {
            addCriterion("SHOW_TYPE <>", value, "showType");
            return (Criteria) this;
        }

        public Criteria andShowTypeGreaterThan(String value) {
            addCriterion("SHOW_TYPE >", value, "showType");
            return (Criteria) this;
        }

        public Criteria andShowTypeGreaterThanOrEqualTo(String value) {
            addCriterion("SHOW_TYPE >=", value, "showType");
            return (Criteria) this;
        }

        public Criteria andShowTypeLessThan(String value) {
            addCriterion("SHOW_TYPE <", value, "showType");
            return (Criteria) this;
        }

        public Criteria andShowTypeLessThanOrEqualTo(String value) {
            addCriterion("SHOW_TYPE <=", value, "showType");
            return (Criteria) this;
        }

        public Criteria andShowTypeLike(String value) {
            addCriterion("SHOW_TYPE like", value, "showType");
            return (Criteria) this;
        }

        public Criteria andShowTypeNotLike(String value) {
            addCriterion("SHOW_TYPE not like", value, "showType");
            return (Criteria) this;
        }

        public Criteria andShowTypeIn(List<String> values) {
            addCriterion("SHOW_TYPE in", values, "showType");
            return (Criteria) this;
        }

        public Criteria andShowTypeNotIn(List<String> values) {
            addCriterion("SHOW_TYPE not in", values, "showType");
            return (Criteria) this;
        }

        public Criteria andShowTypeBetween(String value1, String value2) {
            addCriterion("SHOW_TYPE between", value1, value2, "showType");
            return (Criteria) this;
        }

        public Criteria andShowTypeNotBetween(String value1, String value2) {
            addCriterion("SHOW_TYPE not between", value1, value2, "showType");
            return (Criteria) this;
        }

        public Criteria andLinkUrlIsNull() {
            addCriterion("LINK_URL is null");
            return (Criteria) this;
        }

        public Criteria andLinkUrlIsNotNull() {
            addCriterion("LINK_URL is not null");
            return (Criteria) this;
        }

        public Criteria andLinkUrlEqualTo(String value) {
            addCriterion("LINK_URL =", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlNotEqualTo(String value) {
            addCriterion("LINK_URL <>", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlGreaterThan(String value) {
            addCriterion("LINK_URL >", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlGreaterThanOrEqualTo(String value) {
            addCriterion("LINK_URL >=", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlLessThan(String value) {
            addCriterion("LINK_URL <", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlLessThanOrEqualTo(String value) {
            addCriterion("LINK_URL <=", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlLike(String value) {
            addCriterion("LINK_URL like", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlNotLike(String value) {
            addCriterion("LINK_URL not like", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlIn(List<String> values) {
            addCriterion("LINK_URL in", values, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlNotIn(List<String> values) {
            addCriterion("LINK_URL not in", values, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlBetween(String value1, String value2) {
            addCriterion("LINK_URL between", value1, value2, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlNotBetween(String value1, String value2) {
            addCriterion("LINK_URL not between", value1, value2, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andUsedOfIsNull() {
            addCriterion("USED_OF is null");
            return (Criteria) this;
        }

        public Criteria andUsedOfIsNotNull() {
            addCriterion("USED_OF is not null");
            return (Criteria) this;
        }

        public Criteria andUsedOfEqualTo(String value) {
            addCriterion("USED_OF =", value, "usedOf");
            return (Criteria) this;
        }

        public Criteria andUsedOfNotEqualTo(String value) {
            addCriterion("USED_OF <>", value, "usedOf");
            return (Criteria) this;
        }

        public Criteria andUsedOfGreaterThan(String value) {
            addCriterion("USED_OF >", value, "usedOf");
            return (Criteria) this;
        }

        public Criteria andUsedOfGreaterThanOrEqualTo(String value) {
            addCriterion("USED_OF >=", value, "usedOf");
            return (Criteria) this;
        }

        public Criteria andUsedOfLessThan(String value) {
            addCriterion("USED_OF <", value, "usedOf");
            return (Criteria) this;
        }

        public Criteria andUsedOfLessThanOrEqualTo(String value) {
            addCriterion("USED_OF <=", value, "usedOf");
            return (Criteria) this;
        }

        public Criteria andUsedOfLike(String value) {
            addCriterion("USED_OF like", value, "usedOf");
            return (Criteria) this;
        }

        public Criteria andUsedOfNotLike(String value) {
            addCriterion("USED_OF not like", value, "usedOf");
            return (Criteria) this;
        }

        public Criteria andUsedOfIn(List<String> values) {
            addCriterion("USED_OF in", values, "usedOf");
            return (Criteria) this;
        }

        public Criteria andUsedOfNotIn(List<String> values) {
            addCriterion("USED_OF not in", values, "usedOf");
            return (Criteria) this;
        }

        public Criteria andUsedOfBetween(String value1, String value2) {
            addCriterion("USED_OF between", value1, value2, "usedOf");
            return (Criteria) this;
        }

        public Criteria andUsedOfNotBetween(String value1, String value2) {
            addCriterion("USED_OF not between", value1, value2, "usedOf");
            return (Criteria) this;
        }

        public Criteria andLinkPicUrlIsNull() {
            addCriterion("LINK_PIC_URL is null");
            return (Criteria) this;
        }

        public Criteria andLinkPicUrlIsNotNull() {
            addCriterion("LINK_PIC_URL is not null");
            return (Criteria) this;
        }

        public Criteria andLinkPicUrlEqualTo(String value) {
            addCriterion("LINK_PIC_URL =", value, "linkPicUrl");
            return (Criteria) this;
        }

        public Criteria andLinkPicUrlNotEqualTo(String value) {
            addCriterion("LINK_PIC_URL <>", value, "linkPicUrl");
            return (Criteria) this;
        }

        public Criteria andLinkPicUrlGreaterThan(String value) {
            addCriterion("LINK_PIC_URL >", value, "linkPicUrl");
            return (Criteria) this;
        }

        public Criteria andLinkPicUrlGreaterThanOrEqualTo(String value) {
            addCriterion("LINK_PIC_URL >=", value, "linkPicUrl");
            return (Criteria) this;
        }

        public Criteria andLinkPicUrlLessThan(String value) {
            addCriterion("LINK_PIC_URL <", value, "linkPicUrl");
            return (Criteria) this;
        }

        public Criteria andLinkPicUrlLessThanOrEqualTo(String value) {
            addCriterion("LINK_PIC_URL <=", value, "linkPicUrl");
            return (Criteria) this;
        }

        public Criteria andLinkPicUrlLike(String value) {
            addCriterion("LINK_PIC_URL like", value, "linkPicUrl");
            return (Criteria) this;
        }

        public Criteria andLinkPicUrlNotLike(String value) {
            addCriterion("LINK_PIC_URL not like", value, "linkPicUrl");
            return (Criteria) this;
        }

        public Criteria andLinkPicUrlIn(List<String> values) {
            addCriterion("LINK_PIC_URL in", values, "linkPicUrl");
            return (Criteria) this;
        }

        public Criteria andLinkPicUrlNotIn(List<String> values) {
            addCriterion("LINK_PIC_URL not in", values, "linkPicUrl");
            return (Criteria) this;
        }

        public Criteria andLinkPicUrlBetween(String value1, String value2) {
            addCriterion("LINK_PIC_URL between", value1, value2, "linkPicUrl");
            return (Criteria) this;
        }

        public Criteria andLinkPicUrlNotBetween(String value1, String value2) {
            addCriterion("LINK_PIC_URL not between", value1, value2, "linkPicUrl");
            return (Criteria) this;
        }

        public Criteria andWorknoIsNull() {
            addCriterion("WORKNO is null");
            return (Criteria) this;
        }

        public Criteria andWorknoIsNotNull() {
            addCriterion("WORKNO is not null");
            return (Criteria) this;
        }

        public Criteria andWorknoEqualTo(String value) {
            addCriterion("WORKNO =", value, "workno");
            return (Criteria) this;
        }

        public Criteria andWorknoNotEqualTo(String value) {
            addCriterion("WORKNO <>", value, "workno");
            return (Criteria) this;
        }

        public Criteria andWorknoGreaterThan(String value) {
            addCriterion("WORKNO >", value, "workno");
            return (Criteria) this;
        }

        public Criteria andWorknoGreaterThanOrEqualTo(String value) {
            addCriterion("WORKNO >=", value, "workno");
            return (Criteria) this;
        }

        public Criteria andWorknoLessThan(String value) {
            addCriterion("WORKNO <", value, "workno");
            return (Criteria) this;
        }

        public Criteria andWorknoLessThanOrEqualTo(String value) {
            addCriterion("WORKNO <=", value, "workno");
            return (Criteria) this;
        }

        public Criteria andWorknoLike(String value) {
            addCriterion("WORKNO like", value, "workno");
            return (Criteria) this;
        }

        public Criteria andWorknoNotLike(String value) {
            addCriterion("WORKNO not like", value, "workno");
            return (Criteria) this;
        }

        public Criteria andWorknoIn(List<String> values) {
            addCriterion("WORKNO in", values, "workno");
            return (Criteria) this;
        }

        public Criteria andWorknoNotIn(List<String> values) {
            addCriterion("WORKNO not in", values, "workno");
            return (Criteria) this;
        }

        public Criteria andWorknoBetween(String value1, String value2) {
            addCriterion("WORKNO between", value1, value2, "workno");
            return (Criteria) this;
        }

        public Criteria andWorknoNotBetween(String value1, String value2) {
            addCriterion("WORKNO not between", value1, value2, "workno");
            return (Criteria) this;
        }

        public Criteria andParamsIsNull() {
            addCriterion("PARAMS is null");
            return (Criteria) this;
        }

        public Criteria andParamsIsNotNull() {
            addCriterion("PARAMS is not null");
            return (Criteria) this;
        }

        public Criteria andParamsEqualTo(String value) {
            addCriterion("PARAMS =", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsNotEqualTo(String value) {
            addCriterion("PARAMS <>", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsGreaterThan(String value) {
            addCriterion("PARAMS >", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsGreaterThanOrEqualTo(String value) {
            addCriterion("PARAMS >=", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsLessThan(String value) {
            addCriterion("PARAMS <", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsLessThanOrEqualTo(String value) {
            addCriterion("PARAMS <=", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsLike(String value) {
            addCriterion("PARAMS like", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsNotLike(String value) {
            addCriterion("PARAMS not like", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsIn(List<String> values) {
            addCriterion("PARAMS in", values, "params");
            return (Criteria) this;
        }

        public Criteria andParamsNotIn(List<String> values) {
            addCriterion("PARAMS not in", values, "params");
            return (Criteria) this;
        }

        public Criteria andParamsBetween(String value1, String value2) {
            addCriterion("PARAMS between", value1, value2, "params");
            return (Criteria) this;
        }

        public Criteria andParamsNotBetween(String value1, String value2) {
            addCriterion("PARAMS not between", value1, value2, "params");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("SORT is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("SORT is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Long value) {
            addCriterion("SORT =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Long value) {
            addCriterion("SORT <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Long value) {
            addCriterion("SORT >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Long value) {
            addCriterion("SORT >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Long value) {
            addCriterion("SORT <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Long value) {
            addCriterion("SORT <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Long> values) {
            addCriterion("SORT in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Long> values) {
            addCriterion("SORT not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Long value1, Long value2) {
            addCriterion("SORT between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Long value1, Long value2) {
            addCriterion("SORT not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("IS_DELETE is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("IS_DELETE is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Byte value) {
            addCriterion("IS_DELETE =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Byte value) {
            addCriterion("IS_DELETE <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Byte value) {
            addCriterion("IS_DELETE >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Byte value) {
            addCriterion("IS_DELETE >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Byte value) {
            addCriterion("IS_DELETE <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Byte value) {
            addCriterion("IS_DELETE <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Byte> values) {
            addCriterion("IS_DELETE in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Byte> values) {
            addCriterion("IS_DELETE not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Byte value1, Byte value2) {
            addCriterion("IS_DELETE between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Byte value1, Byte value2) {
            addCriterion("IS_DELETE not between", value1, value2, "isDelete");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}