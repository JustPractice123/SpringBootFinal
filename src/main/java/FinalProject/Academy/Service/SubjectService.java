package FinalProject.Academy.Service;

import FinalProject.Academy.Model.Subject;
import FinalProject.Academy.Repository.SubjectRep;
import FinalProject.Academy.dto.SubjectDTO;
import FinalProject.Academy.map.SubjectMapper;
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
    @Autowired
    SubjectMapper subjectMapper;

    public SubjectDTO getSubjectById(Long id) {
        Subject subject = subjectRep.getSubjectById(id);
        return subjectMapper.toDto(subject);
    }

    public List<SubjectDTO> getSubjects() {
        List<Subject> subjects=subjectRep.findAll();
        return subjectMapper.toDtoList(subjects);
    }
}
