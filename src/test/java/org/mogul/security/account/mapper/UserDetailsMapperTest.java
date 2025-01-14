package org.mogul.security.account.mapper;

import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mogul.config.RootConfig;
import org.mogul.security.account.domain.AuthVO;
import org.mogul.security.account.domain.MemberVO;
import org.mogul.security.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class, SecurityConfig.class})
@Log4j
public class UserDetailsMapperTest {

    @Autowired
    private UserDetailsMapper mapper;

    @Test
    public void testGet() {
        MemberVO member = mapper.get("admin");
        log.info(member);
        for (AuthVO auth : member.getAuthList()) {
            log.info(auth);
        }
    }
}
