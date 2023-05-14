package es.severo.EasyProtein.controller;

import es.severo.EasyProtein.entities.Proteina;
import es.severo.EasyProtein.services.DatabaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final DatabaseService databaseService;

    public ApiController(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }


    @Operation( summary = "List all proteins")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All Proteins",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Proteina.class))),
            @ApiResponse(responseCode = "400", description = "Invalid id supplier"),
            @ApiResponse(responseCode = "500", description = "External server error")
    })
    @GetMapping("/proteinas")
    public List<Proteina> proteinas() {
        return databaseService.findAllProteinas();
    }


}
