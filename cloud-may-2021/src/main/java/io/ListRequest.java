package io;

import lombok.Data;

@Data
public class ListRequest implements Message{
    @Override
    public MessageType getType() {
        return MessageType.LIST_REQUEST;
    }
}
