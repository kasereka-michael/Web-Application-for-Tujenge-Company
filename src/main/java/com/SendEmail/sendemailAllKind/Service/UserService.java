package com.SendEmail.sendemailAllKind.Service;

import com.SendEmail.sendemailAllKind.domain.Users;

public interface UserService {
    Users saveUser(Users users);
    long getAllsuscribers();
    Boolean verifyToken(String token);
}
