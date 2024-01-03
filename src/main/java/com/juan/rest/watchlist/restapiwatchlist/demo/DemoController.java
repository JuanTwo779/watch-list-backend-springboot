package com.juan.rest.watchlist.restapiwatchlist.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    //AWS health checks
    @GetMapping(path = "/")
    public String rootUrlHealthCheck(){
        return "Success";
    }

    @GetMapping(path = "/demo")
    public String demoV1() {
        return "Hello World v1";
    }

    @GetMapping(path = "/demo-bean")
    public DemoBean demoBean() {
        return new DemoBean("Hello World v2");
    }

    @GetMapping(path = "/demo-bean/path-variable/{name}")
    public DemoBean demoBeanPathVariable(@PathVariable String name) {
        return new DemoBean(String.format("Hello World, %s", name));
    }
}
