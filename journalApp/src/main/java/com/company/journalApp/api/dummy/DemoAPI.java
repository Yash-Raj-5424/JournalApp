package com.company.journalApp.api.dummy;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DemoAPI {

    private XYZ xyz;

    public class XYZ{

        private int money;
        @JsonProperty("account_name")   // converts snake case variable names to camelCase
        private List<String> accountName;
    }
}
