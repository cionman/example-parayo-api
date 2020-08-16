package com.example.parayo.controller

import com.example.parayo.common.ApiResponse
import com.example.parayo.domain.auth.SignupRequest
import com.example.parayo.domain.auth.SignupService
import com.example.parayo.domain.product.Product
import com.example.parayo.domain.product.ProductService
import com.example.parayo.domain.product.registration.ProductRegistrationRequest
import com.example.parayo.domain.product.registration.ProductRegistrationService
import com.example.parayo.domain.product.toProductListItemResponse
import com.example.parayo.domain.user.User
import com.google.firebase.auth.hash.Bcrypt
import org.mindrot.jbcrypt.BCrypt
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/api/v1")
class ProductApiController @Autowired constructor(
    private val productRegistrationService: ProductRegistrationService,
    private val productService: ProductService
){
    @PostMapping("/products")
    fun register(
        @RequestBody request: ProductRegistrationRequest
    ) = ApiResponse.ok(productRegistrationService.register(request))


    @GetMapping("/products")
    fun search(
        @RequestParam productId: Long,
        @RequestParam(required = false) categoryId: Int?,
        @RequestParam direction: String,
        @RequestParam(required = false) keyword: String?,
        @RequestParam(required = false) limit: Int?
    ) = productService
        .search(categoryId, productId, direction, limit ?: 10)
        .mapNotNull(Product::toProductListItemResponse)
        .let { ApiResponse.ok(it) }
}
