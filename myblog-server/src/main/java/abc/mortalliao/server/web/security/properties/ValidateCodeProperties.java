package abc.mortalliao.server.web.security.properties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidateCodeProperties {

    private ImageCodeProperties image = new ImageCodeProperties();

    private SmsCodeProperties sms = new SmsCodeProperties();

}
