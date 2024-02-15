package com.zebrunner.carina.demo.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/api/v1/create", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/users/_post/rq.json")
@ResponseTemplatePath(path = "api/users/_post/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PostMethod extends AbstractApiMethodV2 {
    public PostMethod() {
        super("api/users/_post/rq.json", "api/users/_post/rs.json", "api/users/user.properties");
        replaceUrlPlaceholder("base_url", Configuration.getRequired("base"));
    }
}


