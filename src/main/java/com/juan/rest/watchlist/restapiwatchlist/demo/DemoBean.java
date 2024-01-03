package com.juan.rest.watchlist.restapiwatchlist.demo;

public class DemoBean {

    private String message;

    public DemoBean(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    @Override
    public String toString() {
        return "DemoBean [message=" + message + "]";
    }
}
