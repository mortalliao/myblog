package abc.mortalliao.server.web.validate.code.sms;

/**
 * @author Jim
 */
public interface SmsCodeSender {

    void send(String mobile, String code);
}
