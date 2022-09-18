package me.rochblondiaux.vinted4j.model.market.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import me.rochblondiaux.vinted4j.model.catalog.item.Item;
import me.rochblondiaux.vinted4j.model.market.PackageSize;

import java.util.List;

@Data
public class Order {

    private long id;
    private int status;
    @JsonProperty("package_size_id")
    private int packageSizeId;
    @JsonProperty("custom_shipment_price")
    private Object customShipmentPrice;
    private Object currency;
    @JsonProperty("item_ids")
    private List<Long> itemIds;
    @JsonProperty("package_size_selected")
    private boolean packageSizeSelected;
    @JsonProperty("transaction_id")
    private long transactionId;
    @JsonProperty("user_msg_thread_id")
    private long userMsgThreadId;
    @JsonProperty("custom_shipment")
    private boolean customShipment;
    private String title;
    @JsonProperty("item_count")
    private int itemCount;
    private List<Item> items;
    @JsonProperty("package_size")
    private PackageSize packageSize;
    private boolean reserved;

}
