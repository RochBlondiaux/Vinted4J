package me.rochblondiaux.vinted4j.model.market.transactions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import me.rochblondiaux.vinted4j.model.market.BuyerDebit;
import me.rochblondiaux.vinted4j.model.market.Shipment;
import me.rochblondiaux.vinted4j.model.market.offer.Offer;
import me.rochblondiaux.vinted4j.model.market.offer.OfferRequestOptions;
import me.rochblondiaux.vinted4j.model.user.Discount;
import me.rochblondiaux.vinted4j.model.user.User;
import org.apache.logging.log4j.core.config.Order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Transaction {

    private long id;
    @JsonProperty("user_msg_thread_id")
    private long msgThreadId;
    @JsonProperty("seller_id")
    private int sellerId;
    @JsonProperty("buyer_id")
    private int buyerId;
    @JsonProperty("item_id")
    private long itemId;
    @JsonProperty("order_id")
    private long orderId;
    @JsonProperty("removed_item_title")
    private Object removedItemTitle;
    @JsonProperty("first_offer_id")
    private long firstOfferId;
    @JsonProperty("offer_id")
    private long offerId;
    @JsonProperty("voucher_id")
    private long voucherId;
    private int status;
    @JsonProperty("status_updated_at")
    private Date statusUpdatedAt;
    @JsonProperty("debit_processed_at")
    private Date debitProcessedAt;
    @JsonProperty("sent_notices")
    private String sentNotices;
    @JsonProperty("created_at")
    private Date createdAt;
    @JsonProperty("updated_at")
    private Date updatedAt;
    @JsonProperty("shipment_id")
    private long shipmentId;
    @JsonProperty("carrier_id")
    private int carrierId;
    @JsonProperty("custom_carrier")
    private boolean customCarrier;
    @JsonProperty("transaction_completion_id")
    private long completionId;
    @JsonProperty("max_meeting_date")
    private Date max_meeting_date;
    @JsonProperty("meet_and_pickup")
    private boolean meetAndPickupAvailable;
    private boolean reuploaded;
    @JsonProperty("buyer_debit_id")
    private long buyerDebitId;
    @JsonProperty("suspending_complaint_id")
    private long suspendingComplaintId;
    @JsonProperty("buyer_phone_number")
    private String buyerPhoneNumber;
    private boolean selected;
    private User buyer;
    private User seller;
    private Order order;
    private Offer offer;
    private Offer first_offer;
    private Shipment shipment;
    @JsonProperty("shipment_summary_label")
    private String shipmentSummaryLabel;
    @JsonProperty("buyer_debit")
    private BuyerDebit buyerDebit;
    private Object authenticity_check;
    private Object voucher;
    @JsonProperty("pay_in_method_id")
    private int payInMethodId;
    @JsonProperty("transaction_completion")
    private Date completion;
    @JsonProperty("status_title")
    private String statusTitle;
    @JsonProperty("user_side")
    private String userSide;
    @JsonProperty("transaction_checksum")
    private String checksum;
    @JsonProperty("available_discounts")
    private List<Discount> availableDiscounts = new ArrayList<>();
    @JsonProperty("items_count")
    private int items;
    private String title;
    @JsonProperty("item_title")
    private String itemTitle;
    @JsonProperty("available_actions")
    private List<String> availableActions = new ArrayList<>();
    @JsonProperty("offer_request_options")
    private OfferRequestOptions offerRequestOptions;
}
