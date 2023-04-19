package com.richkane.styloo.persistence.mapper;

import com.richkane.styloo.persistence.dto.response.CustomerDetailsResponse;
import com.richkane.styloo.persistence.model.CustomerDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface CustomerDetailsMapper {
    @Mapping(target = "cart", source = "cart")
    CustomerDetails customerDetailsDTOToCustomerDetails(CustomerDetailsResponse customerDetailsResponse);
    @Mapping(target = "cart", source = "cart")
    CustomerDetailsResponse customerDetailsToCustomerDetailsDTO(CustomerDetails customerDetails);
    List<CustomerDetailsResponse> customerDetailsListToCustomerDetailsDTOs(List<CustomerDetails> customerDetailsList);
    List<CustomerDetails> customerDetailsDTOsToCustomerDetailsList(List<CustomerDetailsResponse> customerDetailsResponses);
}
