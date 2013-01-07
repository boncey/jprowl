package org.antbear.jprowl.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="prowl")
@XmlAccessorType(XmlAccessType.FIELD)
public final class ProwlResponse {

    @XmlElement(nillable=true)
    private ProwlSuccess success;

    @XmlElement(nillable=true)
    private ProwlError error;

    @XmlElement(nillable=true)
    private ProwlRetrieve retrieve;

    public ProwlSuccess getSuccess() {
        return success;
    }

    public void setSuccess(ProwlSuccess success) {
        this.success = success;
    }

    public ProwlError getError() {
        return error;
    }

    public void setError(ProwlError error) {
        this.error = error;
    }

    public ProwlRetrieve getRetrieve() {
        return retrieve;
    }

    public void setRetrieve(ProwlRetrieve retrieve) {
        this.retrieve = retrieve;
    }

    @Override
    public String toString() {
        return "ProwlResponse{" +
                "success=" + success +
                ", error=" + error +
                ", retrieve=" + retrieve +
                '}';
    }
}
