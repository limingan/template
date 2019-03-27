package com.city.management.collection.model.base;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NoticeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public NoticeExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNull() {
            addCriterion("TENANT_ID is null");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNotNull() {
            addCriterion("TENANT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTenantIdEqualTo(String value) {
            addCriterion("TENANT_ID =", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotEqualTo(String value) {
            addCriterion("TENANT_ID <>", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThan(String value) {
            addCriterion("TENANT_ID >", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThanOrEqualTo(String value) {
            addCriterion("TENANT_ID >=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThan(String value) {
            addCriterion("TENANT_ID <", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThanOrEqualTo(String value) {
            addCriterion("TENANT_ID <=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLike(String value) {
            addCriterion("TENANT_ID like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotLike(String value) {
            addCriterion("TENANT_ID not like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdIn(List<String> values) {
            addCriterion("TENANT_ID in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotIn(List<String> values) {
            addCriterion("TENANT_ID not in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdBetween(String value1, String value2) {
            addCriterion("TENANT_ID between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotBetween(String value1, String value2) {
            addCriterion("TENANT_ID not between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("TITLE is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("TITLE =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("TITLE <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("TITLE >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("TITLE >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("TITLE <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("TITLE <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("TITLE like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("TITLE not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("TITLE in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("TITLE not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("TITLE between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("TITLE not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNull() {
            addCriterion("SEND_TIME is null");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNotNull() {
            addCriterion("SEND_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andSendTimeEqualTo(Date value) {
            addCriterion("SEND_TIME =", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotEqualTo(Date value) {
            addCriterion("SEND_TIME <>", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThan(Date value) {
            addCriterion("SEND_TIME >", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("SEND_TIME >=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThan(Date value) {
            addCriterion("SEND_TIME <", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThanOrEqualTo(Date value) {
            addCriterion("SEND_TIME <=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeIn(List<Date> values) {
            addCriterion("SEND_TIME in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotIn(List<Date> values) {
            addCriterion("SEND_TIME not in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeBetween(Date value1, Date value2) {
            addCriterion("SEND_TIME between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotBetween(Date value1, Date value2) {
            addCriterion("SEND_TIME not between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andFilePathIsNull() {
            addCriterion("FILE_PATH is null");
            return (Criteria) this;
        }

        public Criteria andFilePathIsNotNull() {
            addCriterion("FILE_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andFilePathEqualTo(String value) {
            addCriterion("FILE_PATH =", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotEqualTo(String value) {
            addCriterion("FILE_PATH <>", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathGreaterThan(String value) {
            addCriterion("FILE_PATH >", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("FILE_PATH >=", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLessThan(String value) {
            addCriterion("FILE_PATH <", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLessThanOrEqualTo(String value) {
            addCriterion("FILE_PATH <=", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLike(String value) {
            addCriterion("FILE_PATH like", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotLike(String value) {
            addCriterion("FILE_PATH not like", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathIn(List<String> values) {
            addCriterion("FILE_PATH in", values, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotIn(List<String> values) {
            addCriterion("FILE_PATH not in", values, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathBetween(String value1, String value2) {
            addCriterion("FILE_PATH between", value1, value2, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotBetween(String value1, String value2) {
            addCriterion("FILE_PATH not between", value1, value2, "filePath");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNull() {
            addCriterion("BEGIN_TIME is null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNotNull() {
            addCriterion("BEGIN_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeEqualTo(Date value) {
            addCriterion("BEGIN_TIME =", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotEqualTo(Date value) {
            addCriterion("BEGIN_TIME <>", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThan(Date value) {
            addCriterion("BEGIN_TIME >", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("BEGIN_TIME >=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThan(Date value) {
            addCriterion("BEGIN_TIME <", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThanOrEqualTo(Date value) {
            addCriterion("BEGIN_TIME <=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIn(List<Date> values) {
            addCriterion("BEGIN_TIME in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotIn(List<Date> values) {
            addCriterion("BEGIN_TIME not in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeBetween(Date value1, Date value2) {
            addCriterion("BEGIN_TIME between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotBetween(Date value1, Date value2) {
            addCriterion("BEGIN_TIME not between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andIsSendIsNull() {
            addCriterion("IS_SEND is null");
            return (Criteria) this;
        }

        public Criteria andIsSendIsNotNull() {
            addCriterion("IS_SEND is not null");
            return (Criteria) this;
        }

        public Criteria andIsSendEqualTo(String value) {
            addCriterion("IS_SEND =", value, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendNotEqualTo(String value) {
            addCriterion("IS_SEND <>", value, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendGreaterThan(String value) {
            addCriterion("IS_SEND >", value, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendGreaterThanOrEqualTo(String value) {
            addCriterion("IS_SEND >=", value, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendLessThan(String value) {
            addCriterion("IS_SEND <", value, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendLessThanOrEqualTo(String value) {
            addCriterion("IS_SEND <=", value, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendLike(String value) {
            addCriterion("IS_SEND like", value, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendNotLike(String value) {
            addCriterion("IS_SEND not like", value, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendIn(List<String> values) {
            addCriterion("IS_SEND in", values, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendNotIn(List<String> values) {
            addCriterion("IS_SEND not in", values, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendBetween(String value1, String value2) {
            addCriterion("IS_SEND between", value1, value2, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendNotBetween(String value1, String value2) {
            addCriterion("IS_SEND not between", value1, value2, "isSend");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("END_TIME =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("END_TIME <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("END_TIME >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("END_TIME >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("END_TIME <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("END_TIME <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("END_TIME in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("END_TIME not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("END_TIME between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("END_TIME not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andSenderIsNull() {
            addCriterion("SENDER is null");
            return (Criteria) this;
        }

        public Criteria andSenderIsNotNull() {
            addCriterion("SENDER is not null");
            return (Criteria) this;
        }

        public Criteria andSenderEqualTo(String value) {
            addCriterion("SENDER =", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotEqualTo(String value) {
            addCriterion("SENDER <>", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderGreaterThan(String value) {
            addCriterion("SENDER >", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderGreaterThanOrEqualTo(String value) {
            addCriterion("SENDER >=", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderLessThan(String value) {
            addCriterion("SENDER <", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderLessThanOrEqualTo(String value) {
            addCriterion("SENDER <=", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderLike(String value) {
            addCriterion("SENDER like", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotLike(String value) {
            addCriterion("SENDER not like", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderIn(List<String> values) {
            addCriterion("SENDER in", values, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotIn(List<String> values) {
            addCriterion("SENDER not in", values, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderBetween(String value1, String value2) {
            addCriterion("SENDER between", value1, value2, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotBetween(String value1, String value2) {
            addCriterion("SENDER not between", value1, value2, "sender");
            return (Criteria) this;
        }

        public Criteria andCreateSenderIsNull() {
            addCriterion("create_sender is null");
            return (Criteria) this;
        }

        public Criteria andCreateSenderIsNotNull() {
            addCriterion("create_sender is not null");
            return (Criteria) this;
        }

        public Criteria andCreateSenderEqualTo(String value) {
            addCriterion("create_sender =", value, "createSender");
            return (Criteria) this;
        }

        public Criteria andCreateSenderNotEqualTo(String value) {
            addCriterion("create_sender <>", value, "createSender");
            return (Criteria) this;
        }

        public Criteria andCreateSenderGreaterThan(String value) {
            addCriterion("create_sender >", value, "createSender");
            return (Criteria) this;
        }

        public Criteria andCreateSenderGreaterThanOrEqualTo(String value) {
            addCriterion("create_sender >=", value, "createSender");
            return (Criteria) this;
        }

        public Criteria andCreateSenderLessThan(String value) {
            addCriterion("create_sender <", value, "createSender");
            return (Criteria) this;
        }

        public Criteria andCreateSenderLessThanOrEqualTo(String value) {
            addCriterion("create_sender <=", value, "createSender");
            return (Criteria) this;
        }

        public Criteria andCreateSenderLike(String value) {
            addCriterion("create_sender like", value, "createSender");
            return (Criteria) this;
        }

        public Criteria andCreateSenderNotLike(String value) {
            addCriterion("create_sender not like", value, "createSender");
            return (Criteria) this;
        }

        public Criteria andCreateSenderIn(List<String> values) {
            addCriterion("create_sender in", values, "createSender");
            return (Criteria) this;
        }

        public Criteria andCreateSenderNotIn(List<String> values) {
            addCriterion("create_sender not in", values, "createSender");
            return (Criteria) this;
        }

        public Criteria andCreateSenderBetween(String value1, String value2) {
            addCriterion("create_sender between", value1, value2, "createSender");
            return (Criteria) this;
        }

        public Criteria andCreateSenderNotBetween(String value1, String value2) {
            addCriterion("create_sender not between", value1, value2, "createSender");
            return (Criteria) this;
        }

        public Criteria andAcceptTypeIsNull() {
            addCriterion("ACCEPT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andAcceptTypeIsNotNull() {
            addCriterion("ACCEPT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptTypeEqualTo(String value) {
            addCriterion("ACCEPT_TYPE =", value, "acceptType");
            return (Criteria) this;
        }

        public Criteria andAcceptTypeNotEqualTo(String value) {
            addCriterion("ACCEPT_TYPE <>", value, "acceptType");
            return (Criteria) this;
        }

        public Criteria andAcceptTypeGreaterThan(String value) {
            addCriterion("ACCEPT_TYPE >", value, "acceptType");
            return (Criteria) this;
        }

        public Criteria andAcceptTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ACCEPT_TYPE >=", value, "acceptType");
            return (Criteria) this;
        }

        public Criteria andAcceptTypeLessThan(String value) {
            addCriterion("ACCEPT_TYPE <", value, "acceptType");
            return (Criteria) this;
        }

        public Criteria andAcceptTypeLessThanOrEqualTo(String value) {
            addCriterion("ACCEPT_TYPE <=", value, "acceptType");
            return (Criteria) this;
        }

        public Criteria andAcceptTypeLike(String value) {
            addCriterion("ACCEPT_TYPE like", value, "acceptType");
            return (Criteria) this;
        }

        public Criteria andAcceptTypeNotLike(String value) {
            addCriterion("ACCEPT_TYPE not like", value, "acceptType");
            return (Criteria) this;
        }

        public Criteria andAcceptTypeIn(List<String> values) {
            addCriterion("ACCEPT_TYPE in", values, "acceptType");
            return (Criteria) this;
        }

        public Criteria andAcceptTypeNotIn(List<String> values) {
            addCriterion("ACCEPT_TYPE not in", values, "acceptType");
            return (Criteria) this;
        }

        public Criteria andAcceptTypeBetween(String value1, String value2) {
            addCriterion("ACCEPT_TYPE between", value1, value2, "acceptType");
            return (Criteria) this;
        }

        public Criteria andAcceptTypeNotBetween(String value1, String value2) {
            addCriterion("ACCEPT_TYPE not between", value1, value2, "acceptType");
            return (Criteria) this;
        }

        public Criteria andAcceptUsersIsNull() {
            addCriterion("ACCEPT_USERS is null");
            return (Criteria) this;
        }

        public Criteria andAcceptUsersIsNotNull() {
            addCriterion("ACCEPT_USERS is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptUsersEqualTo(String value) {
            addCriterion("ACCEPT_USERS =", value, "acceptUsers");
            return (Criteria) this;
        }

        public Criteria andAcceptUsersNotEqualTo(String value) {
            addCriterion("ACCEPT_USERS <>", value, "acceptUsers");
            return (Criteria) this;
        }

        public Criteria andAcceptUsersGreaterThan(String value) {
            addCriterion("ACCEPT_USERS >", value, "acceptUsers");
            return (Criteria) this;
        }

        public Criteria andAcceptUsersGreaterThanOrEqualTo(String value) {
            addCriterion("ACCEPT_USERS >=", value, "acceptUsers");
            return (Criteria) this;
        }

        public Criteria andAcceptUsersLessThan(String value) {
            addCriterion("ACCEPT_USERS <", value, "acceptUsers");
            return (Criteria) this;
        }

        public Criteria andAcceptUsersLessThanOrEqualTo(String value) {
            addCriterion("ACCEPT_USERS <=", value, "acceptUsers");
            return (Criteria) this;
        }

        public Criteria andAcceptUsersLike(String value) {
            addCriterion("ACCEPT_USERS like", value, "acceptUsers");
            return (Criteria) this;
        }

        public Criteria andAcceptUsersNotLike(String value) {
            addCriterion("ACCEPT_USERS not like", value, "acceptUsers");
            return (Criteria) this;
        }

        public Criteria andAcceptUsersIn(List<String> values) {
            addCriterion("ACCEPT_USERS in", values, "acceptUsers");
            return (Criteria) this;
        }

        public Criteria andAcceptUsersNotIn(List<String> values) {
            addCriterion("ACCEPT_USERS not in", values, "acceptUsers");
            return (Criteria) this;
        }

        public Criteria andAcceptUsersBetween(String value1, String value2) {
            addCriterion("ACCEPT_USERS between", value1, value2, "acceptUsers");
            return (Criteria) this;
        }

        public Criteria andAcceptUsersNotBetween(String value1, String value2) {
            addCriterion("ACCEPT_USERS not between", value1, value2, "acceptUsers");
            return (Criteria) this;
        }

        public Criteria andAcceptNamesIsNull() {
            addCriterion("accept_names is null");
            return (Criteria) this;
        }

        public Criteria andAcceptNamesIsNotNull() {
            addCriterion("accept_names is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptNamesEqualTo(String value) {
            addCriterion("accept_names =", value, "acceptNames");
            return (Criteria) this;
        }

        public Criteria andAcceptNamesNotEqualTo(String value) {
            addCriterion("accept_names <>", value, "acceptNames");
            return (Criteria) this;
        }

        public Criteria andAcceptNamesGreaterThan(String value) {
            addCriterion("accept_names >", value, "acceptNames");
            return (Criteria) this;
        }

        public Criteria andAcceptNamesGreaterThanOrEqualTo(String value) {
            addCriterion("accept_names >=", value, "acceptNames");
            return (Criteria) this;
        }

        public Criteria andAcceptNamesLessThan(String value) {
            addCriterion("accept_names <", value, "acceptNames");
            return (Criteria) this;
        }

        public Criteria andAcceptNamesLessThanOrEqualTo(String value) {
            addCriterion("accept_names <=", value, "acceptNames");
            return (Criteria) this;
        }

        public Criteria andAcceptNamesLike(String value) {
            addCriterion("accept_names like", value, "acceptNames");
            return (Criteria) this;
        }

        public Criteria andAcceptNamesNotLike(String value) {
            addCriterion("accept_names not like", value, "acceptNames");
            return (Criteria) this;
        }

        public Criteria andAcceptNamesIn(List<String> values) {
            addCriterion("accept_names in", values, "acceptNames");
            return (Criteria) this;
        }

        public Criteria andAcceptNamesNotIn(List<String> values) {
            addCriterion("accept_names not in", values, "acceptNames");
            return (Criteria) this;
        }

        public Criteria andAcceptNamesBetween(String value1, String value2) {
            addCriterion("accept_names between", value1, value2, "acceptNames");
            return (Criteria) this;
        }

        public Criteria andAcceptNamesNotBetween(String value1, String value2) {
            addCriterion("accept_names not between", value1, value2, "acceptNames");
            return (Criteria) this;
        }

        public Criteria andChannelTypeIsNull() {
            addCriterion("CHANNEL_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andChannelTypeIsNotNull() {
            addCriterion("CHANNEL_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andChannelTypeEqualTo(String value) {
            addCriterion("CHANNEL_TYPE =", value, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelTypeNotEqualTo(String value) {
            addCriterion("CHANNEL_TYPE <>", value, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelTypeGreaterThan(String value) {
            addCriterion("CHANNEL_TYPE >", value, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CHANNEL_TYPE >=", value, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelTypeLessThan(String value) {
            addCriterion("CHANNEL_TYPE <", value, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelTypeLessThanOrEqualTo(String value) {
            addCriterion("CHANNEL_TYPE <=", value, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelTypeLike(String value) {
            addCriterion("CHANNEL_TYPE like", value, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelTypeNotLike(String value) {
            addCriterion("CHANNEL_TYPE not like", value, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelTypeIn(List<String> values) {
            addCriterion("CHANNEL_TYPE in", values, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelTypeNotIn(List<String> values) {
            addCriterion("CHANNEL_TYPE not in", values, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelTypeBetween(String value1, String value2) {
            addCriterion("CHANNEL_TYPE between", value1, value2, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelTypeNotBetween(String value1, String value2) {
            addCriterion("CHANNEL_TYPE not between", value1, value2, "channelType");
            return (Criteria) this;
        }

        public Criteria andSenderNameIsNull() {
            addCriterion("SENDER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSenderNameIsNotNull() {
            addCriterion("SENDER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSenderNameEqualTo(String value) {
            addCriterion("SENDER_NAME =", value, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameNotEqualTo(String value) {
            addCriterion("SENDER_NAME <>", value, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameGreaterThan(String value) {
            addCriterion("SENDER_NAME >", value, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameGreaterThanOrEqualTo(String value) {
            addCriterion("SENDER_NAME >=", value, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameLessThan(String value) {
            addCriterion("SENDER_NAME <", value, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameLessThanOrEqualTo(String value) {
            addCriterion("SENDER_NAME <=", value, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameLike(String value) {
            addCriterion("SENDER_NAME like", value, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameNotLike(String value) {
            addCriterion("SENDER_NAME not like", value, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameIn(List<String> values) {
            addCriterion("SENDER_NAME in", values, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameNotIn(List<String> values) {
            addCriterion("SENDER_NAME not in", values, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameBetween(String value1, String value2) {
            addCriterion("SENDER_NAME between", value1, value2, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameNotBetween(String value1, String value2) {
            addCriterion("SENDER_NAME not between", value1, value2, "senderName");
            return (Criteria) this;
        }

        public Criteria andIstopIsNull() {
            addCriterion("ISTOP is null");
            return (Criteria) this;
        }

        public Criteria andIstopIsNotNull() {
            addCriterion("ISTOP is not null");
            return (Criteria) this;
        }

        public Criteria andIstopEqualTo(String value) {
            addCriterion("ISTOP =", value, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopNotEqualTo(String value) {
            addCriterion("ISTOP <>", value, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopGreaterThan(String value) {
            addCriterion("ISTOP >", value, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopGreaterThanOrEqualTo(String value) {
            addCriterion("ISTOP >=", value, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopLessThan(String value) {
            addCriterion("ISTOP <", value, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopLessThanOrEqualTo(String value) {
            addCriterion("ISTOP <=", value, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopLike(String value) {
            addCriterion("ISTOP like", value, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopNotLike(String value) {
            addCriterion("ISTOP not like", value, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopIn(List<String> values) {
            addCriterion("ISTOP in", values, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopNotIn(List<String> values) {
            addCriterion("ISTOP not in", values, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopBetween(String value1, String value2) {
            addCriterion("ISTOP between", value1, value2, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopNotBetween(String value1, String value2) {
            addCriterion("ISTOP not between", value1, value2, "istop");
            return (Criteria) this;
        }

        public Criteria andNoticetypeIsNull() {
            addCriterion("NOTICETYPE is null");
            return (Criteria) this;
        }

        public Criteria andNoticetypeIsNotNull() {
            addCriterion("NOTICETYPE is not null");
            return (Criteria) this;
        }

        public Criteria andNoticetypeEqualTo(String value) {
            addCriterion("NOTICETYPE =", value, "noticetype");
            return (Criteria) this;
        }

        public Criteria andNoticetypeNotEqualTo(String value) {
            addCriterion("NOTICETYPE <>", value, "noticetype");
            return (Criteria) this;
        }

        public Criteria andNoticetypeGreaterThan(String value) {
            addCriterion("NOTICETYPE >", value, "noticetype");
            return (Criteria) this;
        }

        public Criteria andNoticetypeGreaterThanOrEqualTo(String value) {
            addCriterion("NOTICETYPE >=", value, "noticetype");
            return (Criteria) this;
        }

        public Criteria andNoticetypeLessThan(String value) {
            addCriterion("NOTICETYPE <", value, "noticetype");
            return (Criteria) this;
        }

        public Criteria andNoticetypeLessThanOrEqualTo(String value) {
            addCriterion("NOTICETYPE <=", value, "noticetype");
            return (Criteria) this;
        }

        public Criteria andNoticetypeLike(String value) {
            addCriterion("NOTICETYPE like", value, "noticetype");
            return (Criteria) this;
        }

        public Criteria andNoticetypeNotLike(String value) {
            addCriterion("NOTICETYPE not like", value, "noticetype");
            return (Criteria) this;
        }

        public Criteria andNoticetypeIn(List<String> values) {
            addCriterion("NOTICETYPE in", values, "noticetype");
            return (Criteria) this;
        }

        public Criteria andNoticetypeNotIn(List<String> values) {
            addCriterion("NOTICETYPE not in", values, "noticetype");
            return (Criteria) this;
        }

        public Criteria andNoticetypeBetween(String value1, String value2) {
            addCriterion("NOTICETYPE between", value1, value2, "noticetype");
            return (Criteria) this;
        }

        public Criteria andNoticetypeNotBetween(String value1, String value2) {
            addCriterion("NOTICETYPE not between", value1, value2, "noticetype");
            return (Criteria) this;
        }

        public Criteria andIsurgencyIsNull() {
            addCriterion("isUrgency is null");
            return (Criteria) this;
        }

        public Criteria andIsurgencyIsNotNull() {
            addCriterion("isUrgency is not null");
            return (Criteria) this;
        }

        public Criteria andIsurgencyEqualTo(String value) {
            addCriterion("isUrgency =", value, "isurgency");
            return (Criteria) this;
        }

        public Criteria andIsurgencyNotEqualTo(String value) {
            addCriterion("isUrgency <>", value, "isurgency");
            return (Criteria) this;
        }

        public Criteria andIsurgencyGreaterThan(String value) {
            addCriterion("isUrgency >", value, "isurgency");
            return (Criteria) this;
        }

        public Criteria andIsurgencyGreaterThanOrEqualTo(String value) {
            addCriterion("isUrgency >=", value, "isurgency");
            return (Criteria) this;
        }

        public Criteria andIsurgencyLessThan(String value) {
            addCriterion("isUrgency <", value, "isurgency");
            return (Criteria) this;
        }

        public Criteria andIsurgencyLessThanOrEqualTo(String value) {
            addCriterion("isUrgency <=", value, "isurgency");
            return (Criteria) this;
        }

        public Criteria andIsurgencyLike(String value) {
            addCriterion("isUrgency like", value, "isurgency");
            return (Criteria) this;
        }

        public Criteria andIsurgencyNotLike(String value) {
            addCriterion("isUrgency not like", value, "isurgency");
            return (Criteria) this;
        }

        public Criteria andIsurgencyIn(List<String> values) {
            addCriterion("isUrgency in", values, "isurgency");
            return (Criteria) this;
        }

        public Criteria andIsurgencyNotIn(List<String> values) {
            addCriterion("isUrgency not in", values, "isurgency");
            return (Criteria) this;
        }

        public Criteria andIsurgencyBetween(String value1, String value2) {
            addCriterion("isUrgency between", value1, value2, "isurgency");
            return (Criteria) this;
        }

        public Criteria andIsurgencyNotBetween(String value1, String value2) {
            addCriterion("isUrgency not between", value1, value2, "isurgency");
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