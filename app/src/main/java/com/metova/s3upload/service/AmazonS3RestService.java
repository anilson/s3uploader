package com.metova.s3upload.service;

import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.mime.TypedFile;
import retrofit.mime.TypedString;

public interface AmazonS3RestService {

    @Multipart
    @POST("/")
    public Object uploadToS3(@Part("key") TypedString key, @Part("AWSAccessKeyId") TypedString awsAccessKeyId, @Part("policy") TypedString policy, @Part("signature") TypedString signature, @Part("file") TypedFile file);
}
