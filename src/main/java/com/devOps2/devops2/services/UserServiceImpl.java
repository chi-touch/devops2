package com.devOps2.devops2.services;
import com.devOps2.devops2.dto.requests.LoginRequest;
import com.devOps2.devops2.dto.requests.RegisterRequest;
import com.devOps2.devops2.dto.responses.LoginResponse;
import com.devOps2.devops2.dto.responses.RegisterResponse;
import com.devOps2.devops2.exceptions.IllegalInputException;
import com.devOps2.devops2.exceptions.ThisUserAlreadyExistException;
import com.devOps2.devops2.models.DevUser;
import com.devOps2.devops2.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final   ModelMapper modelMapper;
    private final UserRepository userRepository;


    public RegisterResponse register(RegisterRequest registerRequest) {
        if(registerRequest.getUserName().isEmpty() ||registerRequest.getPassword().isEmpty()){
            throw new IllegalInputException("you can not register with an empty space");
        }
        if(!validateUser(registerRequest.getUserName())) throw new ThisUserAlreadyExistException("This user already exist enter another user name");
        DevUser devUser = modelMapper.map(registerRequest,DevUser.class);
        userRepository.save(devUser);
        RegisterResponse response = modelMapper.map(devUser, RegisterResponse.class);
        response.setMessage("Registered Successful");
        return response;

    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        DevUser user = findUserByName(loginRequest.getUserName());
        validatePassword(loginRequest);

        return modelMapper.map(user, LoginResponse.class);
    }

    private void validatePassword(LoginRequest loginRequest) {
         DevUser user = findUserByName(loginRequest.getUserName());
        if(!user.getPassword().equals(loginRequest.getPassword())) throw new RuntimeException("Wrong password");
    }
    private DevUser findUserByName(String userName) {
        DevUser user = userRepository.findDevUserByUserNameIgnoreCase(userName);
        if (user == null) throw new RuntimeException(userName + " does not exist");
        return user;
    }
    private boolean validateUser(String userName){
        var user = userRepository.findDevUserByUserNameIgnoreCase(userName);
        return user == null;
    }

}
