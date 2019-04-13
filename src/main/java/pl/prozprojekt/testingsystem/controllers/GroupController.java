package pl.prozprojekt.testingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pl.prozprojekt.testingsystem.entities.Group;
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
    public Optional<Group> getGroupById(@RequestParam Long id){
        return groupService.getGroupById(id);
    }

    @GetMapping("/all")
    public List<Group> getAllGroups(){
        return groupService.getAllGroups();
    }

    @PostMapping
    public void addGroup(@RequestBody Group group){
        groupService.addGroup(group);
    }

    @DeleteMapping
    public void deleteGroupById(@RequestParam Long id){
        groupService.deleteGroupById(id);
    }
}
