package entities;

import dtos.OwnerDTO;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "owner")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String address;
    private String phone;
    @ManyToMany
    private Set<Boat> boats = new HashSet<>();

    public Owner() {
    }

    public Owner(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public Owner(OwnerDTO ownerDTO) {
        if(ownerDTO.getId()!= null)
        {this.id = ownerDTO.getId();}
        this.name = ownerDTO.getName();
        this.address = ownerDTO.getAddress();
        this.phone = ownerDTO.getPhone();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Boat> getBoats() {
        return boats;
    }

    public void addBoat(Boat boat) {
        this.boats.add(boat);
        boat.getOwners().add(this);
    }

    public void removeBoat(Boat boat) {
        this.boats.remove(boat);
        boat.getOwners().remove(this);
    }




}