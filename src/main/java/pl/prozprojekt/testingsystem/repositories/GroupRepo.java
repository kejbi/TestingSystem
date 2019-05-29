package pl.prozprojekt.testingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.prozprojekt.testingsystem.entities.StudentGroup;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepo extends JpaRepository<StudentGroup, Long> {

}
