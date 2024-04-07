package org.sid.bankaccountservice.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import org.sid.bankaccountservice.enums.AccountType;

@Setter
@Getter
public class BankAccountRequestDTO {
    private Double balance;
    private String currency;
    private AccountType type;
}
