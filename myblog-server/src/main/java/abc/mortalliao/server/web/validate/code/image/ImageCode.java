package abc.mortalliao.server.web.validate.code.image;

import abc.mortalliao.server.web.validate.code.ValidateCode;
import lombok.Getter;
import lombok.Setter;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @author Jim
 */
public class ImageCode extends ValidateCode {

    @Getter
    @Setter
    private BufferedImage image;

    public ImageCode(BufferedImage image, String code, int expireIn) {
        super(code, expireIn);
        this.image = image;
    }

    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
        super(code, expireTime);
        this.image = image;
    }

}
