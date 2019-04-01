package com.framework.entity.mapping;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "sys_user_role")
public class SysUserRole implements Serializable {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 系统角色id
     */
    @Column(name = "sys_role_id")
    private Long sysRoleId;

    /**
     * 系统用户id
     */
    @Column(name = "sys_user_id")
    private Long sysUserId;

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
     * 获取系统用户id
     *
     * @return sys_user_id - 系统用户id
     */
    public Long getSysUserId() {
        return sysUserId;
    }

    /**
     * 设置系统用户id
     *
     * @param sysUserId 系统用户id
     */
    public void setSysUserId(Long sysUserId) {
        this.sysUserId = sysUserId;
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