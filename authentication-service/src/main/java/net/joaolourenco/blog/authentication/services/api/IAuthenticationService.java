package net.joaolourenco.blog.authentication.services.api;

import net.joaolourenco.common.domain.authentication.UserCachedDTO;

public interface IAuthenticationService {

    Long register(String username, String password);

    UserCachedDTO login(String username, String password);

    void logout(Long userId);

    Boolean isValid(String token);

    void destroyAllActiveSessions();

}
