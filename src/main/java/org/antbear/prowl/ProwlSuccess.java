package org.antbear.prowl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public final class ProwlSuccess {

    @XmlAttribute(name="code")
    private int statusCode;

    @XmlAttribute(name="remaining")
    private int remainingApiCalls;

    @XmlAttribute(name="resetdate")
    private String resetDate;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getRemainingApiCalls() {
        return remainingApiCalls;
    }

    public void setRemainingApiCalls(int remainingApiCalls) {
        this.remainingApiCalls = remainingApiCalls;
    }

    public String getResetDate() {
        return resetDate;
    }

    public void setResetDate(String resetDate) {
        this.resetDate = resetDate;
    }

    @Override
    public String toString() {
        return "ProwlSuccess{" +
                "statusCode=" + statusCode +
                ", remainingApiCalls=" + remainingApiCalls +
                ", resetDate='" + resetDate + '\'' +
                '}';
    }
}