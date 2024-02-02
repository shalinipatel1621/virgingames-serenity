package com.virgingames.crudtest;


import com.virgingames.testbase.TestBase;
import com.virgingames.userinfo.UserSteps;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.annotations.Title;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.hasItem;

@RunWith(SerenityRunner.class)

public class BingoCRUDTest extends TestBase {

    static ValidatableResponse response;
    @Steps
    UserSteps steps;

    @Title("create user successfully")
    @Test
    public void iSendAGETRequestToUserEndpoint() {
        response = steps.getAllUsersOfBingo();
        response.log().all();
    }

    @Title("Verify if the user was created successfully")
    @Test
    public void iVerifyTheResponseCodeIs() {
        response.statusCode(200);
    }


    @Title("verify currency is GBP")
    @Test
    public void iSendDifferentQueryParameters() {
        response = steps.getUsersWithQueryParams().log().all().statusCode(200);
        response.body("data.pots.currency", hasItem("GBP"));
    }


}