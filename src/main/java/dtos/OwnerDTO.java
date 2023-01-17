package dtos;

import entities.Boat;
import entities.Owner;

import java.util.*;

public class OwnerDTO {
    private Long id;
    private String name;
    private String address;
    private String phone;

    private Set<BoatDTO> boatDTOS = new LinkedHashSet<>();


    public OwnerDTO(Owner owner) {
        if (owner.getId() != null) {
            this.id = owner.getId();
        }
        this.name = owner.getName();
        this.address = owner.getAddress();
        this.phone = owner.getPhone();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public Set<BoatDTO> getBoatDTOS() {
        return boatDTOS;
    }

    public static Set<OwnerDTO> makeDTOSet(List<Owner> owners) {
        Set<OwnerDTO> ownerDTOSet = new LinkedHashSet<>();
        for (Owner owner : owners) {
            ownerDTOSet.add(new OwnerDTO(owner));
        }
        return ownerDTOSet;
    }

    public static Set<OwnerDTO> makeDTOSet(Set<Owner> owners) {
        Set<OwnerDTO> ownerDTOSet = new LinkedHashSet<>();
        for (Owner owner : owners) {
            ownerDTOSet.add(new OwnerDTO(owner));
        }
        return ownerDTOSet;
    }

    public static class BoatDTO {
        private Long id;
        private String brand;
        private String model;
        private String name;
        private String image;

        public BoatDTO(Boat boat) {
            if (boat.getId() != null) {
                this.id = boat.getId();
            }
            this.brand = boat.getBrand();
            this.model = boat.getModel();
            this.name = boat.getName();
            this.image = boat.getImage();
        }
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        OwnerDTO ownerDTO = (OwnerDTO) o;
//        return Objects.equals(id, ownerDTO.id) && Objects.equals(name, ownerDTO.name) && Objects.equals(address, ownerDTO.address) && Objects.equals(phone, ownerDTO.phone);
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OwnerDTO ownerDTO = (OwnerDTO) o;
        return Objects.equals(id, ownerDTO.id) && Objects.equals(name, ownerDTO.name) && Objects.equals(address, ownerDTO.address) && Objects.equals(phone, ownerDTO.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, phone);
    }
}
