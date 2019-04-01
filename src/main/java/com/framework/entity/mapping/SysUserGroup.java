package com.framework.entity.mapping;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_user_group")
public class SysUserGroup implements Serializable {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 分组编码
     */
    @Column(name = "group_code")
    private String groupCode;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "group_type")
    private Integer groupType;

    @Column(name = "group_desc")
    private String groupDesc;

    @Column(name = "group_state")
    private Integer groupState;

    private Long pid;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 备注信息
     */
    private String remark;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键id
     *
     * @return id - 主键id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取分组编码
     *
     * @return group_code - 分组编码
     */
    public String getGroupCode() {
        return groupCode;
    }

    /**
     * 设置分组编码
     *
     * @param groupCode 分组编码
     */
    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    /**
     * @return group_name
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * @param groupName
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * @return group_type
     */
    public Integer getGroupType() {
        return groupType;
    }

    /**
     * @param groupType
     */
    public void setGroupType(Integer groupType) {
        this.groupType = groupType;
    }

    /**
     * @return group_desc
     */
    public String getGroupDesc() {
        return groupDesc;
    }

    /**
     * @param groupDesc
     */
    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    /**
     * @return group_state
     */
    public Integer getGroupState() {
        return groupState;
    }

    /**
     * @param groupState
     */
    public void setGroupState(Integer groupState) {
        this.groupState = groupState;
    }

    /**
     * @return pid
     */
    public Long getPid() {
        return pid;
    }

    /**
     * @param pid
     */
    public void setPid(Long pid) {
        this.pid = pid;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取备注信息
     *
     * @return remark - 备注信息
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注信息
     *
     * @param remark 备注信息
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}