package com.lsm.nacos.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class NacosConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    NacosProviderClient nacosProviderClient;

    @GetMapping("/hi-resttemplate")
    public String hiResttemplate(){
        return restTemplate.getForObject("http://nacos-provider/hi?name=resttemplate",String.class);
    }

    @GetMapping("/hi-feign")
    public String hiFeign(){
        return nacosProviderClient.hi("feign");
    }
}
