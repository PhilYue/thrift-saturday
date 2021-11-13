package com.phil;


import com.phil.api.SaturdayService;
import com.phil.service.SaturdayServiceImpl;
import org.apache.thrift.TProcessor;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * <p> saturday server </p>
 * <p>
 * Description: server
 *
 * @author Phil Yue
 * @version V1.0.0
 * @date 2021/11/13 10:57 下午
 */
public class SatServer {

    public static void main(String[] args) throws TTransportException {

        final int port = 5127;

        // 1. init Transport by socket
        TServerSocket serverSocket = new TServerSocket(5127);

        // 2. init Provider Service
        TProcessor saturdayServiceProcessor = new SaturdayService.Processor<>(new SaturdayServiceImpl());

        // 3. init Server
        TThreadPoolServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverSocket).processor(saturdayServiceProcessor));

        Banner.print(port);

        // 4. start Server
        server.serve();


    }
}
