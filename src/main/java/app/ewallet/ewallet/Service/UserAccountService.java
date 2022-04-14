package app.ewallet.ewallet.Service;

import app.ewallet.ewallet.DTO.UserAccountModel;
import app.ewallet.ewallet.DTO.UserAccountReqModel;
import org.springframework.stereotype.Service;

@Service
public interface UserAccountService {
    UserAccountModel register(UserAccountReqModel userAccountReqModel);
}
