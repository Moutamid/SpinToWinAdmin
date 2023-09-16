package com.moutamid.spintowinadmin;

public class MyData {
    private String uniqueId;
    private String userName;
    private String mobileNumber;
    private Integer amountReq;

    public MyData(String uniqueId, String mobileNumber, Integer amountReq, String userName ) {
        this.uniqueId = uniqueId;
        this.mobileNumber = mobileNumber;
        this.amountReq = amountReq;
        this.userName = userName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public Integer getAmountReq() {
        return amountReq;
    }

    public String getUserName() {
        return userName;
    }
}
