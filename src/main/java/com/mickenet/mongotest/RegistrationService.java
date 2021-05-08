package com.mickenet.mongotest;

import java.util.List;
import java.util.UUID;

public interface RegistrationService {
    Registration getReregistrationById(UUID id);
    List<Registration> getReregistrationById();
    Registration createRegistration(Registration vehicleCreateDTO);
    Registration deleteRegistrationById(UUID id);
    Registration  updateRegistration(Registration registration);
}
