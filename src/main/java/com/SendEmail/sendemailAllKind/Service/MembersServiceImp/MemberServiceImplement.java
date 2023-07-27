package com.SendEmail.sendemailAllKind.Service.MembersServiceImp;

import com.SendEmail.sendemailAllKind.Repository.EmailRepository;
import com.SendEmail.sendemailAllKind.Repository.MembersRepository;
import com.SendEmail.sendemailAllKind.Service.MembersService;
import com.SendEmail.sendemailAllKind.domain.Email;
import com.SendEmail.sendemailAllKind.domain.Members;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberServiceImplement implements MembersService {
    private final EmailRepository emailRepository;
    private final MembersRepository membersRepository;
    @Override
    public Boolean saveMember(Members members) {
        boolean res= false;
        Email email = emailRepository.findByEmailIgnoreCase(members.getEmail().getEmail());
        if(!(email==null)) {
            throw new RuntimeException("Email Already exist");
        }
        else{
            membersRepository.save(members);
            res = true;
        }
        return res;
    }

    @Override
    public long totalMembers() {
        long totalMember = membersRepository.count();
        return totalMember;
    }
}
