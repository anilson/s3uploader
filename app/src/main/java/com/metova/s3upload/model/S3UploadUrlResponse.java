package com.metova.s3upload.model;

public class S3UploadUrlResponse {

    private String url;
    private S3ResponseFields fields;
    private String id;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public S3ResponseFields getFields() {
        return fields;
    }

    public void setFields(S3ResponseFields fields) {
        this.fields = fields;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}