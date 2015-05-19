package com.metova.s3upload.service;

import com.google.gson.Gson;
import com.metova.s3upload.model.BuildConfig;
import com.metova.s3upload.model.Result;
import com.metova.s3upload.model.S3ResponseFields;
import com.metova.s3upload.util.GsonUtil;

import java.io.File;

import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.converter.GsonConverter;
import retrofit.mime.TypedFile;
import retrofit.mime.TypedString;

public class AmazonS3RestClient {

    private static final String MULTI_PART_STRING = "multipart/form-data";

    private AmazonS3RestService mService;

    public Result<Object> uploadToS3(File file, S3ResponseFields fields) {

        TypedFile typedFile = new TypedFile(MULTI_PART_STRING, file);
        TypedString typedKey = new TypedString(fields.getKey());
        TypedString typedAwsAccessKey = new TypedString(fields.getAwsAccessKeyId());
        TypedString typedPolicy = new TypedString(fields.getPolicy());
        TypedString typedSignature = new TypedString(fields.getSignature());

        try {
            return new Result<Object>(getService().uploadToS3(typedKey, typedAwsAccessKey, typedPolicy, typedSignature, typedFile));
        } catch (RetrofitError error) {
            return new Result<Object>(error);
        }
    }

    private AmazonS3RestService getService() {

        if (mService == null) {

            Gson gson = GsonUtil.getGson();

            //TODO put the base URL in there somehow
            RestAdapter adapter = new RestAdapter.Builder().setEndpoint("changeme").setConverter(new GsonConverter(gson)).build();

            if(BuildConfig.DEBUG) {
                adapter.setLogLevel(RestAdapter.LogLevel.BASIC); //Don't do full logging when uploading files - OOM errors happen
            }

            mService = adapter.create(AmazonS3RestService.class);
        }
        return mService;
    }
}
