package app.ewallet.ewallet.Rest;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import app.ewallet.ewallet.DTO.UserAccountModel;
import app.ewallet.ewallet.DTO.UserAccountReqModel;
import app.ewallet.ewallet.Service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rest/v1/user/")
public class UserController {

    @Autowired
    private UserAccountService userAccountService;


    @PostMapping("register")
    public UserAccountModel create(@RequestBody @Valid UserAccountReqModel userAccountReqModel,
                                   BindingResult result,
                                   HttpServletResponse response) throws IOException {
        UserAccountModel userAccountModel = new UserAccountModel();
        if (result.hasErrors() ) {
            response.sendError(HttpStatus.BAD_REQUEST.value(), result.getAllErrors().toString());
            return userAccountModel;
        } else {
            return userAccountService.register(userAccountReqModel);
        }
    }
}
