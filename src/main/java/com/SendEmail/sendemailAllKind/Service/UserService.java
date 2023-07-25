package com.SendEmail.sendemailAllKind.Service;

import com.SendEmail.sendemailAllKind.domain.User;

public interface UserService {
    User saveUser(User user);
    Boolean verifyToken(String token);
}
