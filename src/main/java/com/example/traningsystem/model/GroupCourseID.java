package com.example.traningsystem.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@AllArgsConstructor
@Data
@Embeddable
@NoArgsConstructor
public class GroupCourseID implements Serializable {
    private Long groupId;
    private Long courseId;
}
