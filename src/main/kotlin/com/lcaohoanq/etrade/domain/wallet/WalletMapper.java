package com.lcaohoanq.etrade.domain.wallet;

import com.lcaohoanq.etrade.domain.wallet.Wallet;
import com.lcaohoanq.etrade.domain.wallet.WalletPort.WalletResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WalletMapper {

    WalletResponse toWalletResponse(Wallet wallet);

}