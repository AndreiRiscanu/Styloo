package com.richkane.styloo.persistence.mapper;

import com.richkane.styloo.persistence.dto.ItemDTO;
import com.richkane.styloo.persistence.model.Item;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {
    ItemDTO itemToItemDTO(Item item);
    Item itemDTOToItem(ItemDTO itemDTO);
    List<Item> itemDTOsToItems(List<ItemDTO> itemDTOs);
    List<ItemDTO> itemsToItemDTOs(List<Item> items);
}
