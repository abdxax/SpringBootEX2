package com.example.springex2.controller;

import com.example.springex2.API.ApiRespon;
import com.example.springex2.Pogo.Search;
import com.example.springex2.Pogo.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/task")
public class TaskController {
    ArrayList<Task> tasks;
    public TaskController(){
        tasks=new ArrayList<>();

    }
    @PostMapping("/addTask")
    public ApiRespon addTask(@RequestBody Task task){
        tasks.add(task);
        return new ApiRespon("Add Task done");
    }
    @GetMapping("/getAll")
    public ArrayList<Task> getAll(){
        return tasks;
    }
    @PutMapping("/updateTask/{id}")
    public ApiRespon updateTask(@PathVariable int id,@RequestBody Task task){
        tasks.set(id,task);
        return new ApiRespon("Update Done");
    }
    @DeleteMapping("/DeleteTask/{id}")
    public ApiRespon deleteTask(@PathVariable int id){
        tasks.remove(id);
        return new ApiRespon("Delete is done");
    }
@GetMapping("changeStatus/{id}")
    public ApiRespon changeStatus(@PathVariable int id){
        Task t=tasks.get(id);
        if(t.isStatus()){
            t.setStatus(false);
            tasks.set(id,t);
        }
        else{
            t.setStatus(true);
            tasks.set(id,t);
        }
        return  new ApiRespon("Change status is done");
    }
@PostMapping("/search")
   public Task Search(@RequestBody Search search){
        for (Task t :tasks){
            if(t.getTitle().equalsIgnoreCase(search.getText())){
                return t;
            }
        }
        return null;
}
}
