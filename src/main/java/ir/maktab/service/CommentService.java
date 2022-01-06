package ir.maktab.service;

import ir.maktab.dao.CommentDao;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentService {
    private CommentDao commentDao;
}
