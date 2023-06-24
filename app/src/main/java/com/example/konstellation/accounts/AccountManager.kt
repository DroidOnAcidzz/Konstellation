package com.example.konstellation.accounts

import com.example.konstellation.constellationGenerator.dataClasses.Star
import com.example.konstellation.constellationGenerator.dataClasses.StarType

class AccountManager {
    private val accounts:MutableList<Account> = mutableListOf()
    fun addAccount(account:Account){
        accounts.add(account)
    }
    fun getAccountsOfType(type: StarType):MutableList<Account>
    {
        val accountsOfType:MutableList<Account> = mutableListOf()
        for (account in accounts)
        {
            if (account.type==type)
            {
                accountsOfType.add(account)
            }
        }
        return accountsOfType
    }
}