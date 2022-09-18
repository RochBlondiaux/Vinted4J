package me.rochblondiaux.vinted4j.http.request.transactions;

import lombok.RequiredArgsConstructor;
import me.rochblondiaux.vinted4j.VintedClient;
import me.rochblondiaux.vinted4j.http.request.GetRequest;
import me.rochblondiaux.vinted4j.http.response.transactions.ViewTransactionResponse;

@RequiredArgsConstructor
public class ViewTransactionRequest extends GetRequest<ViewTransactionResponse> {

    private final long transactionId;

    @Override
    public String endpoint(VintedClient client) {
        return "transactions/%d".formatted(transactionId);
    }

    @Override
    public Class<ViewTransactionResponse> responseType() {
        return ViewTransactionResponse.class;
    }
}
