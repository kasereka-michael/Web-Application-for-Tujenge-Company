package com.SendEmail.sendemailAllKind.Service;

import com.SendEmail.sendemailAllKind.domain.Members;

public interface MembersService {
 Boolean saveMember(Members members);
 long totalMembers();
}
