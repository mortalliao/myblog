package abc.mortalliao.server.web.validate.code;

import abc.mortalliao.server.web.security.properties.SecurityProperties;
import abc.mortalliao.server.web.validate.code.image.ImageCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidateCodeBeanConfig {

    @Autowired
    private SecurityProperties securityProperties;

    @Bean
    @ConditionalOnMissingBean(name = "imageValidateCodeGenerator")
    public ValidateCodeGenerator imageValidateCodeGenerator() {
        ImageCodeGenerator codeGenerator = new ImageCodeGenerator();
        codeGenerator.setSecurityProperties(securityProperties);
        return codeGenerator;
    }

//    @Bean
//    @ConditionalOnMissingBean(SmsCodeSender.class)
//    public SmsCodeSender smsCodeSender() {
//        return new DefaultSmsCodeSender();
//    }
}
