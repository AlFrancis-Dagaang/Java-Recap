package com.ExceptionLambdaStreams;

public class TxtFiles {
    String name;
    String body;

    public TxtFiles(String name, String body) {
        this.name = name;
        this.body = body;
    }

    public TxtFiles() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
