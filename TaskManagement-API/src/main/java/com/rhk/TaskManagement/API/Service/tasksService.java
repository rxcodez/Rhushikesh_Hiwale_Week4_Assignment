package com.rhk.TaskManagement.API.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rhk.TaskManagement.API.Entity.Tasks;
import com.rhk.TaskManagement.API.Repository.tasksRepository;

@Service
public class tasksService { 
	@Autowired
	tasksRepository tasksRepository;
	
	public String saveTask(Tasks tasks) {
		String msg = tasksRepository.saveTask(tasks);
		if (msg==null) {
			System.out.println("Failed to save the task");
		}
		return msg;
	}
	
	public String updateTask(Tasks tasks, long id) {
		String msg = tasksRepository.updateTask(tasks, id);
		if (msg==null) {
			System.out.println("Failed to update the task");
		}
		return msg;
	}

	public String deleteTask(long id) {
		String msg = tasksRepository.deleteTask(id);
		if (msg==null) {
			System.out.println("Failed to delete the task");
		}
		return msg;
	}
	
	public Tasks fetchTaskById(long id) {
		Tasks tsk = tasksRepository.fetchTaskById(id);
		if (tsk==null) {
			System.out.println("Failed to fetch the task");
		}
		return tsk;
	}
	
	public List<Tasks> fetchAllTasks(){
		List<Tasks> list = tasksRepository.fetchAllTasks();
		if (list==null) {
			System.out.println("Failed to fetch the task");
		}
		return list;
	}
}
