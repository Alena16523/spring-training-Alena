package com.cydeo.service;

import com.cydeo.model.Comment;
import com.cydeo.proxy.CommentNotificationProxy;
import com.cydeo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CommentService {

    private final CommentRepository commentRepository; //need to bring this class so can call method
    private final CommentNotificationProxy emailCommentNotificationProxy;

    public CommentService(CommentRepository commentRepository, @Qualifier("EMAIL") CommentNotificationProxy emailCommentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.emailCommentNotificationProxy = emailCommentNotificationProxy;
    } //with constructor injection is done automatically

    public void publishComment(Comment comment){
        //save in the database
        commentRepository.storeComment(comment);
        //send email
        emailCommentNotificationProxy.sendComment(comment);
    }



}
