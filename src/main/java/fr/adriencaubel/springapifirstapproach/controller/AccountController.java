package fr.adriencaubel.springapifirstapproach.controller;


import fr.adriencaubel.springapifirstapproach.api.AccountApi;
import fr.adriencaubel.springapifirstapproach.dto.Account;
import fr.adriencaubel.springapifirstapproach.dto.DepositRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

public class AccountController implements AccountApi {
    @Override
    public Optional<NativeWebRequest> getRequest() {
        return AccountApi.super.getRequest();
    }

    @Override
    public ResponseEntity<Void> depositToAccount(DepositRequest depositRequest) {
        return AccountApi.super.depositToAccount(depositRequest);
    }

    @Override
    public ResponseEntity<Account> getAccount() {
        return AccountApi.super.getAccount();
    }
}
