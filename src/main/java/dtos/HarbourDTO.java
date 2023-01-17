package dtos;


import entities.Boat;
import entities.Harbour;
import java.util.*;

public class HarbourDTO {
    private Long id;
    private String name;
    private String address;
    private Integer capacity;
    private Set<BoatDTO> boats;

    public HarbourDTO(Harbour harbour) {
        if (harbour.getId() != null){
            this.id = harbour.getId();
        }
        this.name = harbour.getName();
        this.address = harbour.getAddress();
        this.capacity = harbour.getCapacity();
        this.boats = BoatDTO.makeDTOSet(harbour.getBoats());
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

    public Integer getCapacity() {
        return capacity;
    }

    public Set<BoatDTO> getBoats() {
        return boats;
    }

    public static Set<HarbourDTO> makeDTOSet(List<Harbour> harbours) {
        Set<HarbourDTO> harbourDTOSet = new HashSet<>();
        harbours.forEach(harbour -> harbourDTOSet.add(new HarbourDTO(harbour)));
        return harbourDTOSet;
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
//            this.ownerDTOSet = OwnerDTO.makeDTOSet(boat.getOwners());
        }

        public static Set<BoatDTO> makeDTOSet(Set<Boat> boatSet) {
            Set<BoatDTO> boatDTOSet = new LinkedHashSet<>();
            boatSet.forEach(boat -> boatDTOSet.add(new BoatDTO(boat)));
            return boatDTOSet;
        }


//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            BoatDTO boatDTO = (BoatDTO) o;
//            return Objects.equals(id, boatDTO.id) && Objects.equals(brand, boatDTO.brand) && Objects.equals(model, boatDTO.model) && Objects.equals(name, boatDTO.name) && Objects.equals(image, boatDTO.image);
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(id, brand, model, name, image);
//        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HarbourDTO that = (HarbourDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(address, that.address) && Objects.equals(capacity, that.capacity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, capacity);
    }
}
