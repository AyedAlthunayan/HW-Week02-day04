package com.example.hw04;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class Tasks {

    ArrayList<Pogo> arr = new ArrayList<Pogo>();
    @PostMapping ("/task")
    public Comment addTask (@RequestBody Pogo pogo){
        arr.add(pogo);
        return new Comment("Task added");
    }
    @GetMapping ("/task")
    public ArrayList<Pogo> getTasks(){
        return arr;
    }
    @PutMapping ("/task/{index}")
    public Comment putTask(@PathVariable int index,@RequestBody Pogo pogo){
        arr.set(index,pogo);
        return new Comment("Task updated");
    }
    @DeleteMapping ("/task/{index}")
    public Comment deleteTask(@PathVariable int index){
        arr.remove(index);
        return new Comment("task is deleted");
    }
    @PostMapping ("/task/status")
    public Comment changeTask(@RequestParam String title,@RequestParam String status){
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getTitle().equals(title)){
                arr.get(i).setStatus(status);
                return new Comment(arr.get(i).toString());
            }
        }
        return new Comment("Wrong Title");
    }

}
