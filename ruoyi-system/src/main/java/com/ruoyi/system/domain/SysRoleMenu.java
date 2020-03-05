package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 角色和菜单关联 sys_role_menu
 * 
 * @author ruoyi
 */
public class SysRoleMenu
{
    /** 角色ID */
    private Long roleId;
    
    /** 菜单ID */
    private Long menuId;

    /** 菜单ID */
    private Long homeId;

    public Long getRoleId()
    {
        return roleId;
    }

    public void setRoleId(Long roleId)
    {
        this.roleId = roleId;
    }

    public Long getMenuId()
    {
        return menuId;
    }

    public void setMenuId(Long menuId)
    {
        this.menuId = menuId;
    }

    @Override
    public String toString() {
        return "SysRoleMenu{" +
                "roleId=" + roleId +
                ", menuId=" + menuId +
                ", homeId=" + homeId +
                '}';
    }

    public Long getHomeId() {
        return homeId;
    }

    public void setHomeId(Long homeId) {
        this.homeId = homeId;
    }
}
