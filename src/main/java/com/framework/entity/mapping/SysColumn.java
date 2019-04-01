package com.framework.entity.mapping;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_column")
public class SysColumn implements Serializable {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 栏目名称
     */
    @Column(name = "column_name")
    private String columnName;

    /**
     * 栏目编号(英文或英文+数字)
     */
    @Column(name = "column_code")
    private String columnCode;

    /**
     * 栏目排序序号
     */
    @Column(name = "column_sort")
    private Integer columnSort;

    /**
     * 栏目图标
     */
    @Column(name = "column_icon")
    private String columnIcon;

    /**
     * 状态：0-无效；1-有效
     */
    @Column(name = "column_state")
    private Integer columnState;

    /**
     * 父级栏目id
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 链接地址
     */
    @Column(name = "link_url")
    private String linkUrl;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 备注
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
     * 获取栏目名称
     *
     * @return column_name - 栏目名称
     */
    public String getColumnName() {
        return columnName;
    }

    /**
     * 设置栏目名称
     *
     * @param columnName 栏目名称
     */
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    /**
     * 获取栏目编号(英文或英文+数字)
     *
     * @return column_code - 栏目编号(英文或英文+数字)
     */
    public String getColumnCode() {
        return columnCode;
    }

    /**
     * 设置栏目编号(英文或英文+数字)
     *
     * @param columnCode 栏目编号(英文或英文+数字)
     */
    public void setColumnCode(String columnCode) {
        this.columnCode = columnCode;
    }

    /**
     * 获取栏目排序序号
     *
     * @return column_sort - 栏目排序序号
     */
    public Integer getColumnSort() {
        return columnSort;
    }

    /**
     * 设置栏目排序序号
     *
     * @param columnSort 栏目排序序号
     */
    public void setColumnSort(Integer columnSort) {
        this.columnSort = columnSort;
    }

    /**
     * 获取栏目图标
     *
     * @return column_icon - 栏目图标
     */
    public String getColumnIcon() {
        return columnIcon;
    }

    /**
     * 设置栏目图标
     *
     * @param columnIcon 栏目图标
     */
    public void setColumnIcon(String columnIcon) {
        this.columnIcon = columnIcon;
    }

    /**
     * 获取状态：0-无效；1-有效
     *
     * @return column_state - 状态：0-无效；1-有效
     */
    public Integer getColumnState() {
        return columnState;
    }

    /**
     * 设置状态：0-无效；1-有效
     *
     * @param columnState 状态：0-无效；1-有效
     */
    public void setColumnState(Integer columnState) {
        this.columnState = columnState;
    }

    /**
     * 获取父级栏目id
     *
     * @return parent_id - 父级栏目id
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置父级栏目id
     *
     * @param parentId 父级栏目id
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取链接地址
     *
     * @return link_url - 链接地址
     */
    public String getLinkUrl() {
        return linkUrl;
    }

    /**
     * 设置链接地址
     *
     * @param linkUrl 链接地址
     */
    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}