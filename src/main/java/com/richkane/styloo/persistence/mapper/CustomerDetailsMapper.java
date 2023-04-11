package com.richkane.styloo.persistence.mapper;

import com.richkane.styloo.persistence.dto.response.CustomerDetailsDTO;
import com.richkane.styloo.persistence.model.CustomerDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface CustomerDetailsMapper {
    @Mapping(target = "cart", source = "cart")
    CustomerDetails customerDetailsDTOToCustomerDetails(CustomerDetailsDTO customerDetailsDTO);
    @Mapping(target = "cart", source = "cart")
    CustomerDetailsDTO customerDetailsToCustomerDetailsDTO(CustomerDetails customerDetails);
    List<CustomerDetailsDTO> customerDetailsListToCustomerDetailsDTOs(List<CustomerDetails> customerDetailsList);
    List<CustomerDetails> customerDetailsDTOsToCustomerDetailsList(List<CustomerDetailsDTO> customerDetailsDTOs);
}
