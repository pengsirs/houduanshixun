package com.qf.pojo;


import lombok.Data;

@Data

public class SmbmsRole {
    private Integer id;
    private String roleCode;
    private String roleName;
    private Integer createdBy;
    private Data creationDate;
    private Integer modifyBy;
    private Data modifydate;


    public SmbmsRole() {
    }

    public SmbmsRole(Integer id, String roleCode, String roleName, Integer createdBy, Data creationDate, Integer modifyBy, Data modifydate) {
        this.id = id;
        this.roleCode = roleCode;
        this.roleName = roleName;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.modifyBy = modifyBy;
        this.modifydate = modifydate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Data getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Data creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(Integer modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Data getModifydate() {
        return modifydate;
    }

    public void setModifydate(Data modifydate) {
        this.modifydate = modifydate;
    }
}
