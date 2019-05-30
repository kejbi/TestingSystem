package pl.prozprojekt.testingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import pl.prozprojekt.testingsystem.entities.StudentGroup;
import pl.prozprojekt.testingsystem.mappers.GroupMapper;
import pl.prozprojekt.testingsystem.services.GroupService;
import pl.prozprojekt.testingsystem.views.GroupView;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/groups")
@Secured({"ROLE_TEACHER", "ROLE_STUDENT"})
public class GroupController {
    private GroupService groupService;

    private GroupMapper groupMapper;

    @Autowired
    public GroupController(GroupService groupService, GroupMapper groupMapper) {
        this.groupService = groupService;
        this.groupMapper = groupMapper;
    }

    @GetMapping
    public Optional<StudentGroup> getGroupById(@RequestParam Long id){
        return groupService.getGroupById(id);
    }

    @GetMapping("/all")
    public List<GroupView> getAllGroups(){
        return groupService.getAllGroups().stream().map(group -> groupMapper.convertToView(group)).collect(Collectors.toList());
    }



    @PostMapping
    public void addGroup(@RequestBody StudentGroup studentGroup){
        groupService.addGroup(studentGroup);
    }

    @DeleteMapping
    public void deleteGroupById(@RequestParam Long id){
        groupService.deleteGroupById(id);
    }
}
