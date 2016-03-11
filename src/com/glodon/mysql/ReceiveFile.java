package com.glodon.mysql;

import java.util.Date;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

public class ReceiveFile {
	private static final String TASK_QUEUE_NAME ="file_queue";
	
	public static void main(String[] argv) throws Exception{
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("192.168.89.169");
	    //远程连接Rabbitmq服务器要添加端口号和用户名、密码
	    factory.setPort(5672);
	    factory.setUsername("glodon");
	    factory.setPassword("yt2014");
	    Connection connection = factory.newConnection();
	    Channel channel = connection.createChannel();
	    
	    channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);//参数true对TASK_QUEUE_NAME持久化
	    File file = new File();
	    file.setFileID("000001");
	    file.setFileOfUserID("1000000");
	    file.setFileName("file_test.dwg");
	    file.setFilePath("c:/tmp");
	    file.setFileSize(1000);
	    file.setFileTime(new Date());
	    channel.basicPublish( "", TASK_QUEUE_NAME, 
                MessageProperties.PERSISTENT_TEXT_PLAIN,
                file.toString().getBytes());
	    System.out.println(" [x] Sent '" + file + "'");
	    
	    channel.close();
	    connection.close();
	}
}
