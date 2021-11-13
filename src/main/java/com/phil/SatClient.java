package com.phil;


import com.phil.api.SaturdayService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * <p> saturday client </p>
 * <p>
 * Description: client
 *
 * @author Phil Yue
 * @version V1.0.0
 * @date 2021/11/13 10:57 下午
 */
public class SatClient {

    public static void main(String[] args) throws TException {

        // 1. init Transport socket
        TTransport transport = new TSocket("127.0.0.1", 5127);
        transport.open(); // !!! must~

        // 2. init Protocol
        TProtocol protocol = new TBinaryProtocol(transport);

        Banner.print();

        // 3. init Consumer Reference stub, and call server service
        SaturdayService.Client client = new SaturdayService.Client(protocol);

        System.out.println("call SaturdayService func add ...");
        int add = client.add(989960, 87);
        System.out.println("call SaturdayService func add : "+add);

        System.out.println("call SaturdayService func hello ...");
        String hello = client.hello("Phil");
        System.out.println("call SaturdayService func hello : "+ hello);

        System.out.println("call SaturdayService func vacuo ...");
        String vacuo = client.vacuo();
        System.out.println("call SaturdayService func vacuo : "+ vacuo);
    }
}
