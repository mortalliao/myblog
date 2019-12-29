package abc.mortalliao.server.web.security.properties;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Jim
 */
@Getter
@Setter
public class BrowserProperties {

    private String loginPage = "/test-signIn.html";

    private LoginType loginType = LoginType.JSON;
}
