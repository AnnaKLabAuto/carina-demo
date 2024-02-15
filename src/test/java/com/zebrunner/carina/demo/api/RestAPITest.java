package com.zebrunner.carina.demo.api;

import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

public class RestAPITest extends AbstractTest {

    @Test(description = "JIRA#DEMO-0001")
    @MethodOwner(owner = "anna")
    public void testPostMethod(){
        PostMethod postUserMethod = new PostMethod();

        postUserMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        postUserMethod.callAPI();
        postUserMethod.validateResponse();
    }

    @Test(description = "JIRA#DEMO-0002")
    @MethodOwner(owner = "anna")
    public void testGetMethod(){
        GetMethod getMethod = new GetMethod(1);

        getMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getMethod.callAPI();
        getMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getMethod.validateResponseAgainstSchema("api/users/_get/rs.schema");
    }

    @Test(description = "JIRA#DEMO-0003")
    @MethodOwner(owner = "anna")
    public void testPutMethod(){
        PutMethod putMethod = new PutMethod(25);

        putMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        putMethod.callAPI();
        putMethod.validateResponse();
    }

    @Test(description = "JIRA#DEMO-0004")
    @MethodOwner(owner = "anna")
    public void testDeleteMethod(){
        DeleteMethod deleteUserMethod = new DeleteMethod(2);

        deleteUserMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        deleteUserMethod.callAPI();
        deleteUserMethod.validateResponse();
    }

}
