package FinalProject.Academy.Service;

import FinalProject.Academy.Model.Subject;
import FinalProject.Academy.Repository.SubjectRep;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
public class SubjectService {
    @Autowired
    SubjectRep subjectRep;

    public Subject getSubjectById(Long id) {
        Subject subject = subjectRep.getSubjectById(id);
        return subject;
    }

    public List<Subject> getSubjects() {
        List<Subject> subjects=subjectRep.findAll();
        return subjects;
    }
}
