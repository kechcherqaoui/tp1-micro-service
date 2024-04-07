package org.sid.bankaccountservice.service;

import org.sid.bankaccountservice.dto.BankAccountRequestDTO;
import org.sid.bankaccountservice.dto.BankAccountResponseDTO;

public interface AccountService {
    BankAccountResponseDTO saveBankAccount(BankAccountRequestDTO bankAccountRequestDTO);

    BankAccountResponseDTO updateBankAccount(String id, BankAccountRequestDTO bankAccountRequestDTO);
}
