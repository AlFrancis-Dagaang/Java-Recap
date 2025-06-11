package com.ExceptionLambdaStreams;

public class Roles {
    private String role;
    private ActionsPolicy action;

    public Roles(String role, ActionsPolicy action) {
        this.role = role;
        this.action = action;

    }

    public Roles() {}

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public ActionsPolicy getAction() {
        return action;
    }

    public void setAction(ActionsPolicy action) {
        this.action = action;
    }

}
 class ActionsPolicy {
    boolean read;
    boolean write;
    boolean delete;

    public ActionsPolicy(boolean read, boolean write, boolean delete) {
        this.read = read;
        this.write = write;
        this.delete = delete;
    }
}
