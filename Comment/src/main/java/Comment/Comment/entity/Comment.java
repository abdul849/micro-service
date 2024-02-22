package Comment.Comment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Comments")
public class Comment {
    @Id
    private String commentId;
    private String name;
    private String email;
    private String body;
    private String postId;

}
