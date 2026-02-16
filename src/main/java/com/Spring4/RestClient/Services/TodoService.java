package com.Spring4.RestClient.Services;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;

import com.Spring4.RestClient.DTO.Todo;

 @HttpExchange("/todos")
public interface TodoService{
	
	 @GetExchange
	    List<Todo> findAll();

	    @GetExchange("/{id}")
	    Todo findById(@PathVariable Integer id);

	    @PostExchange
	    Todo create(@RequestBody Todo todo);

	    @PutExchange("/{id}")
	    Todo update(@PathVariable Integer id, @RequestBody Todo todo);

	    @DeleteExchange("/{id}")
	    void delete(@PathVariable Integer id);
}
