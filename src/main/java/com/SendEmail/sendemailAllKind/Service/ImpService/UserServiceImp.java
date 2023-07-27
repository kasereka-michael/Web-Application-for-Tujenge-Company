package com.SendEmail.sendemailAllKind.Service.ImpService;

import com.SendEmail.sendemailAllKind.Repository.ConfirmationRepository;
import com.SendEmail.sendemailAllKind.Repository.EmailRepository;
import com.SendEmail.sendemailAllKind.Repository.UserRepository;
import com.SendEmail.sendemailAllKind.Service.Email_Service;
import com.SendEmail.sendemailAllKind.Service.UserService;
import com.SendEmail.sendemailAllKind.domain.Confirmation;
import com.SendEmail.sendemailAllKind.domain.Email;
import com.SendEmail.sendemailAllKind.domain.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final ConfirmationRepository confirmationRepository;
    private final Email_Service emailService;
    private final EmailRepository emailRepository;



    @Override
    public Users saveUser(Users users) {
        Email email = emailRepository.findByEmailIgnoreCase(users.getEmail().getEmail());
        if(email == null){
            users.setEnabled(false);
            userRepository.save(users);

        }
        else if(userRepository.existsById(email.getId())){
            throw new RuntimeException("Email Already exist");
        }
        Confirmation confirmation = new Confirmation(users);
        confirmationRepository.save(confirmation);


//        emailService.sendSimpleMailMessage(users.getName(), users.getEmail(), confirmation.getToken());
//        emailService.sendMineMessageWithAttachment(users.getName(), users.getEmail(), confirmation.getToken());
//        emailService.sendSimpleMailMessageWithEmbeddedFiles(users.getName(), users.getEmail(), confirmation.getToken());
//        emailService.sendSimpleHtmlEmail(users.getName(), users.getEmail(), confirmation.getToken());
        emailService.sendSimpleHtmlEmailWithEmbeddedFile(users.getName(), users.getEmail().getEmail(), confirmation.getToken());
        return users;
    }

    @Override
    public long getAllsuscribers() {
        return userRepository.count();
    }

    @Override
    public Boolean verifyToken(String token) {

        Confirmation confirmation = confirmationRepository.findByToken(token);
        if(confirmation == null)
            return Boolean.FALSE;
        Email email = emailRepository.findByEmailIgnoreCase(confirmation.getUsers().getEmail().getEmail());

        if(confirmation.getUsers().getEmail().getEmail().equals(email.getEmail())){
            Users users = userRepository.getById(email.getId());
            users.setEnabled(true);
            userRepository.save(users);
        }
//        confirmationRepository.delete(confirmation);
        return Boolean.TRUE;
    }
}
