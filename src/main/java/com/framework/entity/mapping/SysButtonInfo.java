package com.framework.entity.mapping;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "sys_button_info")
public class SysButtonInfo implements Serializable {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 按钮名称
     */
    @Column(name = "btn_name")
    private String btnName;

    /**
     * 按钮标识(英文名称)
     */
    @Column(name = "btn_identify")
    private String btnIdentify;

    /**
     * 按钮图标
     */
    @Column(name = "btn_icon")
    private String btnIcon;

    /**
     * 是否有效：0-无效；1-有效
     */
    @Column(name = "btn_state")
    private Integer btnState;

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
     * 获取按钮名称
     *
     * @return btn_name - 按钮名称
     */
    public String getBtnName() {
        return btnName;
    }

    /**
     * 设置按钮名称
     *
     * @param btnName 按钮名称
     */
    public void setBtnName(String btnName) {
        this.btnName = btnName;
    }

    /**
     * 获取按钮标识(英文名称)
     *
     * @return btn_identify - 按钮标识(英文名称)
     */
    public String getBtnIdentify() {
        return btnIdentify;
    }

    /**
     * 设置按钮标识(英文名称)
     *
     * @param btnIdentify 按钮标识(英文名称)
     */
    public void setBtnIdentify(String btnIdentify) {
        this.btnIdentify = btnIdentify;
    }

    /**
     * 获取按钮图标
     *
     * @return btn_icon - 按钮图标
     */
    public String getBtnIcon() {
        return btnIcon;
    }

    /**
     * 设置按钮图标
     *
     * @param btnIcon 按钮图标
     */
    public void setBtnIcon(String btnIcon) {
        this.btnIcon = btnIcon;
    }

    /**
     * 获取是否有效：0-无效；1-有效
     *
     * @return btn_state - 是否有效：0-无效；1-有效
     */
    public Integer getBtnState() {
        return btnState;
    }

    /**
     * 设置是否有效：0-无效；1-有效
     *
     * @param btnState 是否有效：0-无效；1-有效
     */
    public void setBtnState(Integer btnState) {
        this.btnState = btnState;
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