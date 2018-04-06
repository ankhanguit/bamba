package vn.jamek.baseweb.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import vn.jamek.baseweb.domain.User;

@Mapper
public interface UserMapper {
	
	List<User> login(final @Param("username") String username, final @Param("password") String password);

}
