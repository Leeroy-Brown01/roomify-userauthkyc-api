package co.zw.com.roomify.roomify.controller;

import co.zw.com.roomify.roomify.dto.common.ApiResponse;
import co.zw.com.roomify.roomify.service.EntitlementsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserEntitlementsController {

    private final EntitlementsService entitlementsService;

    @GetMapping("/entitlements")
    public ApiResponse<?> entitlements() {
        return ApiResponse.ok(entitlementsService.myEntitlements());
    }
}
