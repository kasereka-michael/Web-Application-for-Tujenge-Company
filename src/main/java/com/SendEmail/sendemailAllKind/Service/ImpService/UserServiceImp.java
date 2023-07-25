package com.SendEmail.sendemailAllKind.Service.ImpService;

import com.SendEmail.sendemailAllKind.Repository.ConfirmationRepository;
import com.SendEmail.sendemailAllKind.Repository.UserRepository;
import com.SendEmail.sendemailAllKind.Service.Email_Service;
import com.SendEmail.sendemailAllKind.Service.UserService;
import com.SendEmail.sendemailAllKind.domain.Confirmation;
import com.SendEmail.sendemailAllKind.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final ConfirmationRepository confirmationRepository;
    private final Email_Service emailService;



    @Override
    public User saveUser(User user) {
        if(userRepository.existsByEmail((user.getEmail()))){throw new RuntimeException("Email Already exist");}
        user.setEnabled(false);
        userRepository.save(user);

        Confirmation confirmation = new Confirmation(user);
        confirmationRepository.save(confirmation);

//        emailService.sendSimpleMailMessage(user.getName(), user.getEmail(), confirmation.getToken());
//        emailService.sendMineMessageWithAttachment(user.getName(), user.getEmail(), confirmation.getToken());
//        emailService.sendSimpleMailMessageWithEmbeddedFiles(user.getName(), user.getEmail(), confirmation.getToken());
//        emailService.sendSimpleHtmlEmail(user.getName(), user.getEmail(), confirmation.getToken());
        emailService.sendSimpleHtmlEmailWithEmbeddedFile(user.getName(), user.getEmail(), confirmation.getToken());
        return user;
    }

    @Override
    public Boolean verifyToken(String token) {

        Confirmation confirmation = confirmationRepository.findByToken(token);
        if(confirmation == null)
            return Boolean.FALSE;

        User user = userRepository.findByEmailIgnoreCase(confirmation.getUser().getEmail());
        user.setEnabled(true);
        userRepository.save(user);
//        confirmationRepository.delete(confirmation);
        return Boolean.TRUE;
    }
}
