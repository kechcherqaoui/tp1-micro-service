package org.sid.bankaccountservice.service;

import lombok.AllArgsConstructor;
import org.sid.bankaccountservice.dto.BankAccountRequestDTO;
import org.sid.bankaccountservice.dto.BankAccountResponseDTO;
import org.sid.bankaccountservice.entities.BankAccount;
import org.sid.bankaccountservice.mapper.BankAccountMapper;
import org.sid.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final BankAccountRepository bankAccountRepository;
    private final BankAccountMapper accountMapper;

    @Override
    public BankAccountResponseDTO saveBankAccount(BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccount = accountMapper.fromBankAccountRequest(bankAccountRequestDTO);
        bankAccount.setId(UUID.randomUUID().toString());
        bankAccount.setCreatedAt(new Date());
        
        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);

        return accountMapper.fromBankAccount(savedBankAccount);
    }

    @Override
    public BankAccountResponseDTO updateBankAccount(String id, BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccount = accountMapper.fromBankAccountRequest(bankAccountRequestDTO);
        bankAccount.setId(id);

        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);

        return accountMapper.fromBankAccount(savedBankAccount);
    }
}
