package net.joaolourenco.blog.authentication.services.api;

import net.joaolourenco.common.authentication.models.UserCached;

public interface Authentication {

    Long register(String username, String password);

    UserCached login(String username, String password);

    void logout(Long userId);

    Boolean isValid(String token);

    void destroyAllActiveSessions();

}
