package com.glodon;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

public class Send {
	
  private final static String QUEUE_NAME = "hello";

  public static void main(String[] argv) throws Exception {
      	      
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("192.168.89.169");
    //远程连接Rabbitmq服务器要添加端口号和用户名、密码
    factory.setPort(5672);
    factory.setUsername("glodon");
    factory.setPassword("yt2014");
    Connection connection = factory.newConnection();
    Channel channel = connection.createChannel();

    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
    String message = "Hello World!";
    channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
    System.out.println(" [x] Sent '" + message + "'");
    
    channel.close();
    connection.close();
  }
}