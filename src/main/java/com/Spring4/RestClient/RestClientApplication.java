package com.Spring4.RestClient;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import com.Spring4.RestClient.Services.TodoService;

@SpringBootApplication
public class RestClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestClientApplication.class, args);
	}
	
	public TodoService todoService(RestClient.Builder restClientBuilder, BeanFactoryPostProcessor forceAutoProxyCreatorToUseClassProxying) {
		RestClient restClient = restClientBuilder.baseUrl("https://jsonplaceholder.typicode.com").build();
		RestClientAdapter restClientAdapter = RestClientAdapter.create(restClient);
		HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory.builderFor(restClientAdapter).build();
		return httpServiceProxyFactory.createClient(TodoService.class);
	}

}
