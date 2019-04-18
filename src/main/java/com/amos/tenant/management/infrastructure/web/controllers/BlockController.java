package com.amos.tenant.management.infrastructure.web.controllers;

import com.amos.tenant.management.infrastructure.web.models.AvailableBlockResponseJSON;
import com.amos.tenant.management.infrastructure.web.models.CreateBlockRequestJSON;
import com.amos.tenant.management.infrastructure.web.models.CreateBlockResponseJSON;
import com.amos.tenant.management.usecases.CreateAndRetrievedAllBlock;
import com.amos.tenant.management.usecases.exceptions.GenericInputErrorException;
import com.amos.tenant.management.usecases.models.CreateBlockResponse;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController("api/v1/blocks")
@Named
public class BlockController {

   private final CreateAndRetrievedAllBlock createAndRetrievedAllBlock;

    @Inject
    public BlockController(CreateAndRetrievedAllBlock createAndRetrievedAllBlock) {
        this.createAndRetrievedAllBlock = createAndRetrievedAllBlock;
    }

    @PostMapping(value = "/block")
    @ResponseBody
    CreateBlockResponseJSON creatBlock(@RequestHeader("Authorization") String authorization, @Valid @RequestBody CreateBlockRequestJSON createBlockRequestJSON) throws GenericInputErrorException {
        CreateBlockResponse createBlockResponse= createAndRetrievedAllBlock.createABlock(createBlockRequestJSON.getCreateBlockRequest());
        System.err.println("hello----3");
        return new CreateBlockResponseJSON(createBlockResponse.getId(),createBlockResponse.getName(),createBlockResponse.getDate());
    }
    @GetMapping(value = "/view/blocks")
    List<AvailableBlockResponseJSON> getAllBlocks(@RequestHeader("Authorization") String authorization){
        System.err.println("hello----3");
        return createAndRetrievedAllBlock.retrievedAllBlocks().stream().
                map(a-> new AvailableBlockResponseJSON(a.getId(),a.getName(),a.getNumberOfFlats())).collect(Collectors.toList());
    }

}
