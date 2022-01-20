package ir.maktab.service;

import ir.maktab.data.CommentDao;
import ir.maktab.model.Comment;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@Service
public class CommentService {
    private CommentDao commentDao;

    public void updateComment(Comment comment) {
        commentDao.update(comment);
    }

    public void deleteComment(Comment comment) {
        commentDao.delete(comment);
    }

    public List<Comment> findAll() {
        return commentDao.findAll();
    }


    public Comment saveComment(Comment comment) {
       return commentDao.save(comment);
    }


}
