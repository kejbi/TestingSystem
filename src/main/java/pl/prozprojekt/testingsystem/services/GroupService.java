package pl.prozprojekt.testingsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.prozprojekt.testingsystem.entities.Group;
import pl.prozprojekt.testingsystem.repositories.GroupRepo;


import java.util.List;
import java.util.Optional;
@Service
public class GroupService {
    private GroupRepo groupRepo;

    @Autowired
    public GroupService(GroupRepo groupRepo) {
        this.groupRepo = groupRepo;
    }

    public Optional<Group> getGroupById(Long id){ return groupRepo.findById(id); }

    public List<Group> getAllGroups(){
        return groupRepo.findAll();
    }

    public void addGroup(Group group){
        groupRepo.save(group);
    }

    public void deleteGroupById(Long id){
        groupRepo.deleteById(id);
    }
}
