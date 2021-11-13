package com.phil.service;


import com.phil.api.SaturdayService;
import org.apache.thrift.TException;

/**
 * <p> SaturdayService Impl </p>
 * <p>
 * Description: todo
 *
 * @author Phil Yue
 * @version V1.0.0
 * @date 2021/11/13 11:44 下午
 */
public class SaturdayServiceImpl implements SaturdayService.Iface{
    @Override
    public String vacuo() {
        System.out.println("vacuo processing ... ");
        return "Empty!!!";
    }

    @Override
    public int add(int n1, int n2) throws TException {
        return n1 + n2;
    }

    @Override
    public String hello(String para) throws TException {
        System.out.println("hello "+ para + " !");
        return "hello " + para + "!";
    }
}
