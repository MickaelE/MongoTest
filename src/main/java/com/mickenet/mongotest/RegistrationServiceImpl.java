package com.mickenet.mongotest;

import com.mongodb.MongoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class RegistrationServiceImpl implements RegistrationService{
    @Autowired
    private RegistrationRepository registrationRepository;
    @Override
    public Registration getReregistrationById(UUID id) {
        if (registrationRepository.findById(id).isPresent())
            return registrationRepository.findById(id).get();
        else
            throw new MongoException("Record not Found");
    }
    @Override
    public List<Registration> getReregistration() {
            return registrationRepository.findAll();
    }

    @Override
    public Registration createRegistration(Registration registration1) {
        Registration registration = new Registration(registration1.getLag(), registration1.getPersonalia(), registration1.getSizes());

        return registrationRepository.save(registration);
    }

    @Override
    public Registration updateRegistration(Registration registration) {
        if (registrationRepository.findById(registration.get_id()).isPresent()){
            Registration existingVehicle = registrationRepository.findById(registration.get_id()).get();
            existingVehicle.setLag(registration.getLag());
            existingVehicle.setPersonalia(registration.getPersonalia());
            existingVehicle.setSizes(registration.getSizes());
            return registrationRepository.save(existingVehicle);
        }
        else
            throw new MongoException("Record not found");
    }

    @Override
    public Registration deleteRegistrationById(UUID id) {
        if (registrationRepository.findById(id).isPresent()){
            Registration vehicle = registrationRepository.findById(id).get();
            registrationRepository.delete(vehicle);
            return vehicle;
        }
        else
            throw new MongoException("Record not found");
    }
}
