package com.rhk.TaskManagement.API.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rhk.TaskManagement.API.Entity.Tasks;
import com.rhk.TaskManagement.API.Service.tasksService;


@RestController
@RequestMapping("/taskApi")
public class tasksController {
	@Autowired
	tasksService tasksService;
	
	
	@PostMapping("/saveTask")
	public String saveTask(@RequestBody	 Tasks tasks){
		String msg = tasksService.saveTask(tasks);
		return msg;
	}
	
	@PutMapping("/updateTask/{id}")
	public String updateTask(@RequestBody Tasks tasks, @PathVariable long id) {
		String msg = tasksService.updateTask(tasks, id);
		return msg;
	}
	
	@DeleteMapping("/deleteTask/{id}")
	public String deleteTask(@PathVariable long id) {
		String msg = tasksService.deleteTask(id);
		return msg;
	}
	
	@GetMapping("/fetchTaskById/{id}")
	public Tasks fetchTaskById(@PathVariable long id) {
		Tasks tsk = tasksService.fetchTaskById(id);
		return tsk;
	}
	
	@GetMapping("/fetchAllTasks")
	public List<Tasks> fetchAllTasks() {
		List<Tasks> list = tasksService.fetchAllTasks();
		return list;
	}
}
