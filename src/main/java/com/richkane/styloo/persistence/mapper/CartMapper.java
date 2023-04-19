package com.richkane.styloo.persistence.mapper;

import com.richkane.styloo.persistence.dto.response.CartResponse;
import com.richkane.styloo.persistence.model.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(uses = {
        ItemMapper.class, CustomerDetailsMapper.class
})
public interface CartMapper {
    @Mapping(target = "items", source = "items")
    Cart cartDTOToCart(CartResponse cartResponse);
    @Mapping(target = "items", source = "items")
    CartResponse cartToCartDTO(Cart cart);
    List<CartResponse> cartsToCartDTOs(List<Cart> carts);
    List<Cart> cartDTOsToCarts(List<CartResponse> cartResponses);
}
