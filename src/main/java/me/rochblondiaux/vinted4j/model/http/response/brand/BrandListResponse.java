package me.rochblondiaux.vinted4j.model.http.response.brand;

import lombok.Data;
import me.rochblondiaux.vinted4j.model.http.response.VintedResponse;
import me.rochblondiaux.vinted4j.model.vinted.item.Brand;
import me.rochblondiaux.vinted4j.model.vinted.system.Pagination;

import java.util.ArrayList;
import java.util.List;

@Data
public class BrandListResponse extends VintedResponse {

    private List<Brand> brands = new ArrayList<>();
    private Pagination pagination;
}
