package com.framework.entity.mapping;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "sys_btn_role")
public class SysBtnRole implements Serializable {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 系统按钮id
     */
    @Column(name = "sys_btn_id")
    private Long sysBtnId;

    /**
     * 系统角色id
     */
    @Column(name = "sys_role_id")
    private Long sysRoleId;

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
     * 获取系统按钮id
     *
     * @return sys_btn_id - 系统按钮id
     */
    public Long getSysBtnId() {
        return sysBtnId;
    }

    /**
     * 设置系统按钮id
     *
     * @param sysBtnId 系统按钮id
     */
    public void setSysBtnId(Long sysBtnId) {
        this.sysBtnId = sysBtnId;
    }

    /**
     * 获取系统角色id
     *
     * @return sys_role_id - 系统角色id
     */
    public Long getSysRoleId() {
        return sysRoleId;
    }

    /**
     * 设置系统角色id
     *
     * @param sysRoleId 系统角色id
     */
    public void setSysRoleId(Long sysRoleId) {
        this.sysRoleId = sysRoleId;
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