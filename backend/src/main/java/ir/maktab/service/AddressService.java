package ir.maktab.service;


import ir.maktab.data.AddressDao;
import ir.maktab.model.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressDao addressRepository;

    public Address save(Address address) {
        Optional<Address> foundedAddress = addressRepository.findByZipCode(address.getZipCode());
        return foundedAddress.orElseGet(() -> addressRepository.save(address));
    }

    public Address findByZipCode(Long zipCode) {
        Optional<Address> address = addressRepository.findByZipCode(zipCode);
        return address.orElseThrow(() -> new RuntimeException("address not exist!"));
    }
}
