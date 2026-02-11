package co.zw.com.roomify.roomify.controller;

import co.zw.com.roomify.roomify.dto.common.ApiResponse;
import co.zw.com.roomify.roomify.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserAccountController {

    private final AccountService accountService;

    @DeleteMapping("/account")
    public ApiResponse<?> requestDeletion(@RequestBody Object request) {
        // replace Object with AccountDeletionRequestDto next
        return ApiResponse.ok(accountService.requestDeletion(request));
    }
}
