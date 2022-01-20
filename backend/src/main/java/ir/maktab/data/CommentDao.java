package ir.maktab.data;

import ir.maktab.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDao extends JpaRepository<Comment,Integer> {
    void update(Comment comment);
}
