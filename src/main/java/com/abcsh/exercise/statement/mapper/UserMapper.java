package com.abcsh.exercise.statement.mapper;

import com.abcsh.exercise.statement.entity.User;
import org.springframework.stereotype.Repository;

@Repository//最后发现是这样的:@repository跟@Service,@Compent,@Controller这4种注解是没什么本质区别,
// 都是声明作用,取不同的名字只是为了更好区分各自的功能.下图更多的作用是mapper注册到类似于以前
// mybatis.xml中的mappers里.
public interface UserMapper {
    User getUserByAccount(String account);
    void createUserByID(User user);
}
