package org.sid.bankaccountservice.web;

import jakarta.annotation.security.DenyAll;
import lombok.AllArgsConstructor;
import org.sid.bankaccountservice.dto.BankAccountRequestDTO;
import org.sid.bankaccountservice.dto.BankAccountResponseDTO;
import org.sid.bankaccountservice.entities.BankAccount;
import org.sid.bankaccountservice.repositories.BankAccountRepository;
import org.sid.bankaccountservice.service.AccountService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AccountRestController {
    private final BankAccountRepository bankAccountRepository;
    private final AccountService accountService;

    @GetMapping("/bank-accounts")
    public List<BankAccount> getBankAccounts(){
        return bankAccountRepository.findAll();
    }

    @GetMapping("/bank-accounts/{id}")
    public BankAccount getBankAccounts(@PathVariable String id){
        return bankAccountRepository.findById(id)
              .orElseThrow(() -> new RuntimeException(String.format("Account %s not found!", id)));
    }

    @PostMapping("/bank-accounts")
    public BankAccountResponseDTO saveBankAccount(BankAccountRequestDTO requestDTO){
        return accountService.saveBankAccount(requestDTO);
    }

    @PutMapping("/bank-accounts/{id}")
    public BankAccount update(@PathVariable String id,
                              BankAccount bankAccount){
        BankAccount account = bankAccountRepository.findById(id)
              .orElseThrow(() -> new RuntimeException(String.format("Account %s not found!", id)));

        if (bankAccount.getBalance() != null)
            account.setBalance(bankAccount.getBalance());
        if (bankAccount.getType() != null)
            account.setType(bankAccount.getType());
        if (bankAccount.getCurrency() != null)
            account.setCurrency(bankAccount.getCurrency());

        return bankAccountRepository.save(account);
    }

    @DeleteMapping("/bank-accounts/{id}")
    public void delete(@PathVariable String id){
        bankAccountRepository.deleteById(id);
    }
}
