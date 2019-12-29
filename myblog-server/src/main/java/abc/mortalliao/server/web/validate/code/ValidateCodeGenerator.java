package abc.mortalliao.server.web.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author Jim
 */
public interface ValidateCodeGenerator {

    ValidateCode generate(ServletWebRequest request);
}
