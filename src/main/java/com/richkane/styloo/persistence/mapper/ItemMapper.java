package com.richkane.styloo.persistence.mapper;

import com.richkane.styloo.persistence.dto.response.ItemResponse;
import com.richkane.styloo.persistence.model.Item;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {
    ItemResponse itemToItemDTO(Item item);
    Item itemDTOToItem(ItemResponse itemResponse);
    List<Item> itemDTOsToItems(List<ItemResponse> itemResponses);
    List<ItemResponse> itemsToItemDTOs(List<Item> items);
}
