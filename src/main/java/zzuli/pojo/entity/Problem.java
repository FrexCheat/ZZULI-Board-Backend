package zzuli.pojo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * ClassName: Problem
 * Package: zzuli.pojo.entity
 * Description:
 *
 * @author fuchen
 * @version 1.0
 * @createTime 2024/11/10
 */
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Problem implements Serializable {
    private String id;
    private String name;
    private String score;
}