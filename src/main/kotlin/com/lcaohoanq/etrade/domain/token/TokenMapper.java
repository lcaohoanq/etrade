package com.lcaohoanq.etrade.domain.token;

import com.lcaohoanq.etrade.domain.token.Token;
import com.lcaohoanq.etrade.domain.token.TokenPort.TokenResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TokenMapper {
    
    TokenResponse toTokenResponse(Token token);

}
