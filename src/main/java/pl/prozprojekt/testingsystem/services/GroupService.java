package pl.prozprojekt.testingsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.prozprojekt.testingsystem.entities.StudentGroup;
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

    public Optional<StudentGroup> getGroupById(Long id){ return groupRepo.findById(id); }

    public List<StudentGroup> getAllGroups(){
        return groupRepo.findAll();
    }

    public void addGroup(StudentGroup studentGroup){
        groupRepo.save(studentGroup);
    }

    public void deleteGroupById(Long id){
        groupRepo.deleteById(id);
    }
}
