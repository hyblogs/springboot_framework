package com.framework.entity.mapping;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_user")
public class SysUser implements Serializable {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 名称
     */
    @Column(name = "sys_user_name")
    private String sysUserName;

    /**
     * 昵称
     */
    @Column(name = "sys_user_nick")
    private String sysUserNick;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 性别：0-女；1-男
     */
    private Integer sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 身份证号码
     */
    @Column(name = "id_number")
    private String idNumber;

    /**
     * 审核状态：0-审核失败；1-审核成功；2-未审核
     */
    @Column(name = "audit_state")
    private Integer auditState;

    /**
     * 审核时间
     */
    @Column(name = "audit_time")
    private Date auditTime;

    /**
     * 是否登录状态：0-非登录状态;1-登录状态
     */
    @Column(name = "is_login")
    private Integer isLogin;

    /**
     * 是否启用登录状态检测：0-否；1-是
     */
    @Column(name = "is_open_login_check")
    private Integer isOpenLoginCheck;

    /**
     * 账户状态：0-无效；1-有效
     */
    private Integer state;

    /**
     * 系统用户组织机构id
     */
    @Column(name = "group_id")
    private Long groupId;

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

    @Column(name = "last_login_ip")
    private String lastLoginIp;

    @Column(name = "last_login_time")
    private Date lastLoginTime;

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
     * 获取名称
     *
     * @return sys_user_name - 名称
     */
    public String getSysUserName() {
        return sysUserName;
    }

    /**
     * 设置名称
     *
     * @param sysUserName 名称
     */
    public void setSysUserName(String sysUserName) {
        this.sysUserName = sysUserName;
    }

    /**
     * 获取昵称
     *
     * @return sys_user_nick - 昵称
     */
    public String getSysUserNick() {
        return sysUserNick;
    }

    /**
     * 设置昵称
     *
     * @param sysUserNick 昵称
     */
    public void setSysUserNick(String sysUserNick) {
        this.sysUserNick = sysUserNick;
    }

    /**
     * 获取登录密码
     *
     * @return password - 登录密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置登录密码
     *
     * @param password 登录密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取盐
     *
     * @return salt - 盐
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 设置盐
     *
     * @param salt 盐
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 获取手机号码
     *
     * @return mobile - 手机号码
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号码
     *
     * @param mobile 手机号码
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取电子邮箱
     *
     * @return email - 电子邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置电子邮箱
     *
     * @param email 电子邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取性别：0-女；1-男
     *
     * @return sex - 性别：0-女；1-男
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置性别：0-女；1-男
     *
     * @param sex 性别：0-女；1-男
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取年龄
     *
     * @return age - 年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置年龄
     *
     * @param age 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取身份证号码
     *
     * @return id_number - 身份证号码
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * 设置身份证号码
     *
     * @param idNumber 身份证号码
     */
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * 获取审核状态：0-审核失败；1-审核成功；2-未审核
     *
     * @return audit_state - 审核状态：0-审核失败；1-审核成功；2-未审核
     */
    public Integer getAuditState() {
        return auditState;
    }

    /**
     * 设置审核状态：0-审核失败；1-审核成功；2-未审核
     *
     * @param auditState 审核状态：0-审核失败；1-审核成功；2-未审核
     */
    public void setAuditState(Integer auditState) {
        this.auditState = auditState;
    }

    /**
     * 获取审核时间
     *
     * @return audit_time - 审核时间
     */
    public Date getAuditTime() {
        return auditTime;
    }

    /**
     * 设置审核时间
     *
     * @param auditTime 审核时间
     */
    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    /**
     * 获取是否登录状态：0-非登录状态;1-登录状态
     *
     * @return is_login - 是否登录状态：0-非登录状态;1-登录状态
     */
    public Integer getIsLogin() {
        return isLogin;
    }

    /**
     * 设置是否登录状态：0-非登录状态;1-登录状态
     *
     * @param isLogin 是否登录状态：0-非登录状态;1-登录状态
     */
    public void setIsLogin(Integer isLogin) {
        this.isLogin = isLogin;
    }

    /**
     * 获取是否启用登录状态检测：0-否；1-是
     *
     * @return is_open_login_check - 是否启用登录状态检测：0-否；1-是
     */
    public Integer getIsOpenLoginCheck() {
        return isOpenLoginCheck;
    }

    /**
     * 设置是否启用登录状态检测：0-否；1-是
     *
     * @param isOpenLoginCheck 是否启用登录状态检测：0-否；1-是
     */
    public void setIsOpenLoginCheck(Integer isOpenLoginCheck) {
        this.isOpenLoginCheck = isOpenLoginCheck;
    }

    /**
     * 获取账户状态：0-无效；1-有效
     *
     * @return state - 账户状态：0-无效；1-有效
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置账户状态：0-无效；1-有效
     *
     * @param state 账户状态：0-无效；1-有效
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取系统用户组织机构id
     *
     * @return group_id - 系统用户组织机构id
     */
    public Long getGroupId() {
        return groupId;
    }

    /**
     * 设置系统用户组织机构id
     *
     * @param groupId 系统用户组织机构id
     */
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
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

    /**
     * @return last_login_ip
     */
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    /**
     * @param lastLoginIp
     */
    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    /**
     * @return last_login_time
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * @param lastLoginTime
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}