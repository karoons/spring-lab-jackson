package com.ananda.labjackson.service;


import org.springframework.stereotype.Service;

@Service("employeeService")
public class EmployeeService implements MemberService {
    @Override
    public String getProfile(String instanceId) throws Exception {
//        String results = "";
//        if (null != instanceId && "" != instanceId){
//            switch (instanceId){
//                case "1":  results = "karoon";
//                break;
//                default:results = "other";
//                break;
//            }
//        }
//        return results;
        return null;
    }
}
