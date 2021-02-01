package eurogeo.pl.linear.linearservice.web.controller;

import eurogeo.pl.linear.linearservice.services.OperatService;
import eurogeo.pl.linear.model.OperatDto;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@CrossOrigin
@RequiredArgsConstructor
@RestController
public class OperatController {

    private static final Integer DEFAULT_PAGE_NUMBER = 0;
    private static final Integer DEFAULT_PAGE_SIZE = 25;
    private final OperatService operatService;

    @GetMapping(produces = { "application/json" }, path = "operat")
    public ResponseEntity<List<OperatDto>> listOperats(@RequestParam(value = "operatLayer", required = false) String layer,
                                                       @RequestParam(value = "projektId", required = true) UUID projectId
    ){

       List operatList = operatService.listOperatsByLayer(projectId,layer);

        return new ResponseEntity<>(operatList, HttpStatus.OK);
    }

    @GetMapping(produces = { "application/json" }, path = "operatbykm")
    public ResponseEntity<List<OperatDto>> listOperatsBeetwenScope(@RequestParam(value = "km", required = true) double kmValue,
                                                       @RequestParam(value = "projektId", required = true) UUID projectId){
        double fromScope = kmValue;
        double toScope = kmValue;

        List operatList = operatService.listOperatsBeetwenScope(fromScope,toScope,projectId);

        return new ResponseEntity<>(operatList, HttpStatus.OK);
    }

    @GetMapping(produces = { "application/json" }, path = "operatL")
    public ResponseEntity<List<OperatDto>> listOperatsLessThan(
  //          @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
  //          @RequestParam(value = "pageSize", required = false) Integer pageSize,
            @RequestParam(value = "km", required = true) double kmValue,
            @RequestParam(value = "projektId", required = true) UUID projectId){

        double fromScope = kmValue;


   /*    if (pageNumber == null || pageNumber < 0){
            pageNumber = DEFAULT_PAGE_NUMBER;
        }

        if (pageSize == null || pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }*/


     //   OperatPagedList operatList = operatServices.listOperatsLessThan(fromScope,projectId,
     //           PageRequest.of(pageNumber, pageSize));
       List operatList = operatService.listOperatsLessThan(fromScope,projectId);

        return new ResponseEntity<>(operatList, HttpStatus.OK);
    }
    @GetMapping(produces = { "application/json" }, path = "operatbetween")
    public ResponseEntity<List<OperatDto>> listOperatBetween( @RequestParam(value = "odkm", required = true) double odkmValue,
                                                              @RequestParam(value = "dokm", required = true) double dokmValue,
                                                              @RequestParam(value = "projektId", required = true) UUID projectId ){

        double fromScope = odkmValue;
        double toScope = dokmValue;

        List operatList = operatService.listOperatsInScope(fromScope,toScope,projectId,fromScope,toScope);

        return new ResponseEntity<>(operatList, HttpStatus.OK);
    }

    @GetMapping("operat/{projektId}/{operatId}")
    public ResponseEntity<OperatDto> getOperatByOperatNumberAndProjectId(@PathVariable("operatId") long operatNumber,
                                                                       @PathVariable("projektId") UUID projectId){


        return new ResponseEntity<>(operatService.getByOperatIdAndProjectId(operatNumber,projectId), HttpStatus.OK);
    }
    @GetMapping("operatProjekt")
    public ResponseEntity<List<OperatDto>> getOperatByProjectId
            (@RequestParam(value = "projektId") String projektId){
        UUID projektUUID = UUID.fromString(projektId);
        return new ResponseEntity<>(operatService.getByProjectId(projektUUID), HttpStatus.OK);

    }
    @PostMapping(path = "operat")
    public ResponseEntity<OperatDto> saveOperat(@RequestBody @Validated OperatDto operatDto){



        return new ResponseEntity<>(operatService.saveNewOperat(operatDto),HttpStatus.CREATED);
    }

    @PutMapping(path= "operatUpdate")
    public  ResponseEntity<OperatDto> updateOperat(@RequestBody OperatDto operatDto){
         UUID operatId = operatDto.getId();
        return new ResponseEntity<>(operatService.updateOperat(operatId,operatDto), HttpStatus.NO_CONTENT);
    }


}
