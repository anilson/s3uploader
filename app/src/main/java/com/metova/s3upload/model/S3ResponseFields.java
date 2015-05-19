package com.metova.s3upload.model;

import com.google.gson.annotations.SerializedName;

public class S3ResponseFields {

    @SerializedName("AWSAccessKeyId")
    private String awsAccessKeyId;
    private String key;
    private String policy;
    private String signature;

    public String getAwsAccessKeyId() {
        return awsAccessKeyId;
    }

    public void setAwsAccessKeyId(String awsAccessKeyId) {
        this.awsAccessKeyId = awsAccessKeyId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
