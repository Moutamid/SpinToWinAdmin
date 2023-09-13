package com.moutamid.spintowinadmin;

public class DataModel {
    String merchantAPI;
    Integer maxAvail, exchangeRate, withdrawLimit;
    Boolean manualVisible;

    public DataModel(String merchantAPI, Integer maxAvail, Integer exchangeRate, Integer withdrawLimit, Boolean manualVisible) {
        this.merchantAPI = merchantAPI;
        this.maxAvail = maxAvail;
        this.exchangeRate = exchangeRate;
        this.withdrawLimit = withdrawLimit;
        this.manualVisible = manualVisible;
    }

    public DataModel() {
    }

    public String getMerchantAPI() {
        return merchantAPI;
    }

    public void setMerchantAPI(String merchantAPI) {
        this.merchantAPI = merchantAPI;
    }

    public Integer getMaxAvail() {
        return maxAvail;
    }

    public void setMaxAvail(Integer maxAvail) {
        this.maxAvail = maxAvail;
    }

    public Integer getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Integer exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public Integer getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Integer withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public Boolean getManualVisible() {
        return manualVisible;
    }

    public void setManualVisible(Boolean manualVisible) {
        this.manualVisible = manualVisible;
    }
}
