package abc.mortalliao.server.web.controller;

import abc.mortalliao.server.model.domain.SysUser;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jim
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    @JsonView(SysUser.UserSimpleView.class)
    @ApiOperation(value = "用户查询服务")
    public List<SysUser> query() {
        List<SysUser> users = new ArrayList<>();
        users.add(new SysUser());
        users.add(new SysUser());
        users.add(new SysUser());
        return users;
    }

}
