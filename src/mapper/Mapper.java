package mapper;

import model.User;
import model.dto.UserDto;

public class Mapper {
    public static UserDto fromUserToUserDto(User user){
        if(user==null){
            return null;
        }
        return new UserDto(user.getId(), user.getName(), user.getEmail());
    }
}
