package com._520it;

import com._520it.controller.ChatRoomServerEndpoint;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;


/**
 * 激活WebSocket：@EnableWebSocket
 */

@SpringBootApplication()
@MapperScan("com._520it.mapper")
@EnableWebSocket
public class HistoryplatformUserserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(HistoryplatformUserserverApplication.class, args);
	}
	/**
	 * 注册 ServerEndpointExporter Bean对象（因为Springboot没有自动注册，所以得手动注册）
	 */
	@Bean
	public ServerEndpointExporter serverEndpointExporter(){
		return new ServerEndpointExporter();
	}

	/**
	 * 注册 端点对象
	 */
	@Bean
	public ChatRoomServerEndpoint chatRoomServerEndpoint(){
		return new ChatRoomServerEndpoint();
	}

}
