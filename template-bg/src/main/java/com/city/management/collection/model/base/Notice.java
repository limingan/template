package com.city.management.collection.model.base;

import java.io.Serializable;
import java.util.Date;

public class Notice implements Serializable {
    private Integer id;

    private String tenantId;

    private String title;

    private Date sendTime;

    private String filePath;

    private Date beginTime;

    private String isSend;

    private String status;

    private Date endTime;

    private String sender;

    private String createSender;

    private String acceptType;

    private String acceptUsers;

    private String acceptNames;

    private String channelType;

    private String senderName;

    private String istop;

    private String noticetype;

    private String isurgency;

    private byte[] content;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public String getIsSend() {
        return isSend;
    }

    public void setIsSend(String isSend) {
        this.isSend = isSend == null ? null : isSend.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender == null ? null : sender.trim();
    }

    public String getCreateSender() {
        return createSender;
    }

    public void setCreateSender(String createSender) {
        this.createSender = createSender == null ? null : createSender.trim();
    }

    public String getAcceptType() {
        return acceptType;
    }

    public void setAcceptType(String acceptType) {
        this.acceptType = acceptType == null ? null : acceptType.trim();
    }

    public String getAcceptUsers() {
        return acceptUsers;
    }

    public void setAcceptUsers(String acceptUsers) {
        this.acceptUsers = acceptUsers == null ? null : acceptUsers.trim();
    }

    public String getAcceptNames() {
        return acceptNames;
    }

    public void setAcceptNames(String acceptNames) {
        this.acceptNames = acceptNames == null ? null : acceptNames.trim();
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType == null ? null : channelType.trim();
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName == null ? null : senderName.trim();
    }

    public String getIstop() {
        return istop;
    }

    public void setIstop(String istop) {
        this.istop = istop == null ? null : istop.trim();
    }

    public String getNoticetype() {
        return noticetype;
    }

    public void setNoticetype(String noticetype) {
        this.noticetype = noticetype == null ? null : noticetype.trim();
    }

    public String getIsurgency() {
        return isurgency;
    }

    public void setIsurgency(String isurgency) {
        this.isurgency = isurgency == null ? null : isurgency.trim();
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tenantId=").append(tenantId);
        sb.append(", title=").append(title);
        sb.append(", sendTime=").append(sendTime);
        sb.append(", filePath=").append(filePath);
        sb.append(", beginTime=").append(beginTime);
        sb.append(", isSend=").append(isSend);
        sb.append(", status=").append(status);
        sb.append(", endTime=").append(endTime);
        sb.append(", sender=").append(sender);
        sb.append(", createSender=").append(createSender);
        sb.append(", acceptType=").append(acceptType);
        sb.append(", acceptUsers=").append(acceptUsers);
        sb.append(", acceptNames=").append(acceptNames);
        sb.append(", channelType=").append(channelType);
        sb.append(", senderName=").append(senderName);
        sb.append(", istop=").append(istop);
        sb.append(", noticetype=").append(noticetype);
        sb.append(", isurgency=").append(isurgency);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}