package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path = "/hello") //http://localhost:9090/api/get/hello
    public String getHello(){
        return "Hello get Spring";
    }

    @RequestMapping(path = "/hi", method = RequestMethod.GET) //get 메소드가 지정됨 //http://localhost:9090/api/get/hi
    public  String hi(){
        return "Hi";
    }
    ////http://localhost:9090/api/get/path-Variable/{name}
    @GetMapping("/path-Variale/{id}")  //name과
    public String pathVariable(@PathVariable(name = "id") String PathName){ //name이 같아야한다
        System.out.println("PathVariable : " + PathName);
        return PathName;
    }

    //http://localhost:9090/api/get/query-param?user=steve&email=steve@gamil.com@age=30
    @GetMapping(path = "/query_param")
    public String queryParam(@RequestParam Map<String, String> queryParam){
        StringBuilder sb = new StringBuilder();
        queryParam.entrySet().forEach( entry ->{
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey()+" = "+entry.getValue()+"\n");
        });
        return sb.toString();
    }
    @GetMapping(path = "/query_param02")
    public String queryParam02(@RequestParam String name,
                               @RequestParam String email,
                               @RequestParam int age
                               ){
            System.out.println(name);
            System.out.println(email);
            System.out.println(age);
            return name+" "+email+" "+age;

    }

    @GetMapping(path = "/query_param03")
    public String queryParam03(UserRequest userRequest){
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());
        return userRequest.toString();

    }
}
