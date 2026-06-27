package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.CustomerDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountsService{
    @Override
    public void createAccount(CustomerDto customerDto) {
        // Implementation for creating an account
    }


}
