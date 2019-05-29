package pl.prozprojekt.testingsystem.mappers;

import org.springframework.stereotype.Component;
import pl.prozprojekt.testingsystem.entities.StudentGroup;
import pl.prozprojekt.testingsystem.views.GroupView;

@Component
public class GroupMapper implements Mapper<StudentGroup, GroupView> {
    @Override
    public GroupView convertToView(StudentGroup studentGroup) {
        GroupView groupView = new GroupView();

        groupView.setId(studentGroup.getId());
        groupView.setName(studentGroup.getName());

        return groupView;
    }

    @Override
    public StudentGroup convertToEntity(GroupView groupView) {
        return null;
    }
}
