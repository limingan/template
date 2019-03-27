package com.city.management.collection.model.base;

import java.io.Serializable;
import java.util.Date;

public class AgentLink implements Serializable {
    private Integer id;

    private String tenantCode;

    private String linkName;

    private Date createTime;

    private String linkFlag;

    private String showType;

    private String linkUrl;

    private String usedOf;

    private String linkPicUrl;

    private String workno;

    private String params;

    private Long sort;

    private Byte isDelete;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode == null ? null : tenantCode.trim();
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName == null ? null : linkName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLinkFlag() {
        return linkFlag;
    }

    public void setLinkFlag(String linkFlag) {
        this.linkFlag = linkFlag == null ? null : linkFlag.trim();
    }

    public String getShowType() {
        return showType;
    }

    public void setShowType(String showType) {
        this.showType = showType == null ? null : showType.trim();
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl == null ? null : linkUrl.trim();
    }

    public String getUsedOf() {
        return usedOf;
    }

    public void setUsedOf(String usedOf) {
        this.usedOf = usedOf == null ? null : usedOf.trim();
    }

    public String getLinkPicUrl() {
        return linkPicUrl;
    }

    public void setLinkPicUrl(String linkPicUrl) {
        this.linkPicUrl = linkPicUrl == null ? null : linkPicUrl.trim();
    }

    public String getWorkno() {
        return workno;
    }

    public void setWorkno(String workno) {
        this.workno = workno == null ? null : workno.trim();
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tenantCode=").append(tenantCode);
        sb.append(", linkName=").append(linkName);
        sb.append(", createTime=").append(createTime);
        sb.append(", linkFlag=").append(linkFlag);
        sb.append(", showType=").append(showType);
        sb.append(", linkUrl=").append(linkUrl);
        sb.append(", usedOf=").append(usedOf);
        sb.append(", linkPicUrl=").append(linkPicUrl);
        sb.append(", workno=").append(workno);
        sb.append(", params=").append(params);
        sb.append(", sort=").append(sort);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}