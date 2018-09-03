package net.joaolourenco.common.authentication.models;

import lombok.Data;
import org.joda.time.DateTime;
import java.util.List;

@Data public class UserCached {

    String username;
    String token;
    DateTime expiration;
    List<String> permissions;

}