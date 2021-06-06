package com.kkaj.advertising.controller;

import com.kkaj.advertising.dto.AnnonceDto;
import com.kkaj.advertising.payload.ResponseCode;
import com.kkaj.advertising.payload.ResponseStatus;
import com.kkaj.advertising.payload.RestResponse;
import com.kkaj.advertising.service.AnnonceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("advertising/v1")
@Api(value = "API exposant les services GESTION DES ANNONCES",description = "Définition des API permettant  de consommer les services gestion des annonces ")
public class AnnonceController {


    Logger logger = LoggerFactory.getLogger(AnnonceController.class);

    private static final String ENTITY_NAME = "annonce";

    private static final String APPLICATION_NAME = "advertising";

    private AnnonceService annonceService;

    @Autowired
    public AnnonceController(AnnonceService annonceService) {
        this.annonceService = annonceService;
    }

    /**
     *{@code POST  /create} : Créer une nouvelle annonce
     * @param annonceDto
     * @return
     */
    @ApiOperation("methode pour créér une annonce")
    @PostMapping("/annonces/create")
    public RestResponse annonceResponse(@RequestBody AnnonceDto annonceDto){
        RestResponse restResponse = new RestResponse();
        restResponse.setCode(ResponseCode.OK);
        restResponse.setMessage("Successfull");
        restResponse.setStatus(ResponseStatus.SUCCESS);
        restResponse.setData(annonceService.save(annonceDto));
        return restResponse;
    }

    /**
     * service pour avoir la liste des annonces
     * @return
     */

    @ApiOperation("methode pour recupérer la liste de toutes les annonces")
    @GetMapping("/annonces/findAll")
    public RestResponse annonceResponse(){
        RestResponse restResponse = new RestResponse();
        restResponse.setCode(ResponseCode.OK);
        restResponse.setMessage("Successfull");
        restResponse.setStatus(ResponseStatus.SUCCESS);
        restResponse.setData(annonceService.findAll());
        return restResponse;
    }

    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("/annonces/delete/{idAnnonce}")
    @ApiOperation("methode pour supprimer une annonce en fonction de l'id")
    public RestResponse annoncedeleteResponse(@PathVariable("idAnnonce") Long id){
        RestResponse restResponse = new RestResponse();
        restResponse.setCode(ResponseCode.OK);
        restResponse.setMessage("Successfull");
        restResponse.setStatus(ResponseStatus.SUCCESS);
        restResponse.setData("");
        annonceService.delete(id);
        return restResponse;
    }

    /**
     * rechercher une annonce en fonction de son id
     * @param id
     * @return
     */
    @GetMapping("/annonces/findById/{idAnnonce}")
    @ApiOperation("methode pour rechercher une annonce en fonction de son identifiant")
    public RestResponse annonceByResponse(@PathVariable("idAnnonce") Long id){
        RestResponse restResponse = new RestResponse();
        restResponse.setCode(ResponseCode.OK);
        restResponse.setMessage("Successfull");
        restResponse.setStatus(ResponseStatus.SUCCESS);
        restResponse.setData(annonceService.findById(id));
        return restResponse;
    }

    @GetMapping("/annonces/findByConcessionnaire/{idConcessionnaire}")
    @ApiOperation("methode pour recupérer une annonce en fonction du concessionnaire ")
    public RestResponse annonceResponse(@PathVariable("idConcessionnaire") Long idConcessionnaire){
        RestResponse restResponse = new RestResponse();
        restResponse.setCode(ResponseCode.OK);
        restResponse.setMessage("Successfull");
        restResponse.setStatus(ResponseStatus.SUCCESS);
        restResponse.setData(annonceService.findByConcessionnaire(idConcessionnaire));
        return restResponse;
    }


}
