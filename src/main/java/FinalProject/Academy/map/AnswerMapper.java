package FinalProject.Academy.map;

import FinalProject.Academy.Model.AnswerForTest;
import FinalProject.Academy.dto.AnswerDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnswerMapper {
    AnswerDTO toDto(AnswerForTest answer);
    AnswerForTest toEntity(AnswerDTO answerDTO);
    List<AnswerDTO> toDtoList(List<AnswerForTest> answers);
    List<AnswerForTest> toEntityList(List<AnswerDTO> answerDTOS);
}
