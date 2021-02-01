package eurogeo.pl.linear.linearservice.web.controller;


import eurogeo.pl.linear.linearservice.services.ProjektService;
import eurogeo.pl.linear.model.ProjektDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
@CrossOrigin
@RequiredArgsConstructor
@RestController
public class ProjektController {
    private final ProjektService projektService;


    @GetMapping(produces = {"application/json"}, path = "projekt")
    public ResponseEntity<Set<ProjektDto>> getProjektList() {
        Set<ProjektDto> projekts = new HashSet<>();
        projekts = projektService.projektSet();
        return new ResponseEntity<>(projekts, HttpStatus.ACCEPTED);
    }

    @GetMapping("projekt/{projektId}")
    public ResponseEntity<ProjektDto> getProjektById(@PathVariable("projektId") UUID projectId){
        System.out.println(projectId);
        return new ResponseEntity<>(projektService.getProjektDtoById(projectId), HttpStatus.FOUND);
    }

    @PostMapping(path="projekt")
    public ResponseEntity<ProjektDto> saveProjekt(@RequestBody @Validated ProjektDto projektDto)
    {

        return new ResponseEntity<>(projektService.saveNewProjekt(projektDto),HttpStatus.CREATED);
    }
    @PutMapping("projekt")
    public ResponseEntity<ProjektDto> updateProjektById(@RequestBody @Validated ProjektDto projektDto){

        return new ResponseEntity<>(projektService.updateProjekt(projektDto),HttpStatus.ACCEPTED);
    }

}
