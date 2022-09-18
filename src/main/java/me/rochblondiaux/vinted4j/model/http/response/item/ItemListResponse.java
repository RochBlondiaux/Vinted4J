package me.rochblondiaux.vinted4j.model.http.response.item;

import lombok.Data;
import me.rochblondiaux.vinted4j.model.http.response.VintedResponse;
import me.rochblondiaux.vinted4j.model.vinted.item.Item;
import me.rochblondiaux.vinted4j.model.vinted.system.Pagination;

import java.util.ArrayList;
import java.util.List;

@Data
public class ItemListResponse extends VintedResponse {

    private List<Item> items = new ArrayList<>();
    private List<Item> drafts = new ArrayList<>();
    private Pagination pagination;
}
