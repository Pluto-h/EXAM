package com.nwrb.eqbe.entity;

public class account {
    private int accountId;//id
    private String accountNumber;//账号
    private String accountPassword;//密码
    private int accountPermissions;//权限

    public account(){ super(); }

    public account(int accountId,String accountNumber,String accountPassword,int accountPermissions){
        super();
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.accountPassword = accountPassword;
        this.accountPermissions = accountPermissions;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public int getAccountPermissions() {
        return accountPermissions;
    }

    public void setAccountPermissions(int accountPermissions) {
        this.accountPermissions = accountPermissions;
    }

    @Override
    public String toString() {
        return accountId+","+accountNumber+","+accountPassword+","+accountPermissions;
    }
}

