package dtos;

import entities.Harbour;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//import static jdk.internal.org.jline.utils.Colors.h;

public class HarbourDTOs {
    private Set<HarbourDTO> all = new HashSet<>();

    public HarbourDTOs (List<Harbour> harbours){
        harbours.forEach(harbour -> all.add(new HarbourDTO(harbour)));
    }

    public Set<HarbourDTO> getAll() {
        return all;
    }
}
