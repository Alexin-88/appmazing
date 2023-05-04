package com.campusdual.appmazing.api;

import com.campusdual.appmazing.model.dto.ProductDto;

import java.util.List;

public interface IProductService {

    ProductDto queryProduct(ProductDto productDto);

    List<ProductDto> queryAllProducts();

    int insertProduct(ProductDto productDto);

    int updateProduct(ProductDto productDto);

    int deleteProduct(ProductDto productDto);
}
