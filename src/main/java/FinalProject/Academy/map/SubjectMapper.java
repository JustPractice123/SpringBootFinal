package FinalProject.Academy.map;

import FinalProject.Academy.Model.Subject;
import FinalProject.Academy.dto.SubjectDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubjectMapper {
    SubjectDTO toDto(Subject subject);
    Subject toEntity(SubjectDTO subjectDTO);
    List<SubjectDTO> toDtoList(List<Subject> subjects);
    List<Subject> toEntityList(List<SubjectDTO> subjectDTOS);
}
