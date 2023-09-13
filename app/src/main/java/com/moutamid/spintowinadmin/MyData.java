package com.moutamid.spintowinadmin;

public class MyData {
    private String uniqueId;
    private String mobileNumber;
    private Integer amountReq;

    public MyData(String uniqueId, String mobileNumber, Integer amountReq) {
        this.uniqueId = uniqueId;
        this.mobileNumber = mobileNumber;
        this.amountReq = amountReq;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public Integer getAmountReq() {
        return amountReq;
    }
}
