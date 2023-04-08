package com.richkane.styloo.persistence.mapper;

import com.richkane.styloo.persistence.dto.CartDTO;
import com.richkane.styloo.persistence.model.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(uses = {
        ItemMapper.class
})
public interface CartMapper {
    @Mapping(target = "items", source = "items")
    @Mapping(target = "user", source = "user")
    Cart cartDTOToCart(CartDTO cartDTO);
    @Mapping(target = "items", source = "items")
    @Mapping(target = "user", source = "user")
    CartDTO cartToCartDTO(Cart cart);
    List<CartDTO> cartsToCartDTOs(List<Cart> carts);
    List<Cart> cartDTOsToCarts(List<CartDTO> cartDTOs);
}
