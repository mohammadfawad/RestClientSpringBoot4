package com.Spring4.RestClient.Services;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.Spring4.RestClient.DTO.Todo;

@Service
public class TransactionalTodoService {
	
	private final RestClient restClient;
	
	public TransactionalTodoService(RestClient.Builder builder) {
		this.restClient = builder.baseUrl("https://jsonplaceholder.typicode.com").build();
	}
	
	 public List<Todo> findAll() {
	        return this.restClient.get()
	                .uri("/todos")
	                .retrieve()
	                .body(new ParameterizedTypeReference<>() {});
	    }

	    public Todo findById(Integer id) {
	        return this.restClient.get()
	                .uri("/todos/{id}", id)
	                .retrieve()
	                .body(Todo.class);
	    }

	    public Todo create(Todo todo) {
	        return this.restClient.post()
	                .uri("/todos")
	                .body(todo)
	                .retrieve()
	                .body(Todo.class);
	    }

	    public Todo update(Integer id, Todo todo) {
	        return this.restClient.put()
	                .uri("/todos/{id}", id)
	                .body(todo)
	                .retrieve()
	                .body(Todo.class);
	    }

	    public void delete(Integer id) {
	    	this.restClient.delete()
	                .uri("/todos/{id}", id)
	                .retrieve()
	                .toBodilessEntity();
	    }

}
