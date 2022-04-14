package app.ewallet.ewallet.Service;

import app.ewallet.ewallet.DTO.UserAccountModel;
import app.ewallet.ewallet.DTO.UserAccountReqModel;
import app.ewallet.ewallet.Entity.UserAccount;
import app.ewallet.ewallet.Entity.UserAccount.Role;
import app.ewallet.ewallet.Repo.UserAccountRepo;
import app.ewallet.ewallet.Utility.Exception.ServiceException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserAccountServiceImpl implements UserAccountService{

    private UserAccountRepo userAccountRepo;

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public UserAccountModel register(UserAccountReqModel userAccountReqModel) {
        if(userAccountReqModel.getRole().equalsIgnoreCase("MERCHANT")) {
            UserAccount userByEmail = userAccountRepo.findByEmail(userAccountReqModel.getEmail());
            if (userByEmail != null && userByEmail.getEmail() != null)
                throw new ServiceException(409, "Email already exists.");

            UserAccount userByPhone = userAccountRepo.findByPhoneNumber(userAccountReqModel.getPhoneNumber());
            if (userByPhone != null && userByPhone.getPhoneNumber() != null)
                throw new ServiceException(409, "Phone Number already exists.");

            UserAccount newUser = new UserAccount();
            newUser.setEmail(userAccountReqModel.getEmail());
            newUser.setPassword(userAccountReqModel.getPassword());
            newUser.setFullName(userAccountReqModel.getFullName());
            newUser.setPhoneNumber(userAccountReqModel.getPhoneNumber());
            newUser.setRole(Role.ROLE_MERCHANT);
            newUser = userAccountRepo.save(newUser);

            UserAccountModel userAccountModel = new UserAccountModel();
            BeanUtils.copyProperties(newUser, userAccountModel);

            return userAccountModel;
        } else if (userAccountReqModel.getRole().equalsIgnoreCase("CUSTOMER")) {
            System.out.println("2");
            UserAccount userByEmail = userAccountRepo.findByEmail(userAccountReqModel.getEmail());
            if (userByEmail != null && userByEmail.getEmail() != null)
                throw new ServiceException(409, "Email already exists.");

            UserAccount userByPhone = userAccountRepo.findByPhoneNumber(userAccountReqModel.getPhoneNumber());
            if (userByPhone != null && userByPhone.getPhoneNumber() != null)
                throw new ServiceException(409, "Phone Number already exists.");

            UserAccount newUser = new UserAccount();
            newUser.setEmail(userAccountReqModel.getEmail());
            newUser.setPassword(userAccountReqModel.getPassword());
            newUser.setFullName(userAccountReqModel.getFullName());
            newUser.setPhoneNumber(userAccountReqModel.getPhoneNumber());
            newUser.setRole(Role.ROLE_CUSTOMER);
            newUser = userAccountRepo.save(newUser);

            UserAccountModel userAccountModel = new UserAccountModel();
            BeanUtils.copyProperties(newUser, userAccountModel);

            return userAccountModel;
        } else if (userAccountReqModel.getRole().equalsIgnoreCase("ADMIN")) {
            System.out.println("3");
            UserAccount userByEmail = userAccountRepo.findByEmail(userAccountReqModel.getEmail());
            if (userByEmail != null && userByEmail.getEmail() != null)
                throw new ServiceException(409, "Email already exists.");

            UserAccount userByPhone = userAccountRepo.findByPhoneNumber(userAccountReqModel.getPhoneNumber());
            if (userByPhone != null && userByPhone.getPhoneNumber() != null)
                throw new ServiceException(409, "Phone Number already exists.");

            UserAccount newUser = new UserAccount();
            newUser.setEmail(userAccountReqModel.getEmail());
            newUser.setPassword(userAccountReqModel.getPassword());
            newUser.setFullName(userAccountReqModel.getFullName());
            newUser.setPhoneNumber(userAccountReqModel.getPhoneNumber());
            newUser.setRole(Role.ROLE_ADMIN);
            newUser = userAccountRepo.save(newUser);

            UserAccountModel userAccountModel = new UserAccountModel();
            BeanUtils.copyProperties(newUser, userAccountModel);

            return userAccountModel;
        } else {
            throw new ServiceException(400, "Your input doesn't recognize");
        }
    }


}
