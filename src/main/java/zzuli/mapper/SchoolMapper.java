package zzuli.mapper;

import org.apache.ibatis.annotations.Mapper;
import zzuli.pojo.dto.CreateSchoolDTO;
import zzuli.pojo.entity.School;

/**
 * ClassName: SchoolMapper
 * Package: zzuli.mapper
 * Description:
 *
 * @author fuchen
 * @version 1.0
 * @createTime 2024/11/25
 */
@Mapper
public interface SchoolMapper {
    void craeteSchool(CreateSchoolDTO dto);

    School getSchoolById(int schoolId);

    void setSchool(School school);
}
