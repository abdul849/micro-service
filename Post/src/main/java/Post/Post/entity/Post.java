package Post.Post.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "posts")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Post {
    @Id  //
    private String id;
    private String content;
    private String title;
    private String description;


}