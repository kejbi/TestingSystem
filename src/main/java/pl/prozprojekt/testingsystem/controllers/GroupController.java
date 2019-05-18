package pl.prozprojekt.testingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pl.prozprojekt.testingsystem.entities.StudentGroup;
import pl.prozprojekt.testingsystem.services.GroupService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/groups")
public class GroupController {
    private GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public Optional<StudentGroup> getGroupById(@RequestParam Long id){
        return groupService.getGroupById(id);
    }

    @GetMapping("/all")
    public List<StudentGroup> getAllGroups(){
        return groupService.getAllGroups();
    }

    @PostMapping
    public void addGroup(@RequestBody StudentGroup studentGroup){
    }

    @DeleteMapping
    public void deleteGroupById(@RequestParam Long id){
        groupService.deleteGroupById(id);
    }
}
