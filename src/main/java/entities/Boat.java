package entities;

import dtos.BoatDTO;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "boat")
public class Boat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "boat_id", nullable = true)
    private Long id;
    private String brand;
    private String model;
    private String name;
    private String image;
    @ManyToMany(mappedBy = "boats")
    private Set<Owner> owners = new HashSet<>();
    @ManyToOne //(cascade = { CascadeType.PERSIST, CascadeType.MERGE}) //owning side
    private Harbour harbour;

    public Boat() {
    }

    public Boat(BoatDTO boatDTO) {
        if(boatDTO.getId() != null){
            this.id = boatDTO.getId();
        }
        this.brand = boatDTO.getBrand();
        this.model = boatDTO.getModel();
        this.name = boatDTO.getName();
        this.image = boatDTO.getImage();
        this.harbour = new Harbour(boatDTO.getHarbour().getId(),
                boatDTO.getHarbour().getName(),
                boatDTO.getHarbour().getAddress(),
                boatDTO.getHarbour().getCapacity());
//        Ifølge domænediagram må owners ikke være tom, men...
        if(boatDTO.getOwners() != null) {
            boatDTO.getOwners().forEach(ownerDTO -> {
                this.addOwner(new Owner(ownerDTO.getName(), ownerDTO.getAddress(), ownerDTO.getPhone()));

            });
        }
    }

    public Boat(String brand, String model, String name, String image/*, Harbour harbour*/) {
        this.brand = brand;
        this.model = model;
        this.name = name;
        this.image = image;
//        this.harbour = harbour;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String make) {
        this.model = make;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<Owner> getOwners() {
        return owners;
    }

    public void setOwners(Set<Owner> owners) {
        this.owners = owners;
    }

    public void addOwner(Owner owner) {
        this.owners.add(owner);
        owner.addBoat(this);

    }

    public Harbour getHarbour() {
        return harbour;
    }

    public void setHarbour(Harbour harbour) {
        this.harbour = harbour;
//        harbour.addBoat(this);
    }
}